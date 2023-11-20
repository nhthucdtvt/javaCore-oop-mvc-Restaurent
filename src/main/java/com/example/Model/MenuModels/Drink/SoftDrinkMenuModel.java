package com.example.Model.MenuModels.Drink;

import com.example.Model.MenuModels.GenericMenuModel;

public class SoftDrinkMenuModel extends GenericMenuModel{
    private static SoftDrinkMenuModel softDrinkMenuModel;
    private SoftDrinkMenuModel(){
        super("C:\\Users\\admin.DESKTOP-SPEDQA1\\Desktop\\javatraining\\src\\main\\java\\com\\example\\Db\\Softdrink.csv");
    }

    public static SoftDrinkMenuModel getInstance(){
        if (softDrinkMenuModel == null) {
            softDrinkMenuModel = new SoftDrinkMenuModel();
        }
        return softDrinkMenuModel;
    }
}
