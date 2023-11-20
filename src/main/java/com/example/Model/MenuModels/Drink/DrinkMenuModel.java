package com.example.Model.MenuModels.Drink;

public class DrinkMenuModel {
    private SoftDrinkMenuModel softDrinkMenuModel;
    private AlcoholMenuModel alcoholMenuModel;

    public DrinkMenuModel(){
        softDrinkMenuModel = SoftDrinkMenuModel.getInstance();
        alcoholMenuModel = AlcoholMenuModel.getInstance();
    }
    public DrinkMenuModel(SoftDrinkMenuModel softDrinkMenuModel, AlcoholMenuModel alcoholMenuModel){
        this.softDrinkMenuModel = softDrinkMenuModel;
        this.alcoholMenuModel = alcoholMenuModel;
    }
    
    public SoftDrinkMenuModel getSoftDrinkMenuModel() {
        return softDrinkMenuModel;
    }
    public void setSoftDrinkMenuModel(SoftDrinkMenuModel softDrinkMenuModel) {
        this.softDrinkMenuModel = softDrinkMenuModel;
    }

    public AlcoholMenuModel getAlcoholMenuModel() {
        return alcoholMenuModel;
    }
    public void setAlcoholMenuModel(AlcoholMenuModel alcoholMenuModel) {
        this.alcoholMenuModel = alcoholMenuModel;
    }
}
