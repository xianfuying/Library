import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String userName;
    public List<Book> reservedBooks;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        reservedBooks = new ArrayList<Book>();
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return this.userId == user.userId && this.userName == user.userName;
    }

    @Override
    public int hashCode() {
        return userId;
    }

    @Override
    public String toString() {
        return userId + " " + userName;
    }

    public Boolean reserveBook(Book book) {
        return reservedBooks.add(book);
    }
}
