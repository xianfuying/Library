package com.twu;

public class Book {
    public int id;
    public String name;
    public int status;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
        setStatus(0);
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

    public void setStatus(int status) {
        this.status = status;
    }
}
