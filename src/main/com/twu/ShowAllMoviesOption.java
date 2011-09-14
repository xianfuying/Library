package com.twu;

public class ShowAllMoviesOption implements Option {
    public void execute(Biblioteca biblioteca) {
        biblioteca.console.show(MovieStack.getAllMovies());
    }
}
