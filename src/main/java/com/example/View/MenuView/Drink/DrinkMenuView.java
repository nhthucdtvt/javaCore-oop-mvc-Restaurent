package com.example.View.MenuView.Drink;

public class DrinkMenuView{
    AlcoholMenuView alcoholMenuView;
    SoftdrinkMenuView softdrinkMenuView;

    public DrinkMenuView(){
        alcoholMenuView = new AlcoholMenuView();
        softdrinkMenuView = new SoftdrinkMenuView();
    }

    public AlcoholMenuView getAlcoholMenuView() {
        return alcoholMenuView;
    }
    public void setAlcoholMenuView(AlcoholMenuView alcoholMenuView) {
        this.alcoholMenuView = alcoholMenuView;
    }
    
    public SoftdrinkMenuView getSoftdrinkMenuView() {
        return softdrinkMenuView;
    }
    public void setSoftdrinkMenuView(SoftdrinkMenuView softdrinkMenuView) {
        this.softdrinkMenuView = softdrinkMenuView;
    }
}
