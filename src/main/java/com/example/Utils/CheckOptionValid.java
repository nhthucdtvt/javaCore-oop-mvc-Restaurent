package com.example.Utils;

import java.util.Scanner;

public class CheckOptionValid {
    public static int isValidOption(Scanner scanner, int optMin, int maxOption){
        int option = -1;
        try {
                option = Integer.parseInt(scanner.nextLine());
                System.out.println(option);
                if (option < optMin || option > maxOption) {
                    System.out.println("Wrong option, try again");
                    option = -1;
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Wrong option, try again");
            }
        return option;
    }
}
