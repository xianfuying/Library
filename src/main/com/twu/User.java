package com.twu;

import java.util.ArrayList;
import java.util.List;

public class User {
    public List<Book> reservedBooks;
    protected String libraryNumber;
    protected String password;

    public User(String libraryNumber, String password) {
        reservedBooks = new ArrayList<Book>();
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return this.libraryNumber == user.libraryNumber && this.password == user.password;
    }

    @Override
    public int hashCode() {
        return libraryNumber.hashCode()+password.hashCode();
    }

    @Override
    public String toString() {
        return libraryNumber;
    }

    public Boolean reserveBook(Book book) {
        return reservedBooks.add(book);
    }
}
