package mod.telgttatium.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class ItemHandler extends DefaultHandler {
    private String name;
    private String type;
    private int id;
    private int maxUses;
    private float efficiency;
    private float attackDamage;
    private float attackSpeed;
    private boolean isName;
    private boolean isType;
    private boolean isId;
    private boolean isMaxUses;
    private boolean isEfficiency;
    private boolean isAttackDamage;
    private boolean isAttackSpeed;
    private DefaultHandler parent;
    private XMLReader reader;
    private Map<String, Map<String,Object>> items;
    public ItemHandler(XMLReader reader, DefaultHandler parent) {
        items =  new HashMap<>();
        this.parent = parent;
        this.reader =  reader;
    }
    public void clear()
    {
        items = new HashMap<>();
    }
    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {

        if(qName.equalsIgnoreCase("name")){
            isName = true;
        }

        else if(qName.equalsIgnoreCase("type")) {
            isType = true;
        }
        else if(qName.equalsIgnoreCase("id")){
            isId =  true;
        }
        else if(qName.equalsIgnoreCase("maxUses")){
            isMaxUses = true;
        }
        else if(qName.equalsIgnoreCase("efficiency")){
            isEfficiency = true;
        }
        else if(qName.equalsIgnoreCase("attackDamage")){
            isAttackDamage =true;
        }
        else if(qName.equalsIgnoreCase("attackSpeed")){
            isAttackSpeed =  true;
        }
    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(isName)
        {
            name = new String(ch, start, length);
            isName =false;
        }
        if(isType)
        {
            type = new String(ch, start, length);
            isType =false;
        }
        if(isId){
            id = Integer.parseInt(new String(ch, start, length));
            isId = false;
        }
        if(isMaxUses)
        {
            maxUses =  Integer.parseInt(new String(ch, start, length));
            isMaxUses=false;
        }
        if(isAttackSpeed)
        {
            attackSpeed = Float.parseFloat(new String(ch, start, length));
            isAttackSpeed = false;
        }
        if(isAttackDamage)
        {
            attackDamage = Float.parseFloat(new String(ch, start, length));
            isAttackDamage = false;
        }
        if(isEfficiency)
        {
            efficiency = Float.parseFloat(new String(ch, start, length));
            isEfficiency = false;
        }


    }
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException
    {

        if(qName.equalsIgnoreCase("item"))
        {
            Map<String, Object> fields = new HashMap<String,Object>();
            fields.put("id", id);
            fields.put("name", name);
            fields.put("type", type);
            items.put(name, fields);
        }
        if(qName.equalsIgnoreCase("items")) {
              reader.setContentHandler(parent);
        }

    }
    public Map<String, Map<String,Object>> getItems()
    {
        return items;
    }

}
