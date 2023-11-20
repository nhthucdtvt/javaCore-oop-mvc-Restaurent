package com.example.Controller.MenuControllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import com.example.Enums.DrinkMenuTypes;
import com.example.Enums.FoodMenuTypes;
import com.example.Enums.MenuTypes;
import com.example.Model.MenuItemModel;
import com.example.Model.MenuModels.GenericMenuModel;
import com.example.Model.MenuModels.MenuManagementModel;
import com.example.Model.MenuModels.Drink.DrinkMenuModel;
import com.example.Model.MenuModels.Food.FoodMenuModel;
import com.example.Utils.CsvHandling;
import com.example.View.MenuView.MenuManagementView;

public class MenuManagementController implements IMenuManagementController{
    private static MenuManagementController menuManagementController;
    private MenuManagementView menuManagementView;
    private MenuManagementModel menuManagementModel;
    
    private MenuManagementController(){
        this.menuManagementView = MenuManagementView.getInstance();
        menuManagementModel = MenuManagementModel.getInstance();
    }

    public static MenuManagementController getInstance() {
        if (menuManagementController == null) {
            menuManagementController = new MenuManagementController();
        }
        return menuManagementController;
    }

    public void add(MenuManagementModel menu){
        MenuItemModel  menuItem = menuManagementView.createMenuItem();
        int option = menuManagementView.getMenuTypes();
        MenuTypes menuTypes = MenuTypes.get(option);
        switch (menuTypes){
            case FOODMENU:
                addToFoodMenu(menu.getFoodMenu(), menuItem);
                break;
            case DRINKMENU:
                addToDrinkMenu(menu.getDrinkMenu(),menuItem);
                break;
        }
    }

    public void addToDrinkMenu(DrinkMenuModel drinkMenu, MenuItemModel menuItem){
        int option = menuManagementView.getDrinkMenuTypes();
        DrinkMenuTypes drinkMenuTypes = DrinkMenuTypes.get(option);
        switch (drinkMenuTypes){
            case ALCOHOL:
                addMenuItemsToMenu(drinkMenu.getAlcoholMenuModel(),menuItem);
                break;

            case SOFTDRINK:
                addMenuItemsToMenu(drinkMenu.getSoftDrinkMenuModel(),menuItem);
                break;
        }
    }

