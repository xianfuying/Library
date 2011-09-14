package com.twu;

public class ShowAllBooksOption implements Option {

    public void execute(Biblioteca biblioteca) {
        Console console = biblioteca.console;

        console.show(BookStack.getBookList_old());
    }
}
