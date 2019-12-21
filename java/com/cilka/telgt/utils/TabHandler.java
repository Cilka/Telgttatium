package com.cilka.telgt.utils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class TabHandler extends DefaultHandler {

    private boolean isName = false;
    private String name;
    private XMLReader reader;
    private DefaultHandler parent;
    private SectionHandler sectionHandler;
    private Map<String,Tab> tabs;
    private String icon;
    private boolean isIcon;
    public TabHandler(XMLReader reader, DefaultHandler parent)
    {
        this.reader =  reader;
        this.parent = parent;
         sectionHandler = new SectionHandler(reader,this);
         tabs = new HashMap<>();
    }
    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("name")){
            isName = true;
        }if(qName.equalsIgnoreCase("icon")){
            isIcon = true;
        }
        else if(qName.equalsIgnoreCase("section")){
              reader.setContentHandler(sectionHandler);

        }
    }
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException
    {
        if(qName.equalsIgnoreCase("tab")){
            tabs.put(name,new Tab(name, icon, sectionHandler.getSections()));
            sectionHandler.clear();
            reader.setContentHandler(parent);
            System.out.println(name + " tab complete");
        }

    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(isName)
        {
            name = new String(ch, start, length);
            isName =false;
        }
        if(isIcon)
        {
            icon = new String(ch,start,length);
            isIcon = false;
        }
    }
    public Map<String, Tab> getTabs()
    {
        return tabs;
    }
    }
