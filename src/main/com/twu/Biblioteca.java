package com.twu;

public class Biblioteca {
    public static final String ERROR_INFO_SELECT_A_VALID_OPTION = "Select a valid option!!";
    public static final String WELCOME_MESSAGE = "Welcome to Bangalore Public Library System";
    public static final String INPUT_CHOSEN_OPTION = "Input your choose:";
    protected Console console;
    protected User user;

    public Biblioteca(Console console) {
        this.console = console;
        user = null;
        BookStack.initBookStack();
        MovieStack.initMovieStack();
        UserStack.initUserStack();
    }

    private void selectMenuOption() {
        int selectedMenuOption = convertUserInput(console.getUserInput());

        MenuOption selectOption = generateSelectedMenuOption(selectedMenuOption);

        if (selectOption == null) {
            console.show(ERROR_INFO_SELECT_A_VALID_OPTION);
        } else {
            executeSelectOption(selectOption);
            start();
        }
    }

    private int convertUserInput(String userInput) {
        try {
            return Integer.valueOf(userInput);
        } catch (NumberFormatException exception) {
            return Console.INVALID_INPUT;
        }
    }

    private MenuOption generateSelectedMenuOption(int userInput) {
        if (isInvalidMenuOption(userInput)) {
            return null;
        }
        return MenuOption.getOption(userInput);
    }

    private boolean isInvalidMenuOption(int userInput) {
        return userInput == Console.INVALID_INPUT || MenuOption.getOption(userInput) == null;
    }

    private void executeSelectOption(MenuOption selectedOption) {
        Option option = OptionFactory.generateOption(selectedOption);
        option.execute(this);
    }

    public void start() {
        console.show(WELCOME_MESSAGE);
        console.show(MenuOption.getAllOptions());
        console.show(INPUT_CHOSEN_OPTION);
        selectMenuOption();
    }

    public void userLogIn(User user) {
        this.user = user;
    }
}
