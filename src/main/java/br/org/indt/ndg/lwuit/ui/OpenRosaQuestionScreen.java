package br.org.indt.ndg.lwuit.ui;

import br.org.indt.ndg.lwuit.control.BackToCategoryCommand;
import br.org.indt.ndg.lwuit.control.OpenFileBrowserCommand;
import br.org.indt.ndg.lwuit.control.RemovePhotoCommand;
import br.org.indt.ndg.lwuit.control.SaveGroupCommand;
import br.org.indt.ndg.lwuit.control.ShowPhotoCommand;
import br.org.indt.ndg.lwuit.control.SurveysControl;
import br.org.indt.ndg.lwuit.control.TakePhotoCommand;
import br.org.indt.ndg.lwuit.extended.CheckBox;
import br.org.indt.ndg.lwuit.extended.DateField;
import br.org.indt.ndg.lwuit.extended.DescriptiveField;
import br.org.indt.ndg.lwuit.extended.NumericField;
import br.org.indt.ndg.lwuit.extended.RadioButton;
import br.org.indt.ndg.lwuit.model.ImageData;
import br.org.indt.ndg.lwuit.ui.camera.CameraManagerListener;
import br.org.indt.ndg.lwuit.ui.camera.OpenRosaCameraManager;
import br.org.indt.ndg.lwuit.ui.openrosa.OpenRosaConstraintHelper;
import br.org.indt.ndg.lwuit.ui.openrosa.OpenRosaUtils;
import br.org.indt.ndg.lwuit.ui.openrosa.model.OpenRosaGroup;
import br.org.indt.ndg.lwuit.ui.openrosa.model.OpenRosaQuestion;
import br.org.indt.ndg.lwuit.ui.openrosa.model.OpenRosaSurvey;
import br.org.indt.ndg.lwuit.ui.style.NDGStyleToolbox;
import br.org.indt.ndg.mobile.AppMIDlet;
import br.org.indt.ndg.mobile.Resources;
import br.org.indt.ndg.mobile.multimedia.Base64Coder;
import com.nokia.xfolite.xforms.dom.BoundElement;
import com.nokia.xfolite.xforms.dom.XFormsElement;
import com.nokia.xfolite.xforms.model.datatypes.DataTypeBase;
import com.nokia.xfolite.xml.dom.Node;
import com.nokia.xfolite.xml.xpath.NodeSet;
import com.sun.lwuit.Button;
import com.sun.lwuit.ButtonGroup;
import com.sun.lwuit.Component;
import com.sun.lwuit.Container;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.events.FocusListener;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.layouts.FlowLayout;
import com.sun.lwuit.plaf.Border;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author damian.janicki
 */
public class OpenRosaQuestionScreen extends Screen implements ActionListener{

    private String title1;
    private String title2;
    private OpenRosaGroup group = null;

    private Vector containers = null;

    protected void loadData() {
        group = AppMIDlet.getInstance().getFileStores().getSelectedGroup();

        title1 = SurveysControl.getInstance().getSurveyTitle();
        title2 = Resources.NEW_INTERVIEW;

        containers = new Vector();
    }

    protected void customize() {
        setTitle( title1, title2 );

        form.removeAllCommands();
        form.removeAll();

        form.setLayout( new BoxLayout( BoxLayout.Y_AXIS ) );
        form.getContentPane().getStyle().setBorder( Border.createEmpty(), false );
        form.setScrollAnimationSpeed( 500 );
        form.setFocusScrolling( true );

        form.addCommand( BackToCategoryCommand.getInstance().getCommand() );
        form.addCommand( SaveGroupCommand.getInstance().getCommand() );

        try {
        form.removeCommandListener( this );
        } catch (NullPointerException npe) {
        }
        form.addCommandListener( this );

        appendQuestions();
    }

