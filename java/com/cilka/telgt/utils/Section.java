package com.cilka.telgt.utils;

import java.util.Map;

public class Section {
    private Map<String, Map<String, Object>> blocks;
    private Map<String, Map<String, Object>> items;
    private String defaultOption;

    public Map<String, Map<String, Object>> getBlocks() {
        return blocks;
    }

    public Map<String, Map<String, Object>> getItems() {
        return items;
    }

    public String getDefaultOption() {
        return defaultOption;
    }

    public Section(Map<String, Map<String, Object>> blocks, Map<String, Map<String, Object>> items, String defaultOption) {
        this.blocks = blocks;
        this.items = items;
        this.defaultOption = defaultOption;
    }
}
