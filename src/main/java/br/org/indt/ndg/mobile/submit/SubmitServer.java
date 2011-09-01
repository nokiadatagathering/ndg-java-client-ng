package br.org.indt.ndg.mobile.submit;

import br.org.indt.ndg.lwuit.control.AES;
import br.org.indt.ndg.lwuit.control.ExitCommand;
import br.org.indt.ndg.lwuit.ui.GeneralAlert;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import br.org.indt.ndg.mobile.AppMIDlet;
import br.org.indt.ndg.mobile.NdgConsts;
import br.org.indt.ndg.mobile.Resources;
import br.org.indt.ndg.mobile.ResultList;
import br.org.indt.ndg.mobile.SurveyList;
import br.org.indt.ndg.mobile.Utils;
import br.org.indt.ndg.mobile.logging.Logger;
import java.util.Hashtable;

public class SubmitServer {
    //These values are set in Settings.xml
    private static final int SERVER_CANNOT_WRITE_RESULT = -1;
    private static final int NO_SURVEY_IN_SERVER = 2;
    private static final int SUCCESS = 1;

    private static final String INPUT_NAME_TAG = "filename";

    private boolean m_canceled = false;
    private String m_servletUrl = "";
    private HttpPostRequest m_currentRequest = null;
    private final Vector m_filesNotSent = new Vector();

    public SubmitServer() {
    }

    public void cancel() {
        m_canceled = true;
        if (m_currentRequest != null) {
            m_currentRequest.cancel();
            m_currentRequest = null;
            m_filesNotSent.removeAllElements();
        }
    }

    public void submitResult(String resultFilename, String surveyId){
        Vector resultsToSend = new Vector();
        resultsToSend.addElement(resultFilename);
        send(resultsToSend, surveyId);
    }

    public void submit( Vector resultFilenames, String surveyId ) {
        send(resultFilenames, surveyId);
    }

    private void send(Vector resultFilenames, String surveyId){
        m_servletUrl = AppMIDlet.getInstance().getSettings().getStructure().getServerUrl();
        Enumeration e = resultFilenames.elements();
        m_filesNotSent.removeAllElements();
        while ( e.hasMoreElements() && !m_canceled ) {
            String filename = null;
            String fileContents = "";
            filename = (String) e.nextElement();
            try {
                fileContents = loadFile(filename);
            } catch (IOException ioe) {
                m_filesNotSent.addElement(filename);
                continue;
            }
            if ( fileContents == null || fileContents.equals("") ) {
                m_filesNotSent.addElement(filename);
                continue;
            }

            byte[] response;
            try {
                Hashtable params = new Hashtable();
                params.put("surveyId", surveyId);
                HttpPostRequest request =  new HttpMultipartPostRequest( m_servletUrl, params,
                                INPUT_NAME_TAG, filename, "text/xml", fileContents.getBytes(), surveyId);

                response = request.send();

                int responseCode = response[0];
                processResult(filename, responseCode);
            } catch (IOException ioe) {
                if (!m_canceled){
                    GeneralAlert.getInstance().addCommand(GeneralAlert.DIALOG_OK, true);
                    GeneralAlert.getInstance().showCodedAlert( Resources.NETWORK_FAILURE,
                                                               ioe.getMessage() != null ? ioe.getMessage().trim() : "",
                                                               GeneralAlert.ALARM );
                    break;
                }
            }
        }
        if ( !m_filesNotSent.isEmpty() ) {
            StringBuffer filesNotSentFormatted = new StringBuffer();
            for ( int i = 0; i < m_filesNotSent.size(); i++ ) {
                filesNotSentFormatted.append((String) m_filesNotSent.elementAt(i)).append("\n");
            }
            GeneralAlert.getInstance().addCommand(GeneralAlert.DIALOG_OK, true);
            GeneralAlert.getInstance().show(Resources.SEND_ERRORS,
                    Resources.RESULT_NOT_SENT + ":\n" + filesNotSentFormatted,
                    GeneralAlert.ALARM);
        }
        AppMIDlet.getInstance().setResultList(new ResultList());
        AppMIDlet.getInstance().setDisplayable(br.org.indt.ndg.lwuit.ui.ResultList.class);
    }

