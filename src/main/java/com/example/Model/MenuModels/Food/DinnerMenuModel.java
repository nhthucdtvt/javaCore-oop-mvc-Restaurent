package com.example.Model.MenuModels.Food;

import com.example.Model.MenuModels.GenericMenuModel;

public class DinnerMenuModel extends GenericMenuModel {
    private static DinnerMenuModel dinnerMenuModel;
    private DinnerMenuModel(){
        super("C:\\Users\\admin.DESKTOP-SPEDQA1\\Desktop\\javatraining\\src\\main\\java\\com\\example\\Db\\Dinner.csv");
    }

    public static DinnerMenuModel getInstance(){
        if (dinnerMenuModel == null) {
            dinnerMenuModel = new DinnerMenuModel();
        }
        return dinnerMenuModel;
    }
}
