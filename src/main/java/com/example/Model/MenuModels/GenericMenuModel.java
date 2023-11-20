package com.example.Model.MenuModels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.Model.MenuItemModel;

public class GenericMenuModel {
    private String csvDbPath;
    private ArrayList<MenuItemModel> menuItemList;
    
    public GenericMenuModel(ArrayList< MenuItemModel> menuItemList, String csvPath){
        this.menuItemList = menuItemList;
        csvDbPath = csvPath;
    }
    public GenericMenuModel(){
        menuItemList = new ArrayList<MenuItemModel>();
    }
    public GenericMenuModel(String csv){
        menuItemList = new ArrayList< MenuItemModel>();
        csvDbPath = csv;
    }

    public ArrayList< MenuItemModel> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(ArrayList<MenuItemModel> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public String getcsvDbPath() {
        return csvDbPath;
    }
    public void setcsvDbPath(String pathToCsvDb) {
        this.csvDbPath = pathToCsvDb;
    }
    public MenuItemModel gMenuItemModelById(int id) {
        MenuItemModel menuItemModel = null;
        for(MenuItemModel item : menuItemList) { 
            if(item.getId().equals(id)) { 
                menuItemModel = item;
            }
         }
        return menuItemModel;
    }
}
