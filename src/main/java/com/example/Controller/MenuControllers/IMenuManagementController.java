package com.example.Controller.MenuControllers;

import com.example.Model.MenuItemModel;
import com.example.Model.MenuModels.GenericMenuModel;
import com.example.Model.MenuModels.MenuManagementModel;

public interface IMenuManagementController {
    public void addMenuItemsToMenu(GenericMenuModel genericMenu, MenuItemModel menuItem);
    public void updateMenu(GenericMenuModel genericMenu, MenuItemModel updateMenuItem, String itemName);
    public void deleteMenu(GenericMenuModel genericMenu, String itemName);
    public void showMenu(MenuManagementModel menu);
    public boolean retrieveDataFromDb();
}
