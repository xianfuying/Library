package com.twu;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookTest {
    @Test
    public void should_create_a_book_with_0_status() {
        Book book = new Book(1, "book1");
        assertThat(book.status, is(0));
    }

    @Test
    public void should_set_book_status() {
        Book book = new Book(1, "book1");
        book.setStatus(1);
        assertThat(book.status, is(1));
    }
}
