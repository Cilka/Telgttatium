package mod.telgttatium.utils;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;

public class DefaultOptionsHandler extends DefaultHandler {

    private String name;
    private String material;
    private String sound;

    public String getMaterial() {
        return material;
    }

    public String getSound() {
        return sound;
    }

    public String getRenderLayer() {
        return renderLayer;
    }

    private String renderLayer;
    private boolean isName = false;
    private boolean isMaterial = false;
    private boolean isSound = false;
    private boolean isRenderLayer =false;
    private Map<String,Map<String, Object>> defaultModOptions = new HashMap<>();
    private XMLReader reader;
    private  DefaultHandler parent;
    public DefaultOptionsHandler(XMLReader reader, DefaultHandler parent)
    {
        this.reader = reader;
        this.parent = parent;
    }
    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("name"))
        {
            isName = true;
        }
        else if(qName.equalsIgnoreCase("material"))
        {
            isMaterial = true;
        }
        else if (qName.equalsIgnoreCase("soundType"))
        {
            isSound = true;
        }
        else if(qName.equalsIgnoreCase("blockRenderLayer"))
        {
            isRenderLayer = true;
        }
    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(isName)
        {
            name = new String(ch, start, length);
            isName =false;
        }    if(isMaterial)
        {
            material = new String(ch, start, length);
            isMaterial =false;
        }    if(isSound)
        {
            sound = new String(ch, start, length);
            isSound =false;
        }    if(isRenderLayer)
        {
            renderLayer = new String(ch, start, length);
            isRenderLayer =false;
        }

    }
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException
    {

        try{
            if(qName.equalsIgnoreCase("default")) {
                Map<String, Object> fields =  new HashMap<>();
                fields.put("name", name);
                fields.put("material", material);
                fields.put("sound", sound);
                fields.put("renderLayer", renderLayer);
                defaultModOptions.put(name, fields);
                System.out.println(name + " " + this.getClass().getSimpleName() + " complete");
            reader.setContentHandler(parent);
            }
            }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public Map<String,Map<String,Object>> getDefaultModOptions(){
        return defaultModOptions;
    }


    }
