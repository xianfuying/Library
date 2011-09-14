package com.twu;

public class CheckLibraryNumberOption implements Option {
    public static final String CONNECT_WITH_LIBRARIAN_INFO = "Please talk to Librarian. Thank you.";
    private User user;
    private Console console;

    public void execute(Biblioteca biblioteca) {
        console = biblioteca.console;
        user = biblioteca.user;
        if (userNotLogIn()) {
            console.show(CONNECT_WITH_LIBRARIAN_INFO);
        } else {
            console.show(user.libraryNumber);
        }
    }

    private boolean userNotLogIn() {
        return user == null;
    }
}
