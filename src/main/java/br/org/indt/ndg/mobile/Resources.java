package br.org.indt.ndg.mobile;

import br.org.indt.ndg.lwuit.control.ExitCommand;
import br.org.indt.ndg.lwuit.ui.GeneralAlert;
import java.io.IOException;
import com.nokia.mid.appl.cmd.Local;
import com.sun.lwuit.Image;

public class Resources {

    /** Internationalized Resources */
    //****************************************************************************
    public static final String SAVE_SURVEY_QUESTION = Local.getText(Local.QTJ_SAVE_SURVEY_QUESTION);
    public static final String ADD_LOCATION_FAILURE = Local.getText(Local.QTJ_ADD_LOCATION_FAILURE);
    public static final String LOCATION_OUT_OF_DATE = Local.getText(Local.QTJ_LOCATION_OUT_OF_DATE);
    public static final String LOCATION_OUT_OF_DATE_WARN = Local.getText(Local.QTJ_LOCATION_OUT_OF_DATE_WARN);
    public static final String NEWUI_NOKIA_DATA_GATHERING = Local.getText(Local.QTJ_NEWUI_NOKIA_DATA_GATHERING);
    public static final String DATE_FORMAT = Local.getText(Local.QTJ_DATE_FORMAT);
    public static final String AVAILABLE_DATE_FORMAT = Local.getText(Local.QTJ_AVAILABLE_DATE_FORMAT);
    public static final String OR_FORM_LOADING_FAILURE = Local.getText(Local.QTJ_OR_FORM_LOADING_FAILURE);

    public static final String OR_VALID_INPUT_FROM = Local.getText(Local.QTJ_OR_VALID_INPUT_FROM);
    public static final String TO = Local.getText(Local.QTJ_TO);
    public static final String OR_INVALID_INPUT = Local.getText(Local.QTJ_OR_INVALID_INPUT);
    public static final String SEND_ERRORS = Local.getText(Local.QTJ_SEND_ERRORS);
    public static final String RESULT_NOT_SENT = Local.getText(Local.QTJ_RESULT_NOT_SENT);
    public static final String REMOVE_CATEGORIES = Local.getText(Local.QTJ_REMOVE_CATEGORIES);
    public static final String CATEGORIES_LIMIT = Local.getText(Local.QTJ_CATEGORIES_LIMIT);
    public static final String ADD_CATEGORIES = Local.getText(Local.QTJ_ADD_CATEGORIES);
    public static final String ADD_ADDITIONAL_COPIES = Local.getText(Local.QTJ_ADD_ADDITIONAL_COPIES);
    public static final String FAIL_IMAGE_SAVE = Local.getText(Local.QTJ_FAIL_IMAGE_SAVE);
    public static final String OUT_OF_MEMORY = Local.getText(Local.QTJ_OUT_OF_MEMORY);

    public static final String NOT_ENOUGH_MEMORY = Local.getText(Local.QTJ_NOT_ENOUGH_MEMORY);
    public static final String CATEGORY_DISABLE = Local.getText(Local.QTJ_CATEGORY_DISABLE);
    public static final String SUB_CATEGORY = Local.getText(Local.QTJ_SUB_CATEGORY);
    public static final String AVAILABLE_STYLES = Local.getText(Local.QTJ_AVAILABLE_STYLES);
    public static final String AVAILABLE_FONT_SIZE = Local.getText(Local.QTJ_AVAILABLE_FONT_SIZE);
    public static final String UNSUPPORTED_TYPE = Local.getText(Local.QTJ_UNSUPPORTED_TYPE);
    public static final String SURVEY_LOCALIZED = Local.getText(Local.QTJ_SURVEY_LOCALIZED);
    public static final String CORRUPTED_SURVEY = Local.getText(Local.QTJ_CORRUPTED_SURVEY);
    public static final String ONE_SURVEY_CORRUPTED = Local.getText(Local.QTJ_ONE_SURVEY_CORRUPTED);
    public static final String CONDITION = Local.getText(Local.QTJ_CONDITION);

