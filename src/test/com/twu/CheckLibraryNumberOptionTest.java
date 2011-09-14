package com.twu;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.twu.CheckLibraryNumberOption.*;
import static org.mockito.Mockito.verify;

public class CheckLibraryNumberOptionTest {
    @Mock
    private Console console;
    private CheckLibraryNumberOption checkLibraryNumberOption;
    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        biblioteca = new Biblioteca(console);
        checkLibraryNumberOption = new CheckLibraryNumberOption();
    }

    @Test
    public void should_ask_biblioteca_to_show_connect_with_librarian_info_if_user_does_not_logged_in() {
        checkLibraryNumberOption.execute(biblioteca);
        verify(console).show(CONNECT_WITH_LIBRARIAN_INFO);
    }

    @Test
    public void should_ask_biblioteca_to_show_library_number_if_user_have_logged_in() {
        biblioteca.userLogIn(new User("111-11", "123"));
        checkLibraryNumberOption.execute(biblioteca);
        verify(console).show("111-11");
    }
}
