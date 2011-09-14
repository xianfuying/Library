package com.twu;

public class LoginOption implements Option {
    public static final String INPUT_YOUR_LIBRARY_NUMBER = "Input your library number:";
    public static final String USER_DOES_NOT_EXIST = "User does not exist!";
    public static final String INPUT_YOUR_PASSWORD = "Input your password:";
    public static final String PASSWORD_IS_NOT_CORRECT = "Password is not correct!";
    public static final String LOGGED_IN_SUCCESS = "You have logged in!";
    private Console console;
    private String userInputLibraryNumber;
    private String userPassword;

    public void execute(Biblioteca biblioteca) {
        console = biblioteca.console;
        userInputLibraryNumber = getUserLibraryNumber(console);
        userPassword = UserStack.getUserPassword(userInputLibraryNumber);

        if (userPassword == null) {
            console.show(USER_DOES_NOT_EXIST);
        } else {
            getUserPasswordAndLogIn(biblioteca);
        }
    }

    private void getUserPasswordAndLogIn(Biblioteca biblioteca) {
        if (inputPasswordIsNotCorrect()) {
            console.show(PASSWORD_IS_NOT_CORRECT);
        } else {
            userLogIn(biblioteca);
            console.show(LOGGED_IN_SUCCESS);
        }
    }

    private void userLogIn(Biblioteca biblioteca) {
        biblioteca.userLogIn(new User(userInputLibraryNumber, userPassword));
    }

    private boolean inputPasswordIsNotCorrect() {
        return !getUserInputPassword(console).equals(userPassword);
    }

    private String getUserInputPassword(Console console) {
        console.show(INPUT_YOUR_PASSWORD);
        return console.getUserInput();
    }

    private String getUserLibraryNumber(Console console) {
        console.show(INPUT_YOUR_LIBRARY_NUMBER);
        return console.getUserInput();
    }
}