    //public static final String NEWUI_TITLE_SURVEY_LIST = "List of Surveys";
    //public static final String NEWUI_TITLE_CATEGORIES = "Categories";
    //public static final String NEWUI_TITLE_RESULTS = "Results";
    public static final String NEWUI_OPTIONS = Local.getText(Local.QTJ_CMD_OPTIONS);
    public static final String NEWUI_SELECT = Local.getText(Local.QTJ_CMD_SELECT);
    public static final String NEWUI_CANCEL = Local.getText(Local.QTJ_CMD_CANCEL);
    public static final String NEWUI_BACK = Local.getText(Local.QTJ_CMD_BACK);
    public static final String NEWUI_NEXT = Local.getText(Local.QTJ_CMD_NEXT);
    public static final String NEWUI_NEW_RESULT = Local.getText(Local.QTJ_CMD_NEW_SURVEY);
    public static final String NEWUI_OPEN_RESULT = Local.getText(Local.QTJ_OPEN_RESULT);
    public static final String NEWUI_VIEW_RESULT = Local.getText(Local.QTJ_CMD_VIEW);
    public static final String NEWUI_SEND_RESULTS = Local.getText(Local.QTJ_CMD_SEND);
    public static final String NEWUI_DELETE_RESULTS = Local.getText(Local.QTJ_CMD_DELETE);
    public static final String NEWUI_VIEW_SENT_RESULTS = Local.getText(Local.QTJ_CMD_VIEWSENT);
    public static final String NEWUI_DELETE_CURRENT_RESULT = Local.getText(Local.QTJ_CMD_DELETE);
    public static final String NEW_IU_OK = Local.getText(Local.QTJ_CMD_OK);
    //****************************************************************************
    public static final String DELETE_SURVEY = Local.getText(Local.QTJ_CMD_DELETE_SURVEY);
    public static final String CHECK_NEW_SURVEYS = Local.getText(Local.QTJ_CHECK_NEW_SURVEYS);
    public static final String DOWNLOAD = Local.getText(Local.QTJ_CMD_DOWNLOAD);
    public static final String SETTINGS = Local.getText(Local.QTJ_SETTINGS);
    public static final String GPS = Local.getText(Local.QTJ_GPS);
    //public static final String NO_SURVEY_IN_SERVER = Local.getText(Local.QTJ_NO_SURVEY_IN_SERVER);
    public static final String CMD_DELETE = Local.getText(Local.QTJ_CMD_DELETE);
    public static final String CMD_SAVE = Local.getText(Local.QTJ_CMD_SAVE);
    public static final String CMD_VIEW = Local.getText(Local.QTJ_CMD_VIEW);
    public static final String RESULTS_LIST_TITLE = Local.getText(Local.QTJ_RESULTS_LIST_TITLE);
    public static final String SENT_LIST_TITLE = Local.getText(Local.QTJ_SENT_LIST_TITLE);
    public static final String CATEGORY_LIST_TITLE = Local.getText(Local.QTJ_CATEGORY_LIST_TITLE);
    public static final String SURVEY_LIST_TITLE = Local.getText(Local.QTJ_SURVEY_LIST_TITLE);
    public static final String QUESTIONS = Local.getText(Local.QTJ_QUESTIONS);
    public static final String QUESTION = Local.getText(Local.QTJ_QUESTION);
    public static final String LARGE = Local.getText(Local.QTJ_LARGE);
    public static final String MEDIUM = Local.getText(Local.QTJ_MEDIUM);
    public static final String SMALL = Local.getText(Local.QTJ_SMALL);
    public static final String GPSCONFIG = Local.getText(Local.QTJ_GPS_LOCATION);
    public static final String OFF = Local.getText(Local.QTJ_OFF);
    public static final String ON = Local.getText(Local.QTJ_ON);
    public static final String OK = Local.getText(Local.QTJ_CMD_OK);
    public static final String SUBMIT_SERVER = Local.getText(Local.QTJ_SUBMIT_SERVER);
    //these strings are for custom widgets bool1 & bool2
    public static final String YES = Local.getText(Local.QTJ_YES);
    public static final String NO = Local.getText(Local.QTJ_NO);
    public static final String EXIT = Local.getText(Local.QTJ_CMD_EXIT);
    public static final String LOADING_SURVEYS = Local.getText(Local.QTJ_LOADING_SURVEY);
    public static final String PROCESSING = Local.getText(Local.QTJ_PROCESSING);
    public static final String LOADING_RESULTS = Local.getText(Local.QTJ_LOADING_RESULTS);
    public static final String SAVING_RESULT = Local.getText(Local.QTJ_SAVING_RESULT);
    public static final String DOWNLOAD_SURVEYS = Local.getText(Local.QTJ_DOWNLOAD_NEW_SURVEYS);
    public static final String CONNECTING = Local.getText(Local.QTJ_CONNECTING);
    public static final String DOWNLOADING_NEW_SURVEYS = Local.getText(Local.QTJ_DOWNLOADING_NEW_SURVEYS);
    public static final String DELETE_CONFIRMATION = Local.getText(Local.QTJ_DELETE_CONFIRMATION);
    public static final String DELETE_RESULTS_CONFIRMATION = Local.getText(Local.QTJ_DELETE_RESULTS_CONFIRMATION);
    public static final String DELETE_RESULT_CONFIRMATION = Local.getText(Local.QTJ_DELETE_RESULT_CONFIRMATION);
    public static final String DELETE_SURVEY_CONFIRMATION = Local.getText(Local.QTJ_DELETE_SURVEY_CONFIRMATION);
    public static final String IMPOSSIBLE_CREATE_ROOTDIR = Local.getText(Local.QTJ_IMPOSSIBLE_CREATE_ROOTDIR);
    public static final String ERROR_TITLE = Local.getText(Local.QTJ_ERROR_TITLE);
    public static final String GPS_LOCAL = Local.getText(Local.QTJ_GPS_LOCAL);
    public static final String CONNECTED = Local.getText(Local.QTJ_CONNECTED);
    public static final String LATITUDE = Local.getText(Local.QTJ_LATITUDE);
    public static final String LONGITUDE = Local.getText(Local.QTJ_LONGITUDE);
    public static final String ALTITUDE = Local.getText(Local.QTJ_ALTITUDE);
    public static final String HORIZONTAL_ACCU = Local.getText(Local.QTJ_HORIZONTAL_ACCU);
    public static final String VERTICAL_ACCU = Local.getText(Local.QTJ_VERTICAL_ACCU);
    public static final String NETWORK_FAILURE = Local.getText(Local.QTJ_NETWORK_FAILURE);
    public static final String TRY_AGAIN_LATER = Local.getText(Local.QTJ_TRY_AGAIN_LATER);
    public static final String INTEGER = Local.getText(Local.QTJ_INTEGER);
    public static final String VALUE_GREATER = Local.getText(Local.QTJ_VALUE_GREATER);
    public static final String VALUE_LOWER = Local.getText(Local.QTJ_VALUE_LOWER);
    public static final String SURVEY_NOT_IN_SERVER = Local.getText(Local.QTJ_SURVEY_NOT_IN_SERVER);
    public static final String MORE_DETAILS = Local.getText(Local.QTJ_MORE_DETAILS);
    public static final String EINVALID_SURVEY = Local.getText(Local.QTJ_EINVALID_SURVEY);
    public static final String WARNING = Local.getText(Local.QTJ_WARNING);
    public static final String SURVEY_NOT_DOWNLOADED = Local.getText(Local.QTJ_SURVEY_NOT_DOWNLOADED);
    public static final String TESTING_CONNECTION = Local.getText(Local.QTJ_TESTING_CONNECTION);
    public static final String CONNECTION_OK = Local.getText(Local.QTJ_CONNECTION_OK);
    public static final String CONNECTION_FAILED = Local.getText(Local.QTJ_CONNECTION_FAILED);
    public static final String GPRS_LABEL = Local.getText(Local.QTJ_GPRS_LABEL);
    public static final String CONNECTION_WAIT_FOR_ACK = Local.getText(Local.QTJ_CONNECTION_WAIT_FOR_ACK);
    public static final String CHECK_FOR_UPDATE_TITLE = Local.getText(Local.QTJ_CHECK_FOR_UPDATE_TITLE);
    public static final String NDG_UPDATED = Local.getText(Local.QTJ_NDG_UPDATED);
    public static final String NDG_NOT_UPDATED = Local.getText(Local.QTJ_NDG_NOT_UPDATED);
    public static final String DECIMAL = Local.getText(Local.QTJ_DECIMAL);
    public static final String DATE = Local.getText(Local.QTJ_DATE);
    public static final String NEW_INTERVIEW = Local.getText(Local.QTJ_NEW_INTERVIEW);
    public static final String EDITING = Local.getText(Local.QTJ_EDITING);
    public static final String TRY_AGAIN = Local.getText(Local.QTJ_TRY_AGAIN);
    public static final String REGISTERING_APP = Local.getText(Local.QTJ_REGISTERING_APP);
    public static final String REGISTRATION_DONE = Local.getText(Local.QTJ_REGISTRATION_DONE);
    public static final String APP_REGISTERED = Local.getText(Local.QTJ_APP_REGISTERED);
    public static final String CHECK_NETWORK = Local.getText(Local.QTJ_NDG_CHECK_NTWRK);
    public static final String CHECK_SERVER = Local.getText(Local.QTJ_NDG_CHECK_NTWRK);
    public static final String NO_ROUTE_TO_HOST = Local.getText(Local.QTJ_NDG_NO_ROUTE);
    public static final String SOFTWARE_CONN_ABORT = Local.getText(Local.QTJ_NDG_SOFTWARE_ABORT);
    public static final String CONNECTION_REFUSED = Local.getText(Local.QTJ_NDG_CONNECTION_REFUSED);
    public static final String PERMISSION_DENIED = Local.getText(Local.QTJ_NDG_PERMISSION_DENIED);
    public static final String NETWORK_DOWN = Local.getText(Local.QTJ_NDG_NETWORK_DOWN);
    public static final String NETWORK_UNREACHABLE = Local.getText(Local.QTJ_NDG_NETWORK_UNREACHABLE);
    public static final String CONNECTION_TIMEOUT = Local.getText(Local.QTJ_NDG_CONNECTION_TIMEOUT);
    public static final String NETWORK_UNAVAILABLE = Local.getText(Local.QTJ_NDG_NETWORK_UNAVAILABLE);
    public static final String HOST_NOT_FOUND = Local.getText(Local.QTJ_NDG_HOST_NOT_FOUND);
    public static final String HTTP_NOT_FOUND = Local.getText(Local.QTJ_HTTP_NOT_FOUND);
    public static final String HTTP_FORBIDDEN = Local.getText(Local.QTJ_HTTP_FORBIDDEN);
    public static final String HTTP_BAD_REQUEST = Local.getText(Local.QTJ_HTTP_BAD_REQUEST);
    public static final String HTTP_UNAUTHORIZED = Local.getText(Local.QTJ_HTTP_UNAUTHORIZED);
    public static final String HTTP_INTERNAL_ERROR = Local.getText(Local.QTJ_HTTP_INTERNAL_ERROR);
    public static final String HTTP_OVERLOADED = Local.getText(Local.QTJ_HTTP_OVERLOADED);
    public static final String FAILED_REASON = Local.getText(Local.QTJ_FAILED);
    public static final String NO_DNS = Local.getText(Local.QTJ_NDG_NO_DNS);
    public static final String NO_LOCATION = Local.getText(Local.QTJ_NDG_NO_LOCATION);
    public static final String IMEI_ALREADY_EXISTS = Local.getText(Local.QTJ_IMEI_ALREADY_EXISTS);
    public static final String MSISDN_NOT_FOUND = Local.getText(Local.QTJ_MSISDN_NOT_FOUND);
    public static final String REGISTRATION_FAILURE = Local.getText(Local.QTJ_REGISTRATION_FAILURE);
    public static final String MSISDN_ALREADY_REGISTERED = Local.getText(Local.QTJ_MSISDN_ALREADY_REGISTERED);
    public static final String WIRELESS_INTERFACE_ERROR = Local.getText(Local.QTJ_WIRELESS_INTERFACE_ERROR);
    public static final String THERE_ARE_NO_NEW_SURVEYS = Local.getText(Local.QTJ_THERE_ARE_NO_NEW_SURVEYS);
    public static final String NOTPROPERINTEGER = Local.getText(Local.QTJ_NOTPROPERINTEGER);
    public static final String NOTPROPERDECIMAL = Local.getText(Local.QTJ_NOTPROPRDECIMAL);
    public static final String RESTORE_DEFAULT = Local.getText(Local.QTJ_RESTORE_DEFAULT);
    public static final String RELOAD = Local.getText(Local.QTJ_RELOAD);
    public static final String LOADING_STYLE = Local.getText(Local.QTJ_LOADING_STYLE);
    public static final String LOADING_STYLE_ERROR = Local.getText(Local.QTJ_LOADING_STYLE_ERROR);
    public static final String UI_CUSTOMIZE = Local.getText(Local.QTJ_UI_CUSTOMIZE);
    public static final String SELECTED = Local.getText(Local.QTJ_SELECTED);
    public static final String UNSELECTED = Local.getText(Local.QTJ_UNSELECTED);
    public static final String PREVIEW = Local.getText(Local.QTJ_PREVIEW);
    public static final String ELEMENT = Local.getText(Local.QTJ_ELEMENT);
    public static final String OBJECT = Local.getText(Local.QTJ_OBJECT);
    public static final String LIST = Local.getText(Local.QTJ_LIST);
    public static final String MENU = Local.getText(Local.QTJ_MENU);
    public static final String DIALOG_TITLE = Local.getText(Local.QTJ_DIALOG_TITLE);
    public static final String BG_SELECTED = Local.getText(Local.QTJ_BG_SELECTED);
    public static final String BG_UNSELECTED = Local.getText(Local.QTJ_BG_UNSELECTED);
    public static final String FONT_SELECTED = Local.getText(Local.QTJ_FONT_SELECTED);
    public static final String FONT_UNSELECTED = Local.getText(Local.QTJ_FONT_UNSELECTED);
    public static final String ACCESS_DENIED = Local.getText(Local.QTJ_ACCESS_DENIED);
    public static final String LOAD_FROM_FILE = Local.getText(Local.QTJ_LOAD_FROM_FILE);
    public static final String MEMORY_OUT = Local.getText(Local.QTJ_MEMORY_OUT);
    public static final String DEFAULT_PHOTO_DIR = Local.getText(Local.QTJ_DEFAULT_PHOTO_DIR);
    public static final String CAPTURE_PHOTO = Local.getText(Local.QTJ_CAPTURE_PHOTO);
    public static final String DELETE_PHOTO = Local.getText(Local.QTJ_DELETE_PHOTO);
    public static final String PHOTO_RESOLUTION = Local.getText(Local.QTJ_PHOTO_RESOLUTION);
    public static final String SHOW_PHOTO = Local.getText(Local.QTJ_SHOW_PHOTO);
    public static final String TAKE_PHOTO = Local.getText(Local.QTJ_TAKE_PHOTO);
    public static final String JUST_SAVE = Local.getText(Local.QTJ_JUST_SAVE);
    public static final String UI_PREFERENCES = Local.getText(Local.QTJ_UI_PREFERENCES);
    public static final String GEO_TAGGING_CONF = Local.getText(Local.QTJ_GEO_TAGGING_CONF);
    public static final String MAX_IMG_NO = Local.getText(Local.QTJ_MAX_IMG_NO);
    public static final String RESOLUTIONS = Local.getText(Local.QTJ_RESOLUTIONS);
    public static final String DEFAULT = Local.getText(Local.QTJ_DEFAULT);
    public static final String HIGH_CONTRAST = Local.getText(Local.QTJ_HIGH_CONTRAST);
    public static final String CUSTOM = Local.getText(Local.QTJ_CUSTOM);
    public static final String STYLES = Local.getText(Local.QTJ_STYLES);
    public static final String TIME_FORMAT_ERROR = Local.getText(Local.QTJ_TIME_FORMAT_ERROR);
    public static final String DATE_FORMAT_ERROR = Local.getText(Local.QTJ_DATE_FORMAT_ERROR);
    public static final String DISCARD_CHANGES = Local.getText(Local.QTJ_DISCARD_CHANGES);
    public static final String ENCRYPTION = Local.getText(Local.QTJ_ENCRYPTION);
    public static final String ENCRYPTION_ENABLE = Local.getText(Local.QTJ_ENCRYPTION_ENABLE);
    public static final String ENCRYPTION_WITH_PASSWORD = Local.getText(Local.QTJ_ENCRYPTION_WITH_PASSWORD);
    public static final String ENCRYPTION_PASSWORD = Local.getText(Local.QTJ_ENCRYPTION_PASSWORD);
    public static final String DECRYPTION_FAILED = Local.getText(Local.QTJ_DECRYPTION_FAILED);
    public static final String EMPTY_KEY = Local.getText(Local.QTJ_EMPTY_KEY);
    public static final String WRONG_KEY = Local.getText(Local.QTJ_WRONG_KEY);

