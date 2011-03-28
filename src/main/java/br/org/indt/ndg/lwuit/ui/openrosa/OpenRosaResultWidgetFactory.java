package br.org.indt.ndg.lwuit.ui.openrosa;

import br.org.indt.ndg.lwuit.ui.style.NDGStyleToolbox;
import com.nokia.xfolite.xforms.dom.BoundElement;
import com.nokia.xfolite.xforms.model.datatypes.DataTypeBase;
import com.nokia.xfolite.xml.dom.Element;
import com.nokia.xfolite.xml.dom.WidgetFactory;
import com.nokia.xfolite.xml.xpath.XPathNSResolver;
import com.sun.lwuit.Component;
import com.sun.lwuit.Container;
import com.sun.lwuit.Display;
import com.sun.lwuit.Font;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.plaf.UIManager;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author damian.janicki
 */
public class OpenRosaResultWidgetFactory implements WidgetFactory, XPathNSResolver{

    private Container rootContainer = null;
    protected static Hashtable resources = new Hashtable();

    private static OpenRosaResourceManager resourceManager = new OpenRosaResourceManager();
    private Vector createdContainers = new Vector();

    private Font questionFont = NDGStyleToolbox.fontMediumItalic;
    private Font answerFont = NDGStyleToolbox.fontMedium;

    private static String UNSUPPORTED_STRING = "Unsuportted type"; //TODO add to resource

    int labelheight = 18;
    int labelheightspace = 8;

    public OpenRosaResultWidgetFactory(Container cont){
        rootContainer = cont;
        rootContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        resources.clear();
    }

    public void elementParsed(Element el) {
    }

    public void childrenParsed(Element el) {
        String tagName = el.getLocalName();
        BoundElement binding = null;
        if (el instanceof BoundElement) {
            binding = (BoundElement) el;
        }
        Component comp = null;

        if( tagName == "input"  || tagName == "secret"){
            addInputPreview(binding);
        } else if (tagName == "select" || tagName == "select1") {
            addSelectPreview(binding);
        } else if (tagName == "value") {
            addTextValue(el);
        }
    }

    public void addSelectPreview(BoundElement element){
        String questionLabel = resourceManager.tryGetLabelForElement(element);
        String questionValue = element.getStringValue();
        questionValue = questionValue.replace(' ', '\n');

        addQuestionComponent(questionLabel, questionValue);
    }

    public void addInputPreview(BoundElement element){

        String questionLabel = resourceManager.tryGetLabelForElement(element);
        String questionValue = "";

        DataTypeBase a = element.getDataType();
        if (a != null && a.getBaseTypeID() == DataTypeBase.XML_SCHEMAS_UNKNOWN) {
            questionValue = "Unsuportted type";
        } else{
            questionValue = element.getStringValue();
        }

        addQuestionComponent(questionLabel, questionValue);
    }

    private void addQuestionComponent(String label, String value){
        Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        container.addComponent(createWrappedTextArea(label + ":", questionFont));
        container.addComponent(createWrappedTextArea( value, answerFont));

        rootContainer.addComponent(container);
    }

    public void addTextValue(Element el){
        Element parent = (Element)el.getParentNode();
        if(parent.getNodeName() != "text"){
            return;
        }

        String id = parent.getAttribute("id");
        String value = el.getText();

        resourceManager.put(id, value);
    }


    public void removingElement(Element el) {
    }

    public void elementInitialized(Element el) {
    }

    public void childrenInitialized(Element el) {
    }

    public String lookupNamespaceURI(String prefix) {
                return "";
    }

    private TextArea createWrappedTextArea(String name, Font font) {
        TextArea item = new TextArea();
        item.setUnselectedStyle(UIManager.getInstance().getComponentStyle("Label"));
        item.setSelectedStyle( item.getUnselectedStyle() );
        item.getStyle().setFont(font);
        item.setEditable(false);
        item.setFocusable(false);
        item.setColumns(20);
        item.setGrowByContent(true);
        item.setText(name);

        // code below seems uncecessary
        int pw = Display.getInstance().getDisplayWidth();
        int w = item.getStyle().getFont().stringWidth(name);
        if (w > pw)
        {
            item.setRows(2);
        }
        else
        {
            item.setRows(1);
        }
        return item;
    }

}