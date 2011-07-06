/*
 * @(#)Local.java
 *
 * Copyright (c) 2002 Nokia Mobile Phones. All Rights Reserved.
 */

//WARNING: If there exists a number in the MIDLet-abbreviation or package name
//         there could appear errors in the following line!
package com.nokia.mid.appl.cmd;

import br.org.indt.ndg.mobile.settings.LanguageHandler;
import java.io.*;

/**
* The Local class constructor sets the localisation language. The localisation language is the
* language into which the internationalised texts, i.e. text ids are replaced by
* the concrete strings in the target language.
* <br>
* The localisation language is normally the phone language which is selected by the user
* provided that this language will also be supported by the MIDlet. In case that the phone
* language is not supported by the MIDlet, all texts are localised in <b>english</b>.
* <p>
* Additionally, the Local class provides the methods for the localisation, i.e. the translation of
* logical text ids to the localised strings. This includes also the replacement of formal parameters
* in the localised texts by the concrete values.
* <p>
* @author 	Dieter H?ner, Ralf Engels, Mathias Gaupp
* @version	0.6 28-Oct-2004 Local.java is now generated by Nokia-I18N-Tool.
* @version	0.5 16-Feb-2003 Small improvements concerning mark and reset.
* @version	0.4 27-Aug-2003 Support mark and reset.
* @version	0.3 05-Aug-2002 Local.java is now generated by MIDlet_dat2lan.
* @version	0.2 02-Aug-2002 Improvement for localization.
* @version	0.1 30-Apr-2002 Initial version
*/
public class Local {


    /**
     * Class object representing the Local object.
     * Only used for internal help when an object reference is needed.
     */
    private static Local loc = null;

    /** Data input stream used for reading texts.
     *  Only DataInputStreams supporting mark are stored.
     */
    private static DataInputStream dis = null;