    public static final int NOENTRY = -99999;
    /** General */
    //
    //deploy wtk
    public static String ROOT_DIR_PHONE;
    public static String ROOT_DIR_CARD;
    public static String ROOT_DIR;
    //public static final String URL_SERVLET_RESULTS = "http://200.141.73.235:8180/mobisus/PostResults";
    //public static final String URL_SERVLET_RESULTS = "http://localhost:8080/mobisus/PostResults";
    //public static final String ENCODE_TYPE = "UTF-8";
    public static final String SETTINGS_FILE = "settings.xml";
    public static final String STYLE_FILE = "style.xml";
    public static final String SURVEY_NAME = "survey.xml";
    public static final String NEW_SURVEYS_LIST = "new_surveys_list.xml";
    public static final String TMP_DOWNLOAD_SURVEY = "tmp_download_survey.xml";
    public static final String XML_TAG_END_SURVEY = "</survey>";
    public static final String XFORMS_TAG_END_SURVEY = "</xforms>";
    public static final String SURVEY = "survey";
    public static final String NDG_SURVEY_DIR_PREFIX = "survey";
    public static final String XFORMS_SURVEY_DIR_PREFIX = "xforms";
    public static final String NDG_PROPERTIES_FILE = "ndg.properties";
    public static final String XFORM = "xform";
    public static String NDG_STANDARD_NAME = "NDG Protocol";
    public static String OPENROSA_STANDARD_NAME = "OpenRosa Protocol";
    public static final String DDMMYYYY = "DD/MM/YYYY";
    public static final String MMDDYYYY = "MM/DD/YYYY";
    /** Messages */
    public static final String MSG_SERVER_CANT_WRITE_RESULTS = Local.getText(Local.QTJ_MSG_SERVER_CANT_WRITE_RESULTS);
    //public static final String CONT_WITHOUT_SAVE = Local.getText(Local.CONT_WITHOUT_SAVE);
    /*Error Messages*/
    public static final String ELOAD_SURVEYS = Local.getText(Local.QTJ_ELOAD_SURVEYS);
    public static final String ELOAD_RESULTS = Local.getText(Local.QTJ_ELOAD_RESULTS);
    public static final String EDELETE_RESULT = Local.getText(Local.QTJ_EDELETE_RESULT);
    public static final String ELEAVE_MIDLET = Local.getText(Local.QTJ_ELEAVE_MIDLET);
    public static final String ELOAD_IMAGES = Local.getText(Local.QTJ_ELOAD_IMAGES);
    public static final String EPARSE_SAX = Local.getText(Local.QTJ_EPARSE_SAX);
    public static final String EPARSE_SURVEY = Local.getText(Local.QTJ_EPARSE_SURVEY);
    public static final String EPARSE_RESULT = Local.getText(Local.QTJ_EPARSE_RESULT);
    public static final String EPARSE_GENERAL = Local.getText(Local.QTJ_EPARSE_GENERAL);
    public static final String EWRITE_RESULT = Local.getText(Local.QTJ_EWRITE_RESULT);
    public static final String ECREATE_RESULT = Local.getText(Local.QTJ_ECREATE_RESULT);
    public static final String ERENAME = Local.getText(Local.QTJ_ERENAME);
    public static final String EWEBSERVER_ERROR = Local.getText(Local.QTJ_EWEBSERVER_ERROR);
    public static final String EDOWNLOAD_FAILED_ERROR_CODE = Local.getText(Local.QTJ_EDOWNLOAD_FAILED_ERROR_CODE);
    public static final String EDOWNLOAD_FAILED_INVALID_MIME_TYPE = Local.getText(Local.QTJ_EDOWNLOAD_FAILED_INVALID_MIME_TYPE);
    public static final String EDOWNLOAD_FAILED_INVALID_DATA = Local.getText(Local.QTJ_EDOWNLOAD_FAILED_INVALID_DATA);
    public static final String EDOWNLOAD_INCOMPLETED = Local.getText(Local.QTJ_EDOWNLOAD_INCOMPLETED);
    public static final String EDOWNLOAD_ACK_ERROR = Local.getText(Local.QTJ_EDOWNLOAD_ACK_ERROR);
    public static final String EINVALID_SURVEYS = Local.getText(Local.QTJ_EINVALID_SURVEYS);
    public static final String EINVALID_XML_FILE = Local.getText(Local.QTJ_EINVALID_XML_FILE);
    public static final String EFAILED_LOAD_IMAGE_LIMITED_DEVICE_RESOURCES = Local.getText(Local.QTJ_EFAILED_LOAD_IMAGE_LIMITED_DEVICE_RESOURCES);
    public static final String SHOW_CHOICES = Local.getText(Local.QTJ_SHOW_CHOICES);
    public static final String NATIVE_RESOLUTION = Local.getText(Local.QTJ_NATIVE_RESOLUTION);
    public static final String CMD_UI_COLORS =  Local.getText(Local.QTJ_CMD_COLORS);
    public static final String CMD_FONT_SIZES = Local.getText(Local.QTJ_CMD_SIZES);
    public static final String CMD_CLEAR = Local.getText(Local.QTJ_CMD_CLEAR);

    private boolean error = false;
    public static Image check;
    public static Image question;
    public static Image logo;

    public Resources() {
        try {
            question = Image.createImage("/resources/images/redquestion.png");
            check = Image.createImage("/resources/images/greencheck.png");
            logo = Image.createImage("/resources/images/logo02_48x48.png");
        } catch (IOException ex) {
            error = true;
            GeneralAlert.getInstance().addCommand(ExitCommand.getInstance());
            GeneralAlert.getInstance().show(Resources.ERROR_TITLE, Resources.ELOAD_IMAGES, GeneralAlert.ERROR);
        }
    }

    public boolean getError() {
        return error;
    }
}
