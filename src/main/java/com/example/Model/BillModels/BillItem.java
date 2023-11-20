package com.example.Model.BillModels;

import com.example.Model.MenuItemModel;

public class BillItem {
    private MenuItemModel menuItemModel;
    private double totalPrice;
    private int quantities;

    public BillItem(){
        menuItemModel = new MenuItemModel();
    }
    public MenuItemModel getMenuItemModel() {
        return menuItemModel;
    }
    public void setMenuItemModel(MenuItemModel menuItemModel) {
        this.menuItemModel = menuItemModel;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }
    public int getQuantities() {
        return quantities;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
}
