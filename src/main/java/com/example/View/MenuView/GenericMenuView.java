package com.example.View.MenuView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.Model.MenuItemModel;
import com.example.Model.MenuModels.GenericMenuModel;

public class GenericMenuView extends GenericMenuModel{
    private String menuName;
    public GenericMenuView(){
        menuName = "";
    }
    public GenericMenuView(String nameString){
        menuName = nameString;
    }
    public void printDetails(GenericMenuModel genericMenuModel)
    {
        System.out.println("\n------ " + menuName + " ------");
        System.out.println("---------------------------");
        ArrayList< MenuItemModel> itemModels = genericMenuModel.getMenuItemList();
        for (MenuItemModel menuItemModel : itemModels) {
            System.out.println("Id: " + menuItemModel.getId());
            System.out.println("Name: " + menuItemModel.getName());
            System.out.println("Description: " + menuItemModel.getDescription());
            System.out.println("Price: " + menuItemModel.getPrice());
            System.out.println("Image: " + menuItemModel.getImage());
            System.out.println("---------------------------");
        }
    }
}