    public final static short QTJ_CMD_BACK = 0;
    public final static short QTJ_CMD_SEND = 1;
    public final static short QTJ_OPEN_RESULT = 2;
    public final static short QTJ_CMD_DELETE = 3;
    public final static short QTJ_CMD_SAVE = 4;
    public final static short QTJ_CMD_EXIT = 5;
    public final static short QTJ_CMD_NEW_SURVEY = 6;
    public final static short QTJ_CMD_RESULTS = 7;
    public final static short QTJ_CMD_NEXT = 8;
    public final static short QTJ_CMD_VIEW = 9;
    public final static short QTJ_CMD_VIEWSENT = 10;
    public final static short QTJ_CMD_MARKALL = 11;
    public final static short QTJ_CMD_UNMARKALL = 12;
    public final static short QTJ_CMD_CANCEL = 13;
    public final static short QTJ_CMD_MOVETOUNSENT = 14;
    public final static short QTJ_CMD_OK = 15;
    public final static short QTJ_RESULTS_LIST_TITLE = 16;
    public final static short QTJ_SENT_LIST_TITLE = 17;
    public final static short QTJ_CATEGORY_LIST_TITLE = 18;
    public final static short QTJ_SETTINGS = 19;
    public final static short QTJ_GPS = 20;
    public final static short QTJ_SUBMIT_SERVER = 21;
    public final static short QTJ_YES = 22;
    public final static short QTJ_NO = 23;
    public final static short QTJ_SURVEY_LIST_TITLE = 24;
    public final static short QTJ_MSG_SERVER_CANT_WRITE_RESULTS = 25;
    public final static short QTJ_ELOAD_SURVEYS = 26;
    public final static short QTJ_ELOAD_RESULTS = 27;
    public final static short QTJ_EDELETE_RESULT = 28;
    public final static short QTJ_ELEAVE_MIDLET = 29;
    public final static short QTJ_ELOAD_IMAGES = 30;
    public final static short QTJ_EPARSE_SAX = 31;
    public final static short QTJ_EPARSE_SURVEY = 32;
    public final static short QTJ_EPARSE_RESULT = 33;
    public final static short QTJ_EPARSE_GENERAL = 34;
    public final static short QTJ_EWRITE_RESULT = 35;
    public final static short QTJ_ECREATE_RESULT = 36;
    public final static short QTJ_ERENAME = 37;
    public final static short QTJ_ON = 38;
    public final static short QTJ_OFF = 39;
    public final static short QTJ_GPS_LOCATION = 40;
    public final static short QTJ_SMALL = 41;
    public final static short QTJ_MEDIUM = 42;
    public final static short QTJ_LARGE = 43;
    public final static short QTJ_LOADING_SURVEY = 44;
    public final static short QTJ_PROCESSING = 45;
    public final static short QTJ_LOADING_RESULTS = 46;
    public final static short QTJ_SAVING_RESULT = 47;
    public final static short QTJ_CMD_OPEN = 48;
    public final static short QTJ_CMD_DOWNLOAD = 49;
    public final static short QTJ_DOWNLOAD_NEW_SURVEYS = 50;
    public final static short QTJ_CHECK_NEW_SURVEYS = 51;
    public final static short QTJ_CONNECTING = 52;
    public final static short QTJ_DOWNLOADING_NEW_SURVEYS = 53;
    public final static short QTJ_EWEBSERVER_ERROR = 54;
    public final static short QTJ_EDOWNLOAD_FAILED_ERROR_CODE = 55;
    public final static short QTJ_EDOWNLOAD_FAILED_INVALID_MIME_TYPE = 56;
    public final static short QTJ_EDOWNLOAD_FAILED_INVALID_DATA = 57;
    public final static short QTJ_EDOWNLOAD_INCOMPLETED = 58;
    public final static short QTJ_EDOWNLOAD_ACK_ERROR = 59;
    public final static short QTJ_EINVALID_SURVEYS = 60;
    public final static short QTJ_EINVALID_XML_FILE = 61;
    public final static short QTJ_CMD_DELETE_SURVEY = 62;
    public final static short QTJ_DELETE_CONFIRMATION = 63;
    public final static short QTJ_DELETE_RESULTS_CONFIRMATION = 64;
    public final static short QTJ_DELETE_SURVEY_CONFIRMATION = 65;
    public final static short QTJ_IMPOSSIBLE_CREATE_ROOTDIR = 66;
    public final static short QTJ_ERROR_TITLE = 67;
    public final static short QTJ_GPS_LOCAL = 68;
    public final static short QTJ_CONNECTED = 69;
    public final static short QTJ_LATITUDE = 70;
    public final static short QTJ_LONGITUDE = 71;
    public final static short QTJ_ALTITUDE = 72;
    public final static short QTJ_HORIZONTAL_ACCU = 73;
    public final static short QTJ_VERTICAL_ACCU = 74;
    public final static short QTJ_NETWORK_FAILURE = 75;
    public final static short QTJ_TRY_AGAIN_LATER = 76;
    public final static short QTJ_INTEGER = 77;
    public final static short QTJ_VALUE_GREATER = 78;
    public final static short QTJ_VALUE_LOWER = 79;
    public final static short QTJ_SURVEY_NOT_IN_SERVER = 80;
    public final static short QTJ_MORE_DETAILS = 81;
    public final static short QTJ_EINVALID_SURVEY = 82;
    public final static short QTJ_DELETE_RESULT_CONFIRMATION = 83;
    public final static short QTJ_QUESTION = 84;
    public final static short QTJ_QUESTIONS = 85;
    public final static short QTJ_CHECK_FOR_UPDATE = 86;
    public final static short QTJ_WARNING = 87;
    public final static short QTJ_CMD_VIEW_GPS_DETAILS = 88;
    public final static short QTJ_SURVEY_NOT_DOWNLOADED = 89;
    public final static short QTJ_CMD_TEST_CONNECTION = 90;
    public final static short QTJ_TESTING_CONNECTION = 91;
    public final static short QTJ_CONNECTION_OK = 92;
    public final static short QTJ_CONNECTION_FAILED = 93;
    public final static short QTJ_GPRS_LABEL = 94;
    public final static short QTJ_CMD_HIDE = 95;
    public final static short QTJ_CONNECTION_WAIT_FOR_ACK = 96;
    public final static short QTJ_CMD_SELECT = 97;
    public final static short QTJ_CMD_OPTIONS = 98;
    public final static short QTJ_CHECK_FOR_UPDATE_TITLE = 99;
    public final static short QTJ_NDG_UPDATED = 100;
    public final static short QTJ_NDG_NOT_UPDATED = 101;
    public final static short QTJ_DECIMAL = 102;
    public final static short QTJ_DATE = 103;
    public final static short QTJ_NEW_INTERVIEW = 104;
    public final static short QTJ_EDITING = 105;
    public final static short QTJ_TRY_AGAIN = 106;
    public final static short QTJ_REGISTERING_APP = 107;
    public final static short QTJ_REGISTRATION_DONE = 108;
    public final static short QTJ_APP_REGISTERED = 109;
    public final static short QTJ_NDG_CHECK_NTWRK = 110;
    public final static short QTJ_NDG_NO_ROUTE = 111;
    public final static short QTJ_NDG_SOFTWARE_ABORT = 112;
    public final static short QTJ_NDG_CONNECTION_REFUSED = 113;
    public final static short QTJ_NDG_PERMISSION_DENIED = 114;
    public final static short QTJ_NDG_NETWORK_DOWN = 115;
    public final static short QTJ_NDG_NETWORK_UNREACHABLE = 116;
    public final static short QTJ_NDG_CONNECTION_TIMEOUT = 117;
    public final static short QTJ_NDG_NETWORK_UNAVAILABLE = 118;
    public final static short QTJ_NDG_HOST_NOT_FOUND = 119;
    public final static short QTJ_HTTP_NOT_FOUND = 120;
    public final static short QTJ_HTTP_FORBIDDEN = 121;
    public final static short QTJ_HTTP_BAD_REQUEST = 122;
    public final static short QTJ_HTTP_UNAUTHORIZED = 123;
    public final static short QTJ_HTTP_INTERNAL_ERROR = 124;
    public final static short QTJ_HTTP_OVERLOADED = 125;
    public final static short QTJ_CHECK_SERVER = 126;
    public final static short QTJ_FAILED = 127;
    public final static short QTJ_NDG_NO_DNS = 128;
    public final static short QTJ_NDG_NO_LOCATION = 129;
    public final static short QTJ_IMEI_ALREADY_EXISTS = 130;
    public final static short QTJ_MSISDN_NOT_FOUND = 131;
    public final static short QTJ_REGISTRATION_FAILURE = 132;
    public final static short QTJ_MSISDN_ALREADY_REGISTERED = 133;
    public final static short QTJ_WIRELESS_INTERFACE_ERROR = 134;
    public final static short QTJ_THERE_ARE_NO_NEW_SURVEYS = 135;
    public final static short QTJ_NOTPROPERINTEGER = 136;
    public final static short QTJ_NOTPROPRDECIMAL = 137;
    public final static short QTJ_RESTORE_DEFAULT = 138;
    public final static short QTJ_RELOAD = 139;
    public final static short QTJ_LOADING_STYLE = 140;
    public final static short QTJ_LOADING_STYLE_ERROR = 141;
    public final static short QTJ_UI_CUSTOMIZE = 142;
    public final static short QTJ_SELECTED = 143;
    public final static short QTJ_UNSELECTED = 144;
    public final static short QTJ_PREVIEW = 145;
    public final static short QTJ_ELEMENT = 146;
    public final static short QTJ_OBJECT = 147;
    public final static short QTJ_LIST = 148;
    public final static short QTJ_MENU = 149;
    public final static short QTJ_DIALOG_TITLE = 150;
    public final static short QTJ_BG_SELECTED = 151;
    public final static short QTJ_BG_UNSELECTED = 152;
    public final static short QTJ_FONT_SELECTED = 153;
    public final static short QTJ_FONT_UNSELECTED = 154;
    public final static short QTJ_ACCESS_DENIED = 155;
    public final static short QTJ_LOAD_FROM_FILE = 156;
    public final static short QTJ_MEMORY_OUT = 157;
    public final static short QTJ_DEFAULT_PHOTO_DIR = 158;
    public final static short QTJ_CAPTURE_PHOTO = 159;
    public final static short QTJ_DELETE_PHOTO = 160;
    public final static short QTJ_PHOTO_RESOLUTION = 161;
    public final static short QTJ_SHOW_PHOTO = 162;
    public final static short QTJ_TAKE_PHOTO = 163;
    public final static short QTJ_JUST_SAVE = 164;
    public final static short QTJ_UI_PREFERENCES = 165;
    public final static short QTJ_GEO_TAGGING_CONF = 166;
    public final static short QTJ_MAX_IMG_NO = 167;
    public final static short QTJ_RESOLUTIONS = 168;
    public final static short QTJ_DEFAULT = 169;
    public final static short QTJ_HIGH_CONTRAST = 170;
    public final static short QTJ_CUSTOM = 171;
    public final static short QTJ_STYLES = 172;
    public final static short QTJ_TIME_FORMAT_ERROR = 173;
    public final static short QTJ_DATE_FORMAT_ERROR = 174;
    public final static short QTJ_DISCARD_CHANGES = 175;
    public final static short QTJ_ENCRYPTION = 176;
    public final static short QTJ_ENCRYPTION_ENABLE = 177;
    public final static short QTJ_ENCRYPTION_WITH_PASSWORD = 178;
    public final static short QTJ_ENCRYPTION_PASSWORD = 179;
    public final static short QTJ_DECRYPTION_FAILED = 180;
    public final static short QTJ_EMPTY_KEY = 181;
    public final static short QTJ_WRONG_KEY = 182;
    public final static short QTJ_SAVE_SURVEY_QUESTION = 183;
    public final static short QTJ_ADD_LOCATION_FAILURE = 184;
    public final static short QTJ_LOCATION_OUT_OF_DATE = 185;
    public final static short QTJ_LOCATION_OUT_OF_DATE_WARN = 186;
    public final static short QTJ_NEWUI_NOKIA_DATA_GATHERING = 187;
    public final static short QTJ_DATE_FORMAT = 188;
    public final static short QTJ_AVAILABLE_DATE_FORMAT = 189;
    public final static short QTJ_OR_FORM_LOADING_FAILURE = 190;
    public final static short QTJ_OR_VALID_INPUT_FROM = 191;
    public final static short QTJ_TO = 192;
    public final static short QTJ_OR_INVALID_INPUT = 193;
    public final static short QTJ_SEND_ERRORS = 194;
    public final static short QTJ_RESULT_NOT_SENT = 195;
    public final static short QTJ_REMOVE_CATEGORIES = 196;
    public final static short QTJ_CATEGORIES_LIMIT = 197;
    public final static short QTJ_ADD_CATEGORIES = 198;
    public final static short QTJ_ADD_ADDITIONAL_COPIES = 199;
    public final static short QTJ_FAIL_IMAGE_SAVE = 200;
    public final static short QTJ_OUT_OF_MEMORY = 201;
    public final static short QTJ_NOT_ENOUGH_MEMORY = 202;
    public final static short QTJ_CATEGORY_DISABLE = 203;
    public final static short QTJ_SUB_CATEGORY = 204;
    public final static short QTJ_AVAILABLE_STYLES = 205;
    public final static short QTJ_AVAILABLE_FONT_SIZE = 206;
    public final static short QTJ_UNSUPPORTED_TYPE = 207;
    public final static short QTJ_SURVEY_LOCALIZED = 208;
    public final static short QTJ_CORRUPTED_SURVEY = 209;
    public final static short QTJ_ONE_SURVEY_CORRUPTED = 210;
    public final static short QTJ_CONDITION = 211;
    public final static short QTJ_EFAILED_LOAD_IMAGE_LIMITED_DEVICE_RESOURCES = 212;
    public final static short QTJ_SHOW_CHOICES = 213;
    public final static short QTJ_NATIVE_RESOLUTION = 214;
    public final static short QTJ_CMD_COLORS = 215;
    public final static short QTJ_CMD_SIZES = 216;
    public final static short QTJ_CMD_CLEAR = 217;

