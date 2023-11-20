package com.example.Model.MenuModels.Food;

import com.example.Model.MenuModels.GenericMenuModel;

public class LunchMenuModel extends GenericMenuModel{
    private static LunchMenuModel lunchMenuModel;
    private LunchMenuModel(){
        super("C:\\Users\\admin.DESKTOP-SPEDQA1\\Desktop\\javatraining\\src\\main\\java\\com\\example\\Db\\Lunch.csv");
    }

    public static LunchMenuModel getInstance(){
        if (lunchMenuModel == null) {
            lunchMenuModel = new LunchMenuModel();
        }
        return lunchMenuModel;
    }
}
