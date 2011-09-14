package com.twu;

import org.junit.Before;
import org.junit.Test;

import static com.twu.LoginOption.*;
import static com.twu.LoginOption.LOGGED_IN_SUCCESS;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class LoginOptionTest {

    private LoginOption loginOption;
    private Biblioteca biblioteca;
    private Console console;

    @Before
    public void setUp() {
        loginOption = new LoginOption();
        console = mock(Console.class);
        biblioteca = new Biblioteca(console);
    }

    @Test
    public void should_ask_console_get_usr_input_user_library_number() {
        loginOption.execute(biblioteca);

        verify(console).show(INPUT_YOUR_LIBRARY_NUMBER);
        verify(console).getUserInput();
    }

    @Test
    public void should_ask_console_show_no_user_information() {
        when(console.getUserInput()).thenReturn("234");
        loginOption.execute(biblioteca);
        verify(console).show(USER_DOES_NOT_EXIST);
    }

    @Test
    public void should_ask_console_get_usr_input_password() {
        when(console.getUserInput()).thenReturn("111-1111");
        loginOption.execute(biblioteca);
        verify(console).show(INPUT_YOUR_PASSWORD);
        verify(console, times(2)).getUserInput();
    }

    @Test
    public void should_ask_console_show_password_not_correct() {
        when(console.getUserInput()).thenReturn("111-1111").thenReturn("invalidPassword");
        loginOption.execute(biblioteca);
        verify(console).show(PASSWORD_IS_NOT_CORRECT);
    }

    @Test
    public void should_let_user_login_biblioteca_when_input_correct() {
        when(console.getUserInput()).thenReturn("111-1111").thenReturn("123");
        loginOption.execute(biblioteca);
        assertThat(biblioteca.user, is(new User("111-1111", "123")));
        verify(console).show(LOGGED_IN_SUCCESS);
    }
}
