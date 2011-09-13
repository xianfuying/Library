public class CheckLibraryNumberOption implements Option {
    public static final String CONNECT_WITH_LIBRARIAN_INFO = "Please talk to Librarian. Thank you.";

    public void execute(Biblioteca biblioteca) {
        biblioteca.console.show(CONNECT_WITH_LIBRARIAN_INFO);
    }
}
