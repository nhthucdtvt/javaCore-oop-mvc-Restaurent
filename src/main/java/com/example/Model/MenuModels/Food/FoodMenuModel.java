package com.example.Model.MenuModels.Food;

public class FoodMenuModel {
    private BreakfastMenuModel breakfastMenu;
    private DinnerMenuModel dinnerMenu;
    private LunchMenuModel lunchMenu;

    public FoodMenuModel(){
        breakfastMenu = BreakfastMenuModel.getInstance();
        dinnerMenu = DinnerMenuModel.getInstance();
        lunchMenu = LunchMenuModel.getInstance();
    }
    public FoodMenuModel(BreakfastMenuModel breakfastMenu, DinnerMenuModel dinnerMenu, LunchMenuModel lunchMenu){
        this.breakfastMenu = breakfastMenu;
        this.dinnerMenu = dinnerMenu;
        this.lunchMenu = lunchMenu;
    }

    public void setBreakfastMenu(BreakfastMenuModel breakfast) {
        this.breakfastMenu = breakfast;
    }
    public BreakfastMenuModel getBreakfastMenu() {
        return breakfastMenu;
    }

    public void setDinnerMenu(DinnerMenuModel dinner) {
        this.dinnerMenu = dinner;
    }
    public DinnerMenuModel getDinnerMenu() {
        return dinnerMenu;
    }

    public void setLunchMenu(LunchMenuModel lunch) {
        this.lunchMenu = lunch;
    }
    public LunchMenuModel getLunchMenu() {
        return lunchMenu;
    }
}