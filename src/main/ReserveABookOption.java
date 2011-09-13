public class ReserveABookOption implements Option {
    public static final String DO_NOT_HAVE_BOOK_INFO = "Sorry we don't have that book yet.";
    public static final String RESERVE_BOOK_SUCCESS_INFO = "Thank You! Enjoy the book.";
    public static final String INPUT_THE_BOOK_NUMBER_YOU_WANT_TO_RESERVE = "Input the book number you want to reserve:";

    public void execute(Biblioteca biblioteca) {
        Console console = biblioteca.console;

        console.show(INPUT_THE_BOOK_NUMBER_YOU_WANT_TO_RESERVE);
        int bookId = console.getUserInput();

        if (isBookExist(biblioteca, bookId)) {
            BookStack bookStack = biblioteca.bookStack;
            reserveTheBookSelected(biblioteca, bookStack.getBook(bookId));
        } else {
            console.show(DO_NOT_HAVE_BOOK_INFO);
        }
    }

    private boolean isBookExist(Biblioteca biblioteca, int bookId) {
        return !(bookId == Console.INVALID_INPUT || biblioteca.bookStack.getBook(bookId) == null);
    }

    private void reserveTheBookSelected(Biblioteca biblioteca, Book selectBook) {
        Console console = biblioteca.console;
        User user = biblioteca.user;

        if (user.reserveBook(selectBook)) {
            console.show(RESERVE_BOOK_SUCCESS_INFO);
        }
    }
}
