package com.example.Model.MenuModels.Drink;

import com.example.Model.MenuModels.GenericMenuModel;

public class AlcoholMenuModel extends GenericMenuModel {
    private static AlcoholMenuModel alcoholMenuModel;
    private AlcoholMenuModel(){
        super("C:\\Users\\admin.DESKTOP-SPEDQA1\\Desktop\\javatraining\\src\\main\\java\\com\\example\\Db\\Alcohol.csv");
    }

    public static AlcoholMenuModel getInstance(){
        if (alcoholMenuModel == null) {
            alcoholMenuModel = new AlcoholMenuModel();
        }
        return alcoholMenuModel;
    }
}
