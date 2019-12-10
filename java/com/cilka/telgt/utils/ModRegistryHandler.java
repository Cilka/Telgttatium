package com.cilka.telgt.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;


public class ModRegistryHandler extends DefaultHandler {
    private String modId;
    private XMLReader reader;
    private DefaultOptionsHandler defaultOptionsHandler;
    private TabHandler tabHandler;

    public ModRegistryHandler(String modId, XMLReader reader){
        this.modId = modId;
        this.reader = reader;
        defaultOptionsHandler =  new DefaultOptionsHandler(reader, this);
        tabHandler = new TabHandler(reader, this);
    }
    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("default"))
        {
            reader.setContentHandler(defaultOptionsHandler);
        }
        else if(qName.equalsIgnoreCase("tab"))
        {
            reader.setContentHandler(tabHandler);
        }
    }
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException
    {
        if(qName.equalsIgnoreCase(modId))
        {
           System.out.println("Finished");
        }
    }
    public Map<String,Tab> getTabs()
    {
        return tabHandler.getTabs();
    }
    public Map<String, Map<String, Object>> getDefaultOptions()
    {
        return defaultOptionsHandler.getDefaultModOptions();
    }
}
