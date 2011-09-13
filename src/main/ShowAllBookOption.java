public class ShowAllBookOption implements Option{

    public void execute(Biblioteca biblioteca) {
        Console console = biblioteca.console;
        BookStack bookStack = biblioteca.bookStack;

        console.show(bookStack.getBookList());
    }
}
