package com.example.Controller.BillControllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.Enums.DrinkMenuTypes;
import com.example.Enums.FoodMenuTypes;
import com.example.Enums.MenuTypes;
import com.example.Model.MenuItemModel;
import com.example.Model.BillModels.BillItem;
import com.example.Model.BillModels.BillManagementModel;
import com.example.Model.MenuModels.MenuManagementModel;
import com.example.View.BillView.BillManagementView;
import com.example.View.MenuView.MenuManagementView;

public class BillManagementControllerImpl implements IBillManagementController{
    private static BillManagementControllerImpl billManagementController;
    private BillManagementView billManagementView;
    private MenuManagementView menuManagementView;
    private BillManagementModel billManagementModel;
    private Scanner scanner;
    
    private BillManagementControllerImpl(){
        this.billManagementView = BillManagementView.getInstance();
        this.billManagementModel = BillManagementModel.getInstance();
        menuManagementView = MenuManagementView.getInstance();
        scanner = menuManagementView.getScanner();
    }

    public static BillManagementControllerImpl getInstance() {
        if (billManagementController == null) {
            billManagementController = new BillManagementControllerImpl();
        }
        return billManagementController;
    }

    public void addToBill(){
        // show menu to choose
        MenuManagementModel menuManagementModel = MenuManagementModel.getInstance();
        MenuItemModel model;

        int option = menuManagementView.getMenuTypes();
        MenuTypes menuTypes = MenuTypes.get(option);
        switch (menuTypes){
            case FOODMENU:
                option = menuManagementView.getFoodMenuTypes();
                FoodMenuTypes foodMenuTypes = FoodMenuTypes.get(option);
                switch (foodMenuTypes){
                    case BREAKFASTMENU:
                        // show menu breakfast
                        menuManagementView.getFoodMenuView().getBreakfastMenuView().printDetails(menuManagementModel.getFoodMenu().getBreakfastMenu());
                        System.out.print("\nChoose which item you want to use:");
                        option = Integer.parseInt(scanner.nextLine());

                        // get itemById
                        model = menuManagementModel.getFoodMenu().getBreakfastMenu().gMenuItemModelById(option);
                        addMenuItemsToBill(model);
                        break;
                    case LUNCHMENU:
                        // show menu lunch
                        menuManagementView.getFoodMenuView().getLunchMenuView().printDetails(menuManagementModel.getFoodMenu().getLunchMenu());
                        System.out.print("\nChoose which item you want to use:");
                        option = Integer.parseInt(scanner.nextLine());

                        // get itemById
                        model = menuManagementModel.getFoodMenu().getLunchMenu().gMenuItemModelById(option);
                        addMenuItemsToBill(model);
                        break;
                    case DINNERMENU:
                        // show menu dinner
                        menuManagementView.getFoodMenuView().getDinnerMenuView().printDetails(menuManagementModel.getFoodMenu().getDinnerMenu());
                        System.out.print("\nChoose which item you want to use:");
                        option = Integer.parseInt(scanner.nextLine());

                        // get itemById
                        model = menuManagementModel.getFoodMenu().getDinnerMenu().gMenuItemModelById(option);
                        addMenuItemsToBill(model);
                        break;
                }
                break;
            case DRINKMENU:
                option = menuManagementView.getDrinkMenuTypes();
                DrinkMenuTypes drinkMenuTypes = DrinkMenuTypes.get(option-1);
                switch (drinkMenuTypes){
                    case ALCOHOL:
                        // show menu alcohol
                        menuManagementView.getDrinkMenuView().getAlcoholMenuView().printDetails(menuManagementModel.getDrinkMenu().getAlcoholMenuModel());
                        System.out.print("\nChoose which item you want to use:");
                        option = Integer.parseInt(scanner.nextLine());

                        // get itemById
                        model = menuManagementModel.getDrinkMenu().getAlcoholMenuModel().gMenuItemModelById(option);
                        addMenuItemsToBill(model);
                        break;
                    case SOFTDRINK:
                        // show menu lunch
                        menuManagementView.getDrinkMenuView().getSoftdrinkMenuView().printDetails(menuManagementModel.getDrinkMenu().getSoftDrinkMenuModel());
                        System.out.print("\nChoose which item you want to use:");
                        option = Integer.parseInt(scanner.nextLine());

                        // get itemById
                        model = menuManagementModel.getDrinkMenu().getSoftDrinkMenuModel().gMenuItemModelById(option);
                        addMenuItemsToBill(model);
                        break;
                }
                break;
        }
    }

    public void addMenuItemsToBill(MenuItemModel menuItem){
        if (menuItem != null) {
            // add to bill
            BillItem billItem = new BillItem();
            ArrayList<BillItem> billItems = billManagementModel.getListBillItems();
            
            boolean isModelFound = false;
            for (int i = 0; i < billItems.size(); i++) {
                System.out.println(billItems.size() + ", " + i);
                if (billItems.get(i).getMenuItemModel().equals(menuItem)) {
                    billItems.get(i).setQuantities(billItems.get(i).getQuantities() + 1);
                    billItems.get(i).setTotalPrice(billItems.get(i).getQuantities() * menuItem.getPrice());
                    isModelFound = true;
                    break;
                }
            }
            if (!isModelFound) {
                billItem.setQuantities(1);
                billItem.setMenuItemModel(menuItem);
                billItem.setTotalPrice(menuItem.getPrice());
                billItems.add(billItem);
            }
            
            billManagementModel.setListBillItems(billItems);
            billItems = billManagementModel.getListBillItems();
            
            double totalPrice = 0;
            for (BillItem item : billItems) {
                totalPrice += item.getTotalPrice();
            }
            billManagementModel.setTotalPrice(totalPrice);
            billManagementModel.setOrderTime(LocalDateTime.now());
            System.out.println("Add item to bill successful");
        }else{
            System.out.println("Found no item");
        }
    }

    public void updateBillItem(BillManagementModel bill){
        billManagementView.printBill(bill);
        BillItem updateItem = billManagementView.enterUpdateBillItemInfo();
        ArrayList<BillItem> billItems = bill.getListBillItems();
        boolean isItemFound = false;
        for (BillItem billItem : billItems) {
            if (billItem.getMenuItemModel().getName().equals(updateItem.getMenuItemModel().getName())) {
                billItem.setQuantities(updateItem.getQuantities());
                isItemFound = true;
                System.out.println("Update successful");
            }
        }
        
        if (!isItemFound) {
            System.out.println("Item not found, update failed");
        }
    }

    public void deleteBillItem(BillManagementModel bill){
        billManagementView.printBill(bill);
        BillItem deleteItem = billManagementView.enterDeleteBillItemInfo();
        ArrayList<BillItem> billItems = bill.getListBillItems();
        boolean isItemFound = false;
        for (int index = 0; index < billItems.size(); index++) {
            if (billItems.get(index).getMenuItemModel().getName().equals(deleteItem.getMenuItemModel().getName())) {
                billItems.remove(index);
                isItemFound = true;
                System.out.println("Delete successful");
            }
        }
        
        if (!isItemFound) {
            System.out.println("Item not found, delete failed");
        }
    }
}
