package mod.telgttatium.utils;

import java.util.Map;

public class Tab {
    private String name;
    private String icon;
    private Map<String,Section> sections;

    public Tab(String name, String icon, Map<String, Section> sections) {
        this.name = name;
        this.icon = icon;
        this.sections = sections;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Map<String, Section> getSections() {
        return sections;
    }
}
