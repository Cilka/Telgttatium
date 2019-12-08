package com.cilka.telgt.utils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
public class TabHandler extends DefaultHandler {

    private boolean isName = false;
    private String name;
    protected XMLReader reader;

    public TabHandler(XMLReader reader)
    {
        this.reader =  reader;
    }
    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("name")){
            isName = true;
        }
        else if(qName.equalsIgnoreCase("section")){
              reader.setContentHandler(new SectionHandler(reader));

        }
    }
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException
    {
        System.out.println(name + " tab complete");

    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(isName)
        {
            name = new String(ch, start, length);
            isName =false;
        }
    }
    public String getName(){
        return name;
    }
    public DefaultHandler self()
    {
        return this;
    }
    }