    private String loadFile(String _filename) throws IOException {
        String fileContents = "";
        FileConnection fc = null;
        DataInputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
            String surveyRoot = AppMIDlet.getInstance().getFileSystem().getSurveyDirName();
            // result without binary data (if there is no binary data in the survey then it is the complete result file)
            String pathToSurveyWithoutBinary = AppMIDlet.getInstance().getRootDir() + surveyRoot + _filename;
            // result with binary data (possibly big very file), is available only if binary data actually exists in the survey
            String pathToSurveyWithData = AppMIDlet.getInstance().getRootDir() + surveyRoot + "b_" + _filename + "/" + "b_" + _filename;
            // try to open file with binary data, if it does not exist open result without binary data
            fc = (FileConnection) Connector.open( pathToSurveyWithData );
            if ( fc.exists() ) {
                Logger.getInstance().emul("Sending file with binary data", "");
            } else {
                fc = (FileConnection) Connector.open( pathToSurveyWithoutBinary );
                Logger.getInstance().emul("Sending file without binary data", "");
            }

            boolean encryption = false;
            if(AppMIDlet.getInstance().getSettings() != null) {
                if( AppMIDlet.getInstance().getSettings().getStructure().isEncryptionConfigured() )
                    encryption = AppMIDlet.getInstance().getSettings().getStructure().getEncryption();
            }

            inputStream = fc.openDataInputStream();

            if( encryption ) {
                AES encrypter = new AES();
                try {
                    inputStream = new DataInputStream( encrypter.decryptInputStreamToInputStream( inputStream ) );
                } catch (Exception e) {
                    GeneralAlert.getInstance().addCommand( ExitCommand.getInstance());
                    GeneralAlert.getInstance().show(Resources.ERROR_TITLE, Resources.WRONG_KEY, GeneralAlert.ERROR );
                }
            }

            outputStream = new ByteArrayOutputStream();

            int data = inputStream.read();
            while (data != -1) {
                outputStream.write((byte) data);
                data = inputStream.read();
            }
            fileContents = outputStream.toString();
        } finally {
                if (inputStream != null)
                    inputStream.close();
                if (outputStream != null)
                    outputStream.close();
                if (fc != null)
                    fc.close();
        }
        return fileContents;
    }

    private void processResult(String filename, int in) {
        if ( in == SUCCESS ) {
            // do nothing
        } else if(in == SERVER_CANNOT_WRITE_RESULT) {
            if (!m_canceled) {
                m_filesNotSent.addElement(filename);
                GeneralAlert.getInstance().addCommand(GeneralAlert.DIALOG_OK, true);
                GeneralAlert.getInstance().show( Resources.NETWORK_FAILURE, Resources.TRY_AGAIN_LATER , GeneralAlert.ALARM );
            }
        } else if (in == NO_SURVEY_IN_SERVER) {
           GeneralAlert.getInstance().addCommand( GeneralAlert.DIALOG_OK, true);
           GeneralAlert.getInstance().show(Resources.ERROR_TITLE, Resources.SURVEY_NOT_IN_SERVER, GeneralAlert.ERROR);
           AppMIDlet.getInstance().setSurveyList(new SurveyList());
           AppMIDlet.getInstance().setDisplayable(br.org.indt.ndg.lwuit.ui.SurveyList.class);
        } else {
            /*
             * Just move as sent if user do not previously canceled the process.
             * In some cases, some files will reach the server, but for reliability they will be
             * kept in the mobile as not sent.
             */
            AppMIDlet.getInstance().getFileSystem().moveSentResult(filename);
        }
    }
}
