package com.example.View.MenuView.Food;

public class FoodMenuView{
    BreakfastMenuView breakfastMenuView;
    LunchMenuView lunchMenuView;
    DinnerMenuView dinnerMenuView;

    public FoodMenuView(){
        breakfastMenuView = new BreakfastMenuView();
        lunchMenuView = new LunchMenuView();
        dinnerMenuView = new DinnerMenuView();
    }

    public BreakfastMenuView getBreakfastMenuView() {
        return breakfastMenuView;
    }
    public void setBreakfastMenuView(BreakfastMenuView breakfastMenuView) {
        this.breakfastMenuView = breakfastMenuView;
    }
    
    public LunchMenuView getLunchMenuView() {
        return lunchMenuView;
    }
    public void setLunchMenuView(LunchMenuView lunchMenuView) {
        this.lunchMenuView = lunchMenuView;
    }

    public DinnerMenuView getDinnerMenuView() {
        return dinnerMenuView;
    }

    public void setDinnerMenuView(DinnerMenuView dinnerMenuView) {
        this.dinnerMenuView = dinnerMenuView;
    }
}
