package com.twu;

public enum MenuOption {
    SHOW_ALL_BOOKS("Show All Books", 1),
    RESERVE_A_BOOK("Reserve A com.twu.Book", 2),
    CHECK_LIBRARY_NUMBER("Check Library Number", 3),
    SHOW_ALL_MOVIES("Show All Movies", 4),
    LOG_IN("Log in", 5);
    private String optionString;
    private int index;

    MenuOption(String optionString, int index) {
        this.optionString = optionString;
        this.index = index;
    }

    public String toString() {
        return optionString;
    }

    public static MenuOption getOption(int userInput) {
        for (MenuOption menuOption : MenuOption.values()) {
            if (userInput == menuOption.index)
                return menuOption;
        }
        return null;
    }

    public static String getAllOptions() {
        StringBuffer allOptions = new StringBuffer();
        for (MenuOption menuOption : MenuOption.values()) {
            allOptions.append(menuOption.index + ". " + menuOption.optionString + "\n");
        }
        return allOptions.toString().trim();
    }
}
