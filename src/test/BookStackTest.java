import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class BookStackTest {

    private BookStack bookStack;

    @Before
    public void setUp() {
        bookStack = new BookStack();
    }

    @Test
    public void should_store_books_in_the_book_stack() {
        Book book = new Book(123, "book123");
        bookStack.addBook(book);
        assertThat(bookStack.getBookList(), containsString("123. book123"));
    }

    @Test
    public void should_add_default_book_in_book_stack_when_init_book_stack() {
        bookStack.initBookStack();
        assertThat(bookStack.getBookList(), containsString("1. Agile China"));
        assertThat(bookStack.getBookList(), containsString("2. XP"));
    }

    @Test
    public void should_return_book_when_book_exist() {
        Book expected = new Book(3, "book3");
        bookStack.addBook(expected);
        Book book = bookStack.getBook(3);
        assertThat(book, is(expected));
    }

    @Test
    public void should_return_null_when_book_not_exist() {
        assertThat(bookStack.getBook(3), nullValue());
    }
}
