package com.twu;

public class ReserveABookOption implements Option {
    public static final String DO_NOT_HAVE_BOOK_INFO = "Sorry we don't have that book yet.";
    public static final String RESERVE_BOOK_SUCCESS_INFO = "Thank You! Enjoy the book.";
    public static final String INPUT_THE_BOOK_NUMBER_YOU_WANT_TO_RESERVE = "Input the book number you want to reserve:";
    public static final String HAVE_NOT_LOG_IN_INFO = "You haven't logged in, Please Login first!";
    private Console console;
    private User user;

    public void execute(Biblioteca biblioteca) {
        console = biblioteca.console;
        user = biblioteca.user;

        if (user == null) {
            console.show(HAVE_NOT_LOG_IN_INFO);
        }
        else {
            reserveBook(biblioteca);
        }
    }

    private void reserveBook(Biblioteca biblioteca) {
        Console console = biblioteca.console;
        console.show(INPUT_THE_BOOK_NUMBER_YOU_WANT_TO_RESERVE);

        int bookId = convertUserInput(console.getUserInput());
        Book book = BookStack.getBook(bookId);

        if (isBookExist(book)) {
            reserveTheBookSelected(book);
        } else {
            console.show(DO_NOT_HAVE_BOOK_INFO);
        }
    }

    private int convertUserInput(String userInput) {
        try {
            return Integer.valueOf(userInput);
        } catch (NumberFormatException exception) {
            return Console.INVALID_INPUT;
        }
    }

    private boolean isBookExist(Book book) {
        return !(book == null || book.status == 1);
    }

    private void reserveTheBookSelected(Book selectBook) {
        if (user.reserveBook(selectBook)) {
            selectBook.setStatus(1);
            console.show(RESERVE_BOOK_SUCCESS_INFO);
        }
    }
}
