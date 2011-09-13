public class Book {
    public int id;
    public String name;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Book book = (Book) obj;
        return this.id == book.id && this.name == book.name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
