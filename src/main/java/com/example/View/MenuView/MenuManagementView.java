package com.example.View.MenuView;

import java.util.Scanner;

import com.example.Model.MenuItemModel;
import com.example.Model.MenuModels.MenuManagementModel;
import com.example.Utils.CheckOptionValid;
import com.example.View.MenuView.Drink.DrinkMenuView;
import com.example.View.MenuView.Food.FoodMenuView;

public class MenuManagementView {
    private FoodMenuView foodMenuView;
    private DrinkMenuView drinkMenuView;
    private Scanner scanner;
    public Scanner getScanner() {
        return scanner;
    }
    private static MenuManagementView menuManagementView;

    public FoodMenuView getFoodMenuView() {
        return foodMenuView;
    }

    public void setFoodMenuView(FoodMenuView foodMenuView) {
        this.foodMenuView = foodMenuView;
    }

    public DrinkMenuView getDrinkMenuView() {
        return drinkMenuView;
    }

    public void setDrinkMenuView(DrinkMenuView drinkMenuView) {
        this.drinkMenuView = drinkMenuView;
    }

    private MenuManagementView(){
        foodMenuView = new FoodMenuView();
        drinkMenuView = new DrinkMenuView();
        scanner = new Scanner(System.in);
    }

    public static MenuManagementView getInstance(){
        if (menuManagementView == null) {
            menuManagementView = new MenuManagementView();
        }
        return menuManagementView;
    }

    public void printMenu(MenuManagementModel menu) {
        System.out.println("----- Menu Management -----");
        System.out.println("===========================");
        
        // Food        
        System.out.println("------- Food Menu ---------");
        System.out.println("===========================");

        foodMenuView.getBreakfastMenuView().printDetails(menu.getFoodMenu().getBreakfastMenu());
        foodMenuView.getLunchMenuView().printDetails(menu.getFoodMenu().getLunchMenu());
        foodMenuView.getDinnerMenuView().printDetails(menu.getFoodMenu().getDinnerMenu());
        
        System.out.println("-------- Drink Menu -------");
        System.out.println("===========================");
        drinkMenuView.getSoftdrinkMenuView().printDetails(menu.getDrinkMenu().getSoftDrinkMenuModel());
        drinkMenuView.getAlcoholMenuView().printDetails(menu.getDrinkMenu().getAlcoholMenuModel());
    }
    
    public int getMenuTypes(){
        int option = 1;
        while (true) {
            menu();
            if ((option = CheckOptionValid.isValidOption(scanner,1,2)) < 0) {
                continue;
            }
            break;
        }
        
        return option;
    }
    public int getFoodMenuTypes(){
        int option = 1;
        while (true) {
            foodMenu();
            if ((option = CheckOptionValid.isValidOption(scanner,1,3)) < 0) {
                continue;
            }
            break;
        }
        
        return option;
    }
    public int getDrinkMenuTypes(){
        int option = 1;
        while (true) {
            drinkMenu();
            if ((option = CheckOptionValid.isValidOption(scanner,1,2)) < 0) {
                continue;
            }
            break;
        }
        
        return option;
    }
    public MenuItemModel createMenuItem(){
        MenuItemModel menuItem = new MenuItemModel();
        System.out.print("\n Insert item name: ");
        menuItem.setName(scanner.nextLine());
        System.out.print(" Insert item description: ");
        menuItem.setDescription(scanner.nextLine());
        System.out.print(" Insert item image: ");
        menuItem.setImage(scanner.nextLine());
        System.out.print(" Insert item price: ");
        menuItem.setPrice(Float.parseFloat(scanner.nextLine()));
        return menuItem;
    }
    public String getMenuItemName(){
        System.out.print("Enter menu item name you want to change: ");
        return scanner.nextLine();
    }

    public static void menu(){
        System.out.println("\n 1. Food Menu");
        System.out.println(" 2. Drink Menu");
        System.out.print(" Choose your option:");
    }
    public static void drinkMenu(){
        System.out.println("\n1. Alcohol Menu");
        System.out.println("2. Soft drink Menu");
        System.out.print("Choose which menu you want to use:");
    }
    public static void foodMenu(){
        System.out.println("\n1. Breakfast Menu");
        System.out.println("2. Lunch Menu");
        System.out.println("3. Dinner Menu");
        System.out.print("\nChoose which menu you want to use:");
    }

}