package com.example.Model.MenuModels.Food;

import com.example.Model.MenuModels.GenericMenuModel;

public class BreakfastMenuModel extends GenericMenuModel{
    private static BreakfastMenuModel breakfastMenuModel;
    private BreakfastMenuModel(){
        super("C:\\Users\\admin.DESKTOP-SPEDQA1\\Desktop\\javatraining\\src\\main\\java\\com\\example\\Db\\Breakfast.csv");
    }

    public static BreakfastMenuModel getInstance(){
        if (breakfastMenuModel == null) {
            breakfastMenuModel = new BreakfastMenuModel();
        }
        return breakfastMenuModel;
    }
}
