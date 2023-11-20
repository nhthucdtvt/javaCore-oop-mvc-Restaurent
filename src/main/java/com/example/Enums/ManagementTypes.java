package com.example.Enums;

public enum ManagementTypes {
    UNKNOWN,
    MENU,
    BILL;

    public static ManagementTypes get(int opt) {
        ManagementTypes type = null;
        switch (opt) {
            case 0:
                type = UNKNOWN;
                break;
            case 1:
                type = MENU;
                break;
            case 2:
                type = BILL;
                break;
        }

        return type;
    }
}