    private void appendQuestions(){
        Vector questions = group.getQuestions();

        for ( int idx = 0; idx <  questions.size(); idx++ ){
            OpenRosaQuestion que = (OpenRosaQuestion)questions.elementAt( idx );
            ContainerUI comp = null;
            switch ( que.getType() ){
                case OpenRosaQuestion.TYPE_INPUT:
                    comp = createInput( que.getBoundElement() ) ;
                    break;
                case OpenRosaQuestion.TYPE_SELECT:
                    comp = new XfoilMultipleChoiceFieldUI( que.getBoundElement() );
                    break;
                case OpenRosaQuestion.TYPE_SELECT1:
                    comp = new XfoilExclusiveChoiceFieldUI( que.getBoundElement() );
                    break;
                case OpenRosaQuestion.TYPE_UPLOAD_IMAGE:
                    comp = new XfoilPhotoFieldUi( que.getBoundElement() );
                    break;
                default:
            }
            if(comp != null){
                containers.addElement( comp );
                form.addComponent( comp );
            }
        }
    }

    private ContainerUI createInput(BoundElement bindElem) {
        DataTypeBase a = bindElem.getDataType();
        ContainerUI question = null;

        if (a != null) {
            switch (a.getBaseTypeID()) {
                case DataTypeBase.XML_SCHEMAS_DATE:
                    question = new XfoilDateFieldUI(bindElem);
                    break;
                case DataTypeBase.XML_SCHEMAS_TIME:
                    break;
                case DataTypeBase.XML_SCHEMAS_STRING:
                    question = new XfoilDescriptiveFieldUI(bindElem);
                    break;
                case DataTypeBase.XML_SCHEMAS_DECIMAL:
                case DataTypeBase.XML_SCHEMAS_INTEGER:
                    question = new XfoilNumericFieldUI(bindElem);
                    break;
                default:
                case DataTypeBase.XML_SCHEMAS_UNKNOWN:
                    question = new XfoilMockComponent(bindElem);
            }
        }
       return question;
    }

    public boolean commitValues() {
        boolean result = true;
        for (int i = 0; i < containers.size(); i++) {
            if (!((ContainerUI) containers.elementAt(i)).validate()) {
                result = false;
                ((ContainerUI) containers.elementAt(i)).showBadInputError();
                break;
            }
        }
        if(result == true) {
            for (int i = 0; i < containers.size(); i++) {
                ((ContainerUI) containers.elementAt(i)).commitValue();
            }
        }
        return result;
    }

    public boolean isFormChanged(){
        for (int i = 0; i < containers.size(); i++) {
            if (((ContainerUI) containers.elementAt(i)).isChanged()){
                return true;
            }
        }
        return false;
    }


    public void actionPerformed( ActionEvent ae ) {
        Object cmd = ae.getSource();
        if ( cmd == BackToCategoryCommand.getInstance().getCommand() ) {
            GeneralAlert.getInstance().addCommand(GeneralAlert.DIALOG_YES_NO, true);
            if( isFormChanged() &&  GeneralAlert.RESULT_YES ==  GeneralAlert.getInstance().show( Resources.CMD_SAVE,
                                             Resources.SAVE_SURVEY_QUESTION,
                                             GeneralAlert.CONFIRMATION)){
                saveCategory();
            }else{
                BackToCategoryCommand.getInstance().execute( null );
            }

        } else if( cmd == SaveGroupCommand.getInstance().getCommand() ) {
            saveCategory();
        }
    }

    private void saveCategory(){
        if( commitValues() ){
            group.setChanged( true );
            BackToCategoryCommand.getInstance().execute( null );
        }
    }
}

abstract class ContainerUI extends Container implements FocusListener {

    protected TextArea qname;
    protected BoundElement element;

    protected void commitValue(String input) {
        element.setStringValue(input);
    }

    public abstract boolean isChanged();

    public abstract void commitValue();

    public abstract void setEnabled(boolean enabled);

    public void handleMoreDetails(Object cmd) {
    }

    public ContainerUI(BoundElement element) {
        getStyle().setBorder(Border.createBevelLowered(NDGStyleToolbox.getInstance().focusLostColor,
                NDGStyleToolbox.getInstance().focusLostColor,
                NDGStyleToolbox.getInstance().focusLostColor,
                NDGStyleToolbox.getInstance().focusLostColor));
        this.element = element;
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        addFocusListener(this);
    }

    protected void addQuestionName() {

        addComponent( new Label("") );
        TextArea questionName = UIUtils.createQuestionName( OpenRosaSurvey.getResourceManager().tryGetLabelForElement( element ) );

        this.addComponent( questionName );
    }

