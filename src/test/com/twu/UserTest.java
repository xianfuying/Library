package com.twu;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;

public class UserTest {
    @Test
    public void should_set_the_book_to_collection() {
        User user = new User("111-1111", "123");
        Book book = new Book(1, "book1");
        user.reserveBook(book);
        assertThat(user.reservedBooks, hasItem(book));
    }
}
