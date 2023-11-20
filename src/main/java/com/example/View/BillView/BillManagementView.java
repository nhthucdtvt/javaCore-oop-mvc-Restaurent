package com.example.View.BillView;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.Model.BillModels.BillItem;
import com.example.Model.BillModels.BillManagementModel;

public class BillManagementView{
    private Scanner scanner = new Scanner(System.in);
    private static BillManagementView billManagementView;

    private BillManagementView(){
    }
    public static BillManagementView getInstance(){
        if (billManagementView == null) {
            billManagementView = new BillManagementView();
        }
        return billManagementView;
    }

    public int getMenuTypes(){
        menu();
        return Integer.parseInt(scanner.nextLine());
    }
    public int getFoodMenuTypes(){
        foodMenu();
        return Integer.parseInt(scanner.nextLine());
    }
    public int getDrinkMenuTypes(){
        drinkMenu();
        return Integer.parseInt(scanner.nextLine());
    }
    public BillItem enterUpdateBillItemInfo(){
        BillItem billItem = new BillItem();
        System.out.print("\n Enter item name: ");
        billItem.getMenuItemModel().setName(scanner.nextLine());
        System.out.print(" Enter quantities: ");
        billItem.setQuantities(Integer.parseInt(scanner.nextLine()));

        return billItem;
    }

    public BillItem enterDeleteBillItemInfo(){
        BillItem billItem = new BillItem();
        System.out.print("\n Enter item name: ");
        billItem.getMenuItemModel().setName(scanner.nextLine());

        return billItem;
    }

    public String getMenuItemName(){
        System.out.print("Insert Menu item you want to change: ");
        return scanner.nextLine();
    }

    public static void menu(){
        System.out.println("\n 1. Food Menu");
        System.out.println(" 2. Drink Menu");
        System.out.print(" Choose your option:");
    }
    public static void drinkMenu(){
        System.out.println("1. Alcohol Menu");
        System.out.println("2. Soft drink Menu");
        System.out.print("Choose which menu you want to use:");
    }
    public static void foodMenu(){
        System.out.println("\n1. Breakfast Menu");
        System.out.println("2. Lunch Menu");
        System.out.println("3. Dinner Menu");
        System.out.print("\nChoose which menu you want to use:");
    }

    public void printBill(BillManagementModel bill) {
        System.out.println("------ Bill Management ------");
        System.out.println("=============================");
        
        ArrayList<BillItem> billItems = bill.getListBillItems();
        for (BillItem billItem : billItems) {
            System.out.println("Name:" + billItem.getMenuItemModel().getName() + ", Quantities:" + billItem.getQuantities() + ", Total Price:" + billItem.getTotalPrice());
            System.out.println("----------------------------");
        }
        System.out.println("----------------------------");

        if (billItems.size() > 0) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = bill.getOrderTime().format(dateTimeFormatter);
            System.out.println("Ordered Time:" + formattedDate);
            System.out.println("Bill Total Price:" + bill.getTotalPrice());
        }
        
        System.out.println("=============================");
    }

}