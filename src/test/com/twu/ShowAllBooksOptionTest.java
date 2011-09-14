package com.twu;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class ShowAllBooksOptionTest {
    @Mock
    private Console console;
    private Biblioteca biblioteca;
    private ShowAllBooksOption showAllBooksOption;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        biblioteca = new Biblioteca(console);
        showAllBooksOption = new ShowAllBooksOption();
    }

    @Test
    public void should_ask_console_show_book_information_when_user_select_to_show_all_books() {
        showAllBooksOption.execute(biblioteca);
        verify(console).show("1. Agile China\n2. XP");
    }
}
