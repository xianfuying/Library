package com.twu;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ShowAllMoviesOptionTest {

    private Console console;

    @Test
    public void should_ask_console_to_show_all_movies() {
        console = mock(Console.class);
        Console console = this.console;
        Biblioteca biblioteca = new Biblioteca(console);

        ShowAllMoviesOption showAllMoviesOption = new ShowAllMoviesOption();
        showAllMoviesOption.execute(biblioteca);

        verify(console).show(MovieStack.getAllMovies());
    }
}
