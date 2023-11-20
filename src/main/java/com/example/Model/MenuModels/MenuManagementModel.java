package com.example.Model.MenuModels;

import com.example.Model.MenuModels.Drink.DrinkMenuModel;
import com.example.Model.MenuModels.Food.FoodMenuModel;

public class MenuManagementModel {
    private static MenuManagementModel menuManagementModel;
    private FoodMenuModel foodMenu;
    private DrinkMenuModel drinkMenu;

    private MenuManagementModel() {
        foodMenu = new FoodMenuModel();
        drinkMenu = new DrinkMenuModel();
    }
    public static MenuManagementModel getInstance(){
        if (menuManagementModel == null) {
            menuManagementModel = new MenuManagementModel();
        }
        return menuManagementModel;
    }

    public DrinkMenuModel getDrinkMenu() {
        return drinkMenu;
    }
    public void setDrinkMenu(DrinkMenuModel drinkMenu) {
        this.drinkMenu = drinkMenu;
    }

    public FoodMenuModel getFoodMenu() {
        return foodMenu;
    }
    public void setFoodMenu(FoodMenuModel foodMenu) {
        this.foodMenu = foodMenu;
    }
}
