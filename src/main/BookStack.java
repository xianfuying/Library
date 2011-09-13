import java.util.ArrayList;
import java.util.List;

public class BookStack {
    private List<Book> books;

    public BookStack() {
        books = new ArrayList<Book>();
    }

    public String getBookList() {
        StringBuffer bookList = new StringBuffer();
        for (Book book : books) {
            bookList.append(book.id + ". " + book.name + "\n");
        }
        return bookList.toString().trim();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void initBookStack() {
        books.add(new Book(1, "Agile China"));
        books.add(new Book(2, "XP"));
    }

    public Book getBook(int bookId) {
        for (Book book : books) {
            if (book.id == bookId) {
                return book;
            }
        }
        return null;
    }
}
