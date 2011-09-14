package com.twu;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        Biblioteca biblioteca = new Biblioteca(console);
        biblioteca.start();
    }
}