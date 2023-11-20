package com.example.Enums;

public enum DrinkMenuTypes {
    UNKNOWN,
    ALCOHOL,
    SOFTDRINK;

    public static DrinkMenuTypes get(int opt) {
        DrinkMenuTypes type = null;
        switch (opt) {
            case 0:
                type = UNKNOWN;
                break;
            case 1:
                type = ALCOHOL;
                break;
            case 2:
                type = SOFTDRINK;
                break;
        }

        return type;
    }
}
