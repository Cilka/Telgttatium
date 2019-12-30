package com.cilka.telgt.utils;

import akka.util.Helpers;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class BlockHandler extends DefaultHandler {
    private String name;
    private String type;
    private int id;
    private boolean isName;
    private boolean isType;
    private boolean isId;
    private DefaultHandler parent;
    private XMLReader reader;
    private Map<String, Map<String,Object>> blocks;
    public BlockHandler(XMLReader reader, DefaultHandler parent) {
        blocks = new HashMap<>();
        this.parent = parent;
        this.reader = reader;
    }
    public void clear()
    {
        blocks = new HashMap<>();
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
    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(isName)
        {
            name = new String(ch, start, length);
            isName =false;
        }    if(isType)
        {
            type = new String(ch, start, length);
            isType =false;
        }
        if(isId){
            id = Integer.parseInt(new String(ch, start, length));
            isId = false;
        }


    }
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException
    {

        if(qName.equalsIgnoreCase("block"))
        {
            Map<String, Object> fields = new HashMap<String,Object>();
            fields.put("id", id);
            fields.put("name", name);
            fields.put("type", type);
            blocks.put(name, fields);
        }
        if(qName.equalsIgnoreCase("blocks")) {
             reader.setContentHandler(parent);
        }

    }
    public Map<String, Map<String,Object>> getBlocks()
    {
        return blocks;
    }

}
