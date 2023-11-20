package com.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.Controller.BillControllers.BillManagementControllerImpl;
import com.example.Controller.MenuControllers.MenuManagementController;
import com.example.Enums.ManagementActions;
import com.example.Enums.ManagementTypes;
import com.example.Model.BillModels.BillManagementModel;
import com.example.Model.MenuModels.MenuManagementModel;
import com.example.Utils.CheckOptionValid;
import com.example.Utils.CsvHandling;
import com.example.View.BillView.BillManagementView;

public class Restaurant 
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int option = 0;
        MenuManagementModel menuManagementModel = MenuManagementModel.getInstance();
        BillManagementModel billManagementModel = BillManagementModel.getInstance();
        MenuManagementController menuManagementController = MenuManagementController.getInstance();

        // Load Db to cache
        if (!menuManagementController.retrieveDataFromDb()) {
            System.out.println("Load data from Db failed");
            return;
        }

        while (true){
            System.out.println("\n *** Welcome Restaurant Management ***");
            System.out.println("\n1.Menu management");
            System.out.println("2.Bill management");
            System.out.println("0.Exit");
            System.out.print("Please choose which types Management you want to work with:");
            if ((option = CheckOptionValid.isValidOption(scanner,0, 2)) < 0) {
                continue;
            }
            ManagementTypes types = ManagementTypes.get(option);
            switch (types){
                case MENU:
                    menuMain(menuManagementModel);
                    break;
                case BILL:
                    billMain(billManagementModel);
                    break;
                case UNKNOWN:
                    System.out.println("Bye bye @@");
                    return;
            }
        }
    }

    public static void billMain(BillManagementModel bill) throws IOException {
        int option = 1;
        BillManagementControllerImpl billManagementController =  BillManagementControllerImpl.getInstance();
        BillManagementView billView = BillManagementView.getInstance();
        
        try {
            while (option != 0){

                System.out.println("\nBill management");
                System.out.println("1. Create Bill ");
                System.out.println("2. Update Bill ");
                System.out.println("3. Delete Bill");
                System.out.println("4. Show Bill");
                System.out.println("0. Back");
                System.out.print("\nChoose your option:");

                if ((option = CheckOptionValid.isValidOption(scanner,0,4)) < 0) {
                    continue;
                }

                ManagementActions actions = ManagementActions.get(option);
                switch (actions){
                    case CREATE:
                        billManagementController.addToBill();
                        break;
                    
                    case UPDATE:
                        billManagementController.updateBillItem(bill);
                        break;
                    
                    case DELETE:
                        billManagementController.deleteBillItem(bill);
                        break;

                    case SHOW:
                        billView.printBill(bill);
                        break;

                    case UNKNOWN: 
                        break;
                }
            }
        }catch (NullPointerException | IllegalStateException | InputMismatchException | NumberFormatException exception){
            System.out.println(exception.getMessage());
        }
    }
    public static void menuMain(MenuManagementModel menu) throws IOException{
        // declare instance of MenuManagementController, using singleton to make sure get/set properly db
        MenuManagementController menuManagementController =  MenuManagementController.getInstance();
        int option = 1;

        try {
            while (option != 0) {

                menu();
                if ((option = CheckOptionValid.isValidOption(scanner,0,6)) < 0) {
                    continue;
                }

                ManagementActions actions = ManagementActions.get(option);
                switch (actions) {
                    case CREATE:
                        menuManagementController.add(menu);
                        break;

                    case UPDATE:
                        menuManagementController.update(menu);
                        break;
                    
                    case DELETE:
                        menuManagementController.delete(menu);
                        break;
                    
                    case SHOW:
                        menuManagementController.showMenu(menu);
                        break;
                    
                    case EXPORT:
                        menuManagementController.exportFile(menu);
                        break;

                    case IMPORT:
                        menuManagementController.showMenu(menu);
                        break;
                    
                    case UNKNOWN:
                        break;
                }
            }
        }catch (NullPointerException | IllegalStateException | NumberFormatException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void menu(){
        System.out.println("\nMenu management");
        System.out.println("1. Create Menu Items");
        System.out.println("2. Update Menu Items");
        System.out.println("3. Delete Menu Items");
        System.out.println("4. Show Menu Items");
        System.out.println("5. Export Menu");
        System.out.println("6. Import Menu");
        System.out.println("0. Back");
        System.out.print("\nChoose your option:");
    }
}