    public void addMenuItemsToMenu(GenericMenuModel genericMenu, MenuItemModel menuItem) {
        ArrayList<MenuItemModel> menuItemList = genericMenu.getMenuItemList();
        menuItemList.sort(Comparator.comparing(MenuItemModel::getId));
        int maxId = menuItemList.get(menuItemList.size() -1).getId();
        System.out.println("maxId=" + maxId);

        // List<ValuePairs> ourValues = new ArrayList<>();
        // ourValues.stream().max(comparing(ValuePairs::getMValue)).get()
        int id = maxId + 1;
        for (int i = 1; i <= maxId; i++){
            boolean isFound = false;
            for (MenuItemModel menuItemModel : menuItemList) {
                if (menuItemModel.getId() == i) {
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                id = i;
                break;
            }
        }
        menuItem.setId(id);
        menuItemList.add(menuItem);

        // store into db file
        CsvHandling csvHandling = CsvHandling.getInstance();
        try {
            csvHandling.csvWriter(genericMenu.getcsvDbPath(), genericMenu);
            System.out.println("Add successful");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Write csv error:" + e.getMessage());
        }
        // System.out.println(genericMenu.getcsvDbPath());
    }

    public void addToFoodMenu(FoodMenuModel foodMenu, MenuItemModel menuItem){
        int option = menuManagementView.getFoodMenuTypes();
        FoodMenuTypes foodMenuTypes = FoodMenuTypes.get(option);
        switch (foodMenuTypes){
            case BREAKFASTMENU:
                addMenuItemsToMenu(foodMenu.getBreakfastMenu(),menuItem);
                break;
            case LUNCHMENU:
                addMenuItemsToMenu(foodMenu.getLunchMenu(),menuItem);
                break;
            case DINNERMENU:
                addMenuItemsToMenu(foodMenu.getDinnerMenu(),menuItem);
                break;
        }
    }

    public void update(MenuManagementModel menu){
        menuManagementView.printMenu(menu);
        String itemName = menuManagementView.getMenuItemName();
        MenuItemModel  menuItem = menuManagementView.createMenuItem();
        int option = menuManagementView.getMenuTypes();
        MenuTypes menuTypes = MenuTypes.get(option-1);
        switch (menuTypes){
            case FOODMENU:
                updateToFoodMenu(menu.getFoodMenu(), menuItem, itemName);
                break;
            case DRINKMENU:
                updateToDrinkMenu(menu.getDrinkMenu(), menuItem, itemName);
                break;
        }
    }

    public void updateMenu(GenericMenuModel genericMenu,MenuItemModel updateMenuItem,String itemName) {
        genericMenu.getMenuItemList().stream()
                                    .filter(menuItem -> menuItem.getName().equals(itemName))
                                    .findFirst()
                                    .ifPresent(menuItem -> {
                                        menuItem.setName(updateMenuItem.getName());
                                        menuItem.setPrice(updateMenuItem.getPrice());
                                        menuItem.setDescription(updateMenuItem.getDescription());
                                        menuItem.setImage(updateMenuItem.getImage());
                                    });

        CsvHandling csvHandling = CsvHandling.getInstance();
        try {
            csvHandling.csvWriter(genericMenu.getcsvDbPath(), genericMenu);
            System.out.println("Update successful");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Write csv error:" + e.getMessage());
        }
    }

    public void updateToDrinkMenu(DrinkMenuModel drinkMenu, MenuItemModel menuItem, String itemName){
        int option = menuManagementView.getDrinkMenuTypes();
        DrinkMenuTypes drinkMenuTypes = DrinkMenuTypes.get(option);
        switch (drinkMenuTypes){
            case ALCOHOL:
                updateMenu(drinkMenu.getAlcoholMenuModel(), menuItem, itemName);
                break;
            case SOFTDRINK:
                updateMenu(drinkMenu.getSoftDrinkMenuModel(), menuItem, itemName);
                break;
        }
    }

    public void updateToFoodMenu(FoodMenuModel foodMenu, MenuItemModel menuItem, String itemName){
        int option = menuManagementView.getFoodMenuTypes();
        FoodMenuTypes foodMenuTypes = FoodMenuTypes.get(option);
        switch (foodMenuTypes){
            case BREAKFASTMENU:
                updateMenu(foodMenu.getBreakfastMenu(), menuItem, itemName);
                break;
            case LUNCHMENU:
                updateMenu(foodMenu.getLunchMenu(), menuItem, itemName);
                break;
            case DINNERMENU:
                updateMenu(foodMenu.getDinnerMenu(), menuItem, itemName);
                break;
        }
    }

    public void delete(MenuManagementModel menu){
        menuManagementView.printMenu(menu);
        String itemName = menuManagementView.getMenuItemName();
        int option = menuManagementView.getMenuTypes();
        MenuTypes menuTypes = MenuTypes.get(option);

        switch (menuTypes){
            case FOODMENU:
                deleteToFoodMenu(menu.getFoodMenu(), itemName);
                break;
            case DRINKMENU:
                deleteToDrinkMenu(menu.getDrinkMenu(), itemName);
                break;
        }
    }

    public void deleteMenu(GenericMenuModel genericMenu, String itemName) {
        genericMenu.getMenuItemList().removeIf(menuItem -> menuItem.getName().equals(itemName));

        CsvHandling csvHandling = CsvHandling.getInstance();
        try {
            csvHandling.csvWriter(genericMenu.getcsvDbPath(), genericMenu);
            System.out.println("Delete successful");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Write csv error:" + e.getMessage());
        }
    }

    public void deleteToDrinkMenu(DrinkMenuModel drinkMenu,String itemName){
        int option = menuManagementView.getDrinkMenuTypes();
        DrinkMenuTypes drinkMenuTypes = DrinkMenuTypes.get(option);
        switch (drinkMenuTypes){
            case ALCOHOL:
                deleteMenu(drinkMenu.getAlcoholMenuModel(), itemName);
                break;
            case SOFTDRINK:
                deleteMenu(drinkMenu.getSoftDrinkMenuModel(), itemName);
                break;
        }
    }

    public void deleteToFoodMenu(FoodMenuModel foodMenu,String itemName){
        int option = menuManagementView.getFoodMenuTypes();
        FoodMenuTypes foodMenuTypes = FoodMenuTypes.get(option);
        switch (foodMenuTypes){
            case BREAKFASTMENU:
                deleteMenu(foodMenu.getBreakfastMenu(), itemName);
                break;
            case LUNCHMENU:
                deleteMenu(foodMenu.getLunchMenu(), itemName);
                break;
            case DINNERMENU:
                deleteMenu(foodMenu.getDinnerMenu(), itemName);
                break;
        }
    }
    public void showMenu(MenuManagementModel menu){
        menuManagementView.printMenu(menu);
    }
    public void exportFile(MenuManagementModel menu) throws IOException {
    }

    // public MenuManagementModel importFile() throws IOException {
    // }

    public boolean retrieveDataFromDb(){
        try {
            CsvHandling csvHandling = CsvHandling.getInstance();
            csvHandling.parseCSVtoBean(menuManagementModel.getFoodMenu().getBreakfastMenu());
            csvHandling.parseCSVtoBean(menuManagementModel.getFoodMenu().getDinnerMenu());
            csvHandling.parseCSVtoBean(menuManagementModel.getFoodMenu().getLunchMenu());
            csvHandling.parseCSVtoBean(menuManagementModel.getDrinkMenu().getSoftDrinkMenuModel());
            csvHandling.parseCSVtoBean(menuManagementModel.getDrinkMenu().getAlcoholMenuModel());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
