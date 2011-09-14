package com.twu;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.twu.Biblioteca.*;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaTest {
    @Mock
    private Console mockConsole;

    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        biblioteca = new Biblioteca(mockConsole);
    }

    @Test
    public void should_init_book_stack_when_biblioteca_created() {
        assertThat(BookStack.getBookList(), containsString("1. Agile China"));
    }

    @Test
    public void should_init_movie_stack_when_biblioteca_created(){
        assertThat(MovieStack.getAllMovies(), containsString("BlackSwing Tomas 2"));
    }

    @Test
    public void should_init_user_stack_when_biblioteca_created(){
        assertThat(UserStack.users, hasItem(new User("111-1111", "123")));
    }

    @Test
    public void should_ask_console_show_welcome_message_when_system_start() {
        biblioteca.start();
        verify(mockConsole).show(WELCOME_MESSAGE);
    }

    @Test
    public void should_ask_console_show_menu_option_when_system_start() {
        biblioteca.start();
        verify(mockConsole).show(MenuOption.getAllOptions());
    }

    @Test
    public void should_ask_console_show_input_choose_option_number_when_system_start() {
        biblioteca.start();
        verify(mockConsole).show(INPUT_CHOSEN_OPTION);
    }

    @Test
    public void should_ask_console_get_user_input_when_system_start() {
        biblioteca.start();
        verify(mockConsole).getUserInput();
    }

    @Test
    public void should_ask_console_show_select_valid_option_message_when_user_input_invalid_option() {

        when(mockConsole.getUserInput()).thenReturn("7");

        biblioteca.start();
        verify(mockConsole).show(ERROR_INFO_SELECT_A_VALID_OPTION);
    }

    @Test
    public void should_ask_console_show_input_option_number_info(){
        when(mockConsole.getUserInput()).thenReturn("INVALID INPUT");

        biblioteca.start();
        verify(mockConsole).show(ERROR_INFO_SELECT_A_VALID_OPTION);
    }
}
