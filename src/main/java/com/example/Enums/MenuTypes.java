package com.example.Enums;

public enum MenuTypes {
    UNKNOWN,
    FOODMENU,
    DRINKMENU;

    public static MenuTypes get(int opt) {
        MenuTypes type = null;
        switch (opt) {
            case 0:
                type = UNKNOWN;
                break;
            case 1:
                type = FOODMENU;
                break;
            case 2:
                type = DRINKMENU;
                break;
        }

        return type;
    }
}
