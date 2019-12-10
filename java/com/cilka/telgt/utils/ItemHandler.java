package com.cilka.telgt.utils;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Map;

public class ItemHandler extends DefaultHandler {
    private Map<String, Map<String, Object>> items;

    public Map<String, Map<String, Object>> getItems() {
        return items;
    }

    public ItemHandler(XMLReader reader, DefaultHandler handler) {

    }


}