    protected abstract boolean validate();

    public BoundElement getElement() {
        return element;
    }

    public void showBadInputError() {
        String constraint = element.getConstraintString();
        GeneralAlert.getInstance().addCommand(GeneralAlert.DIALOG_OK, true);
        if (constraint != null) {

            String lowConstraint = "";
            String highConstraint = "";
            if(element.getDataType().getBaseTypeID() == DataTypeBase.XML_SCHEMAS_DATE){
                lowConstraint = OpenRosaConstraintHelper.getInstance().getDateLowConstraint(constraint);
                highConstraint = OpenRosaConstraintHelper.getInstance().getDateHighConstraint(constraint);
            }else{
                lowConstraint = OpenRosaConstraintHelper.getInstance().getLowConstraint(constraint);
                highConstraint = OpenRosaConstraintHelper.getInstance().getHighConstraint(constraint);
            }

            GeneralAlert.getInstance().show(
                                        Resources.CMD_SAVE,
                                        Resources.OR_VALID_INPUT_FROM + " " + lowConstraint
                                        + " " + Resources.TO + " " + highConstraint,
                                        GeneralAlert.WARNING);

        } else {
            GeneralAlert.getInstance().show(
                    Resources.CMD_SAVE,
                    Resources.OR_INVALID_INPUT,
                    GeneralAlert.WARNING);
        }
    }

    public void focusGained(Component cmpnt) {
        getStyle().setBorder(Border.createBevelLowered(NDGStyleToolbox.getInstance().focusGainColor,
                NDGStyleToolbox.getInstance().focusGainColor,
                NDGStyleToolbox.getInstance().focusGainColor,
                NDGStyleToolbox.getInstance().focusGainColor), false);
        refreshTheme();
    }

    public void focusLost(Component cmpnt) {
        if(!cmpnt.getComponentForm().isVisible()){
            return;
        }

        if (!validate()) {
            showBadInputError();
            cmpnt.requestFocus();

            return;
        }
        getStyle().setBorder(Border.createBevelLowered(NDGStyleToolbox.getInstance().focusLostColor,
                NDGStyleToolbox.getInstance().focusLostColor,
                NDGStyleToolbox.getInstance().focusLostColor,
                NDGStyleToolbox.getInstance().focusLostColor), false);
        refreshTheme();
    }

    protected String getValue(XFormsElement el) {
        XFormsElement valueEl = (XFormsElement) el.getUserData(XFormsElement.VALUE_KEY);
        if (valueEl != null) {
            return valueEl.getText();
        } else {
            return "";
        }
    }
}

class XfoilPhotoFieldUi extends ContainerUI implements  ActionListener, CameraManagerListener {

    private Container mImageContainer;
    private Button imageButton;
    private boolean isChanged = false;

    public XfoilPhotoFieldUi(BoundElement element){
        super(element);
        OpenRosaCameraManager.getInstance().reset();
        AppMIDlet.getInstance().setCurrentCameraManager(OpenRosaCameraManager.getInstance());

        addQuestionName();
        addPhotoContainer();
    }

    public void focusGained(Component cmpnt) {
        rebuildOptionMenu();
    }

    public void focusLost(Component cmpnt) {
        removePhotoCommands();
        super.focusLost(cmpnt);
    }

    private void rebuildOptionMenu(){
        removePhotoCommands();
        addPhotoCommands();
    }

    private void addPhotoCommands(){
        if ( OpenRosaCameraManager.getInstance().getImageArray() != null ) {
            getComponentForm().addCommand(RemovePhotoCommand.getInstance().getCommand());
            getComponentForm().addCommand(ShowPhotoCommand.getInstance().getCommand());
        }
        getComponentForm().addCommand(OpenFileBrowserCommand.getInstance().getCommand());
        getComponentForm().addCommand(TakePhotoCommand.getInstance().getCommand());
    }

    private void removePhotoCommands(){
        getComponentForm().removeCommand(OpenFileBrowserCommand.getInstance().getCommand());
        getComponentForm().removeCommand(TakePhotoCommand.getInstance().getCommand());
        getComponentForm().removeCommand(ShowPhotoCommand.getInstance().getCommand());
        getComponentForm().removeCommand(RemovePhotoCommand.getInstance().getCommand());
    }

