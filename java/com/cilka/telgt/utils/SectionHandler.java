package com.cilka.telgt.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SectionHandler extends TabHandler {
    private String name;
    private boolean isName;
    public SectionHandler(XMLReader reader) {
        super(reader);
    }
    @Override
    public String getName()
    {
        return name;
    }
    public DefaultHandler getParent()
    {
        return super.self();
    }
    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("name")){
            isName = true;
        }
        else if(qName.equalsIgnoreCase("defaulto")){
            reader.setContentHandler(new DefaultOptionsHandler(reader));

        }
        else if(qName.equalsIgnoreCase("blocks")) {
       //     reader.setContentHandler(new BlockHandler(reader));
        }

        else if(qName.equalsIgnoreCase("items")) {
       //     reader.setContentHandler(new ItemHandler(reader));
        }
        }
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException
    {
        System.out.println(name +" " + this.getClass().getSimpleName()+" complete");
        reader.setContentHandler(getParent());

    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(isName)
        {
            name = new String(ch, start, length);
            isName =false;
        }
    }
}
