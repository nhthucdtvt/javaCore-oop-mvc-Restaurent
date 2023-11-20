package com.example.Enums;

public enum ManagementActions {
    UNKNOWN,
    CREATE,
    UPDATE,
    DELETE,
    SHOW,
    EXPORT,
    IMPORT;

    public static ManagementActions get(int opt) {
        ManagementActions type = null;
        switch (opt) {
            case 0:
                type = UNKNOWN;
                break;
            case 1:
                type = CREATE;
                break;
            case 2:
                type = UPDATE;
                break;
            case 3:
                type = DELETE;
                break;
            case 4:
                type = SHOW;
                break;
            case 5:
                type = EXPORT;
                break;
            case 6:
                type = IMPORT;
                break;
        }

        return type;
    }
}
