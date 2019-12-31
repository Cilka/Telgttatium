package mod.telgttatium.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class SectionHandler extends DefaultHandler {
    private String name;
    private String defaultOption;
    private boolean isName;
    private boolean isDefaultOption;



    private BlockHandler blockHandler;
    private ItemHandler itemHandler;
    private Map<String,Section> sections;
    private XMLReader reader;
    private DefaultHandler parent;
    public SectionHandler(XMLReader reader, DefaultHandler parent) {
        this.reader = reader;
        this.parent = parent;
        blockHandler = new BlockHandler(reader, this);
        itemHandler = new ItemHandler(reader, this);
        sections  = new HashMap<>();
    }

    public Map<String, Section> getSections() {
        return sections;
    }
public void clear(){
        sections = new HashMap<>();

}
    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("name")){
            isName = true;
        }
        else if(qName.equalsIgnoreCase("defaultOption")){
            isDefaultOption =true;
        }
        else if(qName.equalsIgnoreCase("blocks")) {

            reader.setContentHandler(blockHandler);
        }

        else if(qName.equalsIgnoreCase("items")) {
            reader.setContentHandler(itemHandler);
        }
        }
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException
    {
        if(qName.equalsIgnoreCase("section")) {
            sections.put(name, new Section(blockHandler.getBlocks(), itemHandler.getItems(),defaultOption));
            blockHandler.clear();
            itemHandler.clear();
            reader.setContentHandler(parent);
            System.out.println(name + " " + this.getClass().getSimpleName() + " complete");

        }
    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(isName)
        {
            name = new String(ch, start, length);
            isName =false;
        }
        else if(isDefaultOption)
        {
            defaultOption = new String(ch, start, length);
            isDefaultOption = false;
        }
    }
}
