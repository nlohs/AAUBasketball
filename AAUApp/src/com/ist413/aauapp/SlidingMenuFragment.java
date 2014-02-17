package com.ist413.aauapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

public class SlidingMenuFragment extends Fragment implements ExpandableListView.OnChildClickListener {
    
    private ExpandableListView sectionListView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
        List<MenuSection> sectionList = createMenu();
                
        View view = inflater.inflate(R.layout.menu_fragment, container, false);
        this.sectionListView = (ExpandableListView) view.findViewById(R.id.slidingmenu_view);
        this.sectionListView.setGroupIndicator(null);
        
        SectionListAdapter sectionListAdapter = new SectionListAdapter(this.getActivity(), sectionList);
        this.sectionListView.setAdapter(sectionListAdapter); 
        
        this.sectionListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
              @Override
              public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
              }
            });
        
        this.sectionListView.setOnChildClickListener(this);
        
        int count = sectionListAdapter.getGroupCount();
        for (int position = 0; position < count; position++) {
            this.sectionListView.expandGroup(position);
        }
        
        return view;
    }

    private List<MenuSection> createMenu() {
        List<MenuSection> sectionList = new ArrayList<MenuSection>();

        MenuSection oInfoStatsSection = new MenuSection("Information & Stats");
        oInfoStatsSection.addSectionItem(101, "Players", "slidingmenu_airport");
        oInfoStatsSection.addSectionItem(102,"Twitter Stream", "slidingmenu_friends");
        
        MenuSection oGeneralSection = new MenuSection("Central PA AAU");
        oGeneralSection.addSectionItem(201, "About", "slidingmenu_settings");
        oGeneralSection.addSectionItem(202, "Membership", "slidingmenu_eula");
        oGeneralSection.addSectionItem(203, "Login", "slidingmenu_quit");
        oGeneralSection.addSectionItem(204, "Rate this app", "slidingmenu_rating");
        
        sectionList.add(oInfoStatsSection);
        sectionList.add(oGeneralSection);
        return sectionList;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
            int groupPosition, int childPosition, long id) {

        switch ((int)id) {
        case 101:
            //TODO
            break;
        case 102:
            //TODO
            break;
        case 201:
            //TODO
            break;
        case 202:
            //TODO
            break;
        case 203:
            //TODO
            break;
        case 204:
            //TODO
            break;
        }
        
        return false;
    }
}