    public boolean isChanged(){
        return isChanged;
    }

    public void commitValue() {
//        element.setStringValue(OpenRosaCameraManager.getInstance().getImageStringValue());
        commitValue(OpenRosaCameraManager.getInstance().getImageStringValue());
    }

    public void setEnabled(boolean enabled) {
    }

    protected boolean validate() {
        return true;
    }

    private void addPhotoContainer(){
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        mImageContainer = new Container (new FlowLayout());

        Image thumbnail = null;
        if(element.getStringValue() != null && !element.getStringValue().equals("")){
            byte[] byteArray = Base64Coder.decode(element.getStringValue());
            OpenRosaCameraManager.getInstance().setImageArray(byteArray);
        }

        imageButton = new Button();
        imageButton.setIcon(thumbnail);
        imageButton.addActionListener(this);
        imageButton.setAlignment(Component.LEFT);
        imageButton.setFocusable(true);
        imageButton.addFocusListener(this);
        mImageContainer.addComponent(imageButton);

        updateImageButton();

        addComponent(mImageContainer);
    }

    private void updateImageButton(){
        Image thumbnail = null;
        byte[] image = OpenRosaCameraManager.getInstance().getImageArray();
        if(image != null){
            Image img = Image.createImage(image, 0, image.length);
            thumbnail = img.scaled(ImageData.THUMBNAIL_SIZE, ImageData.THUMBNAIL_SIZE);
//            thumbnail = Camera.createThumbnail(img);
        }else{
            thumbnail = Screen.getRes().getImage("camera-icon");
        }

        imageButton.setIcon(thumbnail);
    }

    public void actionPerformed(ActionEvent cmd) {
        if ( cmd.getSource() instanceof Button ) {
            OpenRosaCameraManager.getInstance().sendPostProcessData(this);
            if(OpenRosaCameraManager.getInstance().getImageArray() == null){
                new ImageQuestionContextMenu(0, ImageQuestionContextMenu.TWO_ACTIONS_CONTEXT_MENU).show();
            }else{
                new ImageQuestionContextMenu(0, ImageQuestionContextMenu.FOUR_ACTIONS_CONTEXT_MENU).show();
            }
        }
    }

    public void update() {
        isChanged = true;
        updateImageButton();
        rebuildOptionMenu();
        getComponentForm().showBack();
    }
}

class XfoilDescriptiveFieldUI extends ContainerUI {

    DescriptiveField tfDesc = null;

    public XfoilDescriptiveFieldUI(BoundElement element) {
        super(element);
        addQuestionName();
        addDescriptionQuestion(element);
    }

    public void commitValue() {
        commitValue(tfDesc.getText());
    }

    protected boolean validate() {
        return OpenRosaConstraintHelper.getInstance().
                validateConstraint(tfDesc.getText(), element);
    }

    public void setEnabled(boolean enabled) {
        //     throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isChanged(){
        if(tfDesc.getText().equals(element.getStringValue())){
            return false;
        }else{
            return true;
        }
    }

    private void addDescriptionQuestion(BoundElement bindElem) {
        String strValue = bindElem.getStringValue().trim();

        tfDesc = new DescriptiveField(OpenRosaConstraintHelper.getInstance().
                getMaxStringLength(element));
        tfDesc.setInputMode("Abc");
        tfDesc.setEditable(true);
        tfDesc.setFocusable(true);
        if (strValue != null) {
            tfDesc.setText(strValue);
        }
        this.addComponent(tfDesc);
    }
}

class XfoilNumericFieldUI extends ContainerUI {

    NumericField nfNumber = null;

    public XfoilNumericFieldUI(BoundElement element) {
        super(element);
        addQuestionName();
        addNumericQuestion(element);
    }

    public void commitValue() {
        commitValue(nfNumber.getText());
    }

    protected boolean validate() {
        return OpenRosaConstraintHelper.getInstance().
                validateConstraint(nfNumber.getText(), element);
    }