    public static String phoneLang = System.getProperty("microedition.locale");

    /**
     * Generates a Local object.
     * Only for internal use.
     */
    private Local() {
      ; // do nothing
    }

    static {
        LanguageHandler handler = new LanguageHandler();
        phoneLang = handler.getLanguage();
    }


    /**
     * The method replaces a substring by another one.
     * @param source  source string in which the replacement will take place
     * @param replace substring to be replaced
     * @param by      replacing substring
     */
    public static String replace( String source, String replace, String by ) {

        int place;

        do {
            // begin of substring to be replaced
            place = source.indexOf(replace);

            // return new string after replacement
            if( place >= 0 )
                source = source.substring(0, place) + by + source.substring(place+replace.length());
        } while( place >=0 );

        return source;
    }


    /**
     * The method translates the logical text id to the localized string.     * @param ltid         logical text id (internationalised form) of text that has to be localised
     */
    public static synchronized String getText(int ltid) {
        return getText( ltid, null );
    }



    /**
     * The method translates the logical text id to the localised string.
     * This includes also the replacement of formal parameters in the localized
     * text by the concrete value.
     * @param ltid         logical text id (internationalised form) of text that has to be localized
     * @param p                Array of strings that replace the formal parameters in the localized text
     */
    public static synchronized String getText(int ltid, String p[]) {

        try {

            // create Local object if necessary
            if (loc == null)
                loc = new Local();

            if( dis == null ) {
                // open resource file depending on the localisation language
                InputStream is = loc.getClass().getResourceAsStream("/resources/text/lang."+phoneLang.substring(0,2));
                if( is == null )
                    is = loc.getClass().getResourceAsStream("/resources/text/lang.en");

                if (is == null)
                    return "X";

                dis = new DataInputStream(is);

                dis.mark( 512 ); // try to mark
            }

            // get the localised text depending on logical text id and the localisation language

            // first get offset
            dis.skipBytes(ltid*2);
            short offset = dis.readShort();

            dis.skipBytes(offset-ltid*2-2);
            String str = dis.readUTF();

            // throw away the data input stream if it does not reset
            if( !dis.markSupported() ) {
                dis.close();
                dis = null;
            } else {
                try {
                    dis.reset();
                } catch(IOException ex) {
                    dis.close();
                    dis = null;
                }
            }

            // replace all formal parameters by correct substrings
            if( p!=null ) {
                if (p.length == 1)
                    str = replace( str, "%U", p[0]);
                else
                    for( int i=0; i<p.length; i++ )
                        str = replace( str, "%"+i+"U", p[i] );
            }

            // return localised text
            return str;

        } catch(IOException ex) {
            dis = null;
            return "E";
        }
    }
}
