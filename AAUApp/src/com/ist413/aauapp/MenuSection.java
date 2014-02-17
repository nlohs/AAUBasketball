package com.ist413.aauapp;

import java.util.ArrayList;
import java.util.List;

public class MenuSection {

    private String title;
    private List<MenuListItem> sectionItems = new ArrayList<MenuListItem>();

    public MenuSection(String title) {
        this.title = title;
    }

    public void addSectionItem(long id, String title, String icon) {
        this.sectionItems.add( new MenuListItem(id, title, icon));
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public List<MenuListItem> getSectionItems() {
        return sectionItems;
    }
    
    public void setSectionItems(List<MenuListItem> sectionItems) {
        this.sectionItems = sectionItems;
    }
}