    public void setEnabled(boolean enabled) {
     //   throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean isChanged(){
        if(nfNumber.getText().equals(element.getStringValue())){
            return false;
        }else{
            return true;
        }
    }

    private void addNumericQuestion(BoundElement bindElem) {
        String value = bindElem.getStringValue().trim();
        nfNumber = new NumericField(50, true);  // decimals allowed?
        nfNumber.setFocusable(true);
        if (value != null) {
            nfNumber.setText(value);
        }
        nfNumber.addFocusListener(this);
        this.addComponent(nfNumber);
    }
}

class XfoilDateFieldUI extends ContainerUI {
    DateField dfDate;

    public XfoilDateFieldUI(BoundElement element) {
        super(element);
        addQuestionName();
        addDateQuestion(element);
    }

    public void commitValue() {
        commitValue(OpenRosaUtils.getStringFromDate(dfDate.getDate()));
    }

    protected boolean validate() {
        boolean retVal = OpenRosaConstraintHelper.getInstance().
                validateDate(element.getConstraintString(), dfDate.getDate());

        if(!retVal){
            long date = Calendar.getInstance().getTime().getTime();
            dfDate.setDate(new Date(date));
            this.repaint();
        }
        return retVal;
    }

    public void setEnabled(boolean enabled) {
    }

    public boolean isChanged(){

        String dateStr = OpenRosaUtils.getStringFromDate(dfDate.getDate());
        if(dateStr.equals(element.getStringValue())){
            return false;
        }else{
            return true;
        }
    }

    private void addDateQuestion(BoundElement bindElem) {
        Date date = null;
        String value = bindElem.getStringValue().trim();

        if (value != null || value != "") {
            date = OpenRosaUtils.getDateFromString(value);
       }

        if(date == null){
            date = Calendar.getInstance().getTime();
        }

        dfDate = new DateField(AppMIDlet.getInstance().getSettings().getStructure().getDateFormatId(), '/');
        dfDate.setDate(date);
        dfDate.setEditable(true);
        dfDate.addFocusListener(this);

        addComponent(dfDate);
    }

}

//class XfoilTimeFieldUI extends ContainerUI {
//    TimeField dfTime;
//
//    public XfoilTimeFieldUI(BoundElement element) {
//        super(element);
//        addQuestionName();
//        addTimeQuestion(element);
//    }
//
//    public void commitValue() {
//         element.setStringValue(dfTime.getText());
//    }
//
//    protected boolean validate() {
//        return true;
//    }
//
//    public void setEnabled(boolean enabled) {
//     //   throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    private void addTimeQuestion(BoundElement bindElem) {
//        String value = bindElem.getStringValue().trim();
//        if (value != null && (value == null ? "" != null : !value.equals(""))) {
//            //dfTime = new TimeField(value, TimeField.HHMM, ':');
//
//        } else {
//            dfTime = new TimeField(TimeField.HHMM);
//        }
//        dfTime.setEditable(true);
//        addComponent(dfTime);
//    }
//}

class XfoilMultipleChoiceFieldUI extends ContainerUI {

    private Vector cbs = new Vector();

    public XfoilMultipleChoiceFieldUI(BoundElement element) {
        super(element);
        addQuestionName();
        addSelectQuestion(element);
    }

    public void commitValue() {
        commitValue(getSelectedString());
    }

    private String getSelectedString(){
        String values = "";
        for (int i = 0; i < cbs.size(); i++) {
            CheckBox cb = (CheckBox)cbs.elementAt(i);
            if( cb.isSelected() ) {
                values = values.concat(cb.getText() + " ");
            }
        }
        return values;
    }

    protected boolean validate() {
        // maybe required atttr
        return true;
    }

    public void setEnabled(boolean enabled) {
        //   throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isChanged(){
        if(getSelectedString().equals(element.getStringValue())){
            return false;
        }else{
            return true;
        }
    }

