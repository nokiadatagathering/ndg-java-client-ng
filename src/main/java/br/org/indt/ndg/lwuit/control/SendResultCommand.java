package br.org.indt.ndg.lwuit.control;

import br.org.indt.ndg.lwuit.ui.StatusScreen;
import br.org.indt.ndg.mobile.AppMIDlet;
import br.org.indt.ndg.mobile.FileSystem;
import br.org.indt.ndg.mobile.Resources;
import br.org.indt.ndg.mobile.submit.SubmitResultRunnable;
import br.org.indt.ndg.mobile.submit.SubmitServer;
import com.sun.lwuit.Command;

/**
 *
 * @author mluz
 */
public class SendResultCommand extends CommandControl {

    private static SendResultCommand instance;

    protected Command createCommand() {
        return new Command(Resources.NEWUI_SEND_RESULTS);
    }

    protected void doAction(Object parameter) {
        AppMIDlet.getInstance().getFileSystem().useResults(FileSystem.USE_NOT_SENT_RESULTS);
        SubmitResultRunnable srr = new SubmitResultRunnable(AppMIDlet.getInstance().getFileSystem().getResultFilename(),AppMIDlet.getInstance().getFileSystem().getCurrentSurveyId());
        AppMIDlet.getInstance().setSubmitServer( new SubmitServer() );
        srr.setSubmitServer( AppMIDlet.getInstance().getSubmitServer() );
        AppMIDlet.getInstance().setDisplayable(StatusScreen.class );
        try { Thread.sleep(500); } catch (InterruptedException ex) {}
        Thread t = new Thread(srr);
        t.start();
    }

    public static SendResultCommand getInstance() {
        if (instance == null)
            instance = new SendResultCommand();
        return instance;
    }
}