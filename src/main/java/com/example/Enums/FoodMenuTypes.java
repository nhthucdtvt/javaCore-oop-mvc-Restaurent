package com.example.Enums;

public enum FoodMenuTypes {
    UNKNOWN,
    BREAKFASTMENU,
    LUNCHMENU,
    DINNERMENU;

    public static FoodMenuTypes get(int opt) {
        FoodMenuTypes type = null;
        switch (opt) {
            case 0:
                type = UNKNOWN;
                break;
            case 1:
                type = BREAKFASTMENU;
                break;
            case 2:
                type = LUNCHMENU;
                break;
            case 3:
                type = DINNERMENU;
                break;
        }

        return type;
    }
}