    private void addSelectQuestion(BoundElement bindElem) {
        NodeSet choices = new NodeSet();

        int count = bindElem.getChildCount();
        for (int idx = 0; idx < count; idx++) {
            Node nodeItem = bindElem.getChild(idx);
            if (nodeItem.getLocalName() != null
                    && nodeItem.getLocalName().compareTo("item") == 0) {
                choices.AddNode(nodeItem);
            }
        }

        int length = choices.getLength();
        String[] names = new String[length];
        String[] values = new String[length];
        boolean[] selected = new boolean[length];


        String chosenVal = " " + bindElem.getStringValue() + " ";
        for (int i = 0; i < length; i++) {
            XFormsElement n = (XFormsElement) choices.item(i);
            String label = OpenRosaSurvey.getResourceManager().tryGetLabelForElement(n);
            String value = OpenRosaSurvey.getResourceManager().tryGetLabelForElement(n);

            if (!value.equals("") && chosenVal.indexOf(" " + value + " ") >= 0) {
                selected[i] = true;
            } else {
                selected[i] = false;
            }
            names[i] = label;
            values[i] = value;
        }

        for (int i = 0; i < length; i++) {
            CheckBox cb = new CheckBox(names[i]);
            cb.setSelected(selected[i]);
            cbs.addElement(cb);
            addComponent(cb);
        }
    }
}

class XfoilExclusiveChoiceFieldUI extends ContainerUI {

    private ButtonGroup groupButton;
    private String[] values;

    public XfoilExclusiveChoiceFieldUI(BoundElement element) {
        super(element);
        addQuestionName();
        addSelect1Question(element);
    }

    public void commitValue() {
        commitValue(getSelectedString());
    }

    private String getSelectedString(){
        int index = groupButton.getSelectedIndex();
        if( index >= 0 && index < values.length ){
            return values[index];
        }
        return "";
    }

    public boolean isChanged(){
        if(getSelectedString().equals(element.getStringValue())){
            return false;
        }else{
            return true;
        }
    }

    protected boolean validate() {
        // maybe required atttr
        return true;
    }

    public void setEnabled(boolean enabled) {
      //  throw new UnsupportedOperationException("Not supported yet.");
    }

    private void addSelect1Question(BoundElement bindElem) {
        NodeSet choices = new NodeSet();

        int count = bindElem.getChildCount();
        for (int idx = 0; idx < count; idx++) {
            Node nodeItem = bindElem.getChild(idx);
            if (nodeItem.getLocalName() != null
                    && nodeItem.getLocalName().compareTo("item") == 0) {
                choices.AddNode(nodeItem);
            }
        }

        int length = choices.getLength();
        String[] names = new String[length];
        values = new String[length];
        boolean[] selected = new boolean[length];

        String chosenVal = " " + bindElem.getStringValue() + " ";
        for (int i = 0; i < length; i++) {
            XFormsElement n = (XFormsElement) choices.item(i);
            String label = OpenRosaSurvey.getResourceManager().tryGetLabelForElement(n);
            String value = getValue(n);

            if (!value.equals("") && chosenVal.indexOf(" " + value + " ") >= 0) {
                selected[i] = true;
            } else {
                selected[i] = false;
            }
            names[i] = label;
            values[i] = value;
        }
        groupButton = new ButtonGroup();

        int totalChoices = names.length;
        String[] choicesStrings = new String[totalChoices];
        for (int i = 0; i < totalChoices; i++) {
            choicesStrings[i] = (String) names[i];
            RadioButton rb = new RadioButton(choicesStrings[i]);
            rb.useMoreDetails(values[i].equals("1"));
//            rb.setOtherText(""); // TODO this probably should not be commented! for test only! //Initializes with empty string
            rb.setSelected(selected[i]);
            //rb.addActionListener(new HandleMoreDetails()); // More Details
            //rb.addFocusListener(this); // Controls when changing to a new question
            groupButton.add(rb);
            addComponent(rb);
        }
    }
}

class XfoilMockComponent extends ContainerUI {

    public XfoilMockComponent(BoundElement element) {
        super(element);
        addQuestionName();
        addMockLabel();
    }

    public void commitValue() {
        // mock
    }

    protected boolean validate() {
        return true;
    }

    public boolean isChanged(){
        return false;
    }

    public void setEnabled(boolean enabled) {
     //   throw new UnsupportedOperationException("Not supported yet.");
    }

    private void addMockLabel() {
        addComponent(UIUtils.createQuestionName(Resources.UNSUPPORTED_TYPE));
    }
}
