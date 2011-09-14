package com.twu;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.twu.ReserveABookOption.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReserveABookOptionTest {
    @Mock
    private Console console;
    private Biblioteca biblioteca;
    private ReserveABookOption reserveABookOption;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        biblioteca = new Biblioteca(console);
        reserveABookOption = new ReserveABookOption();
    }

    @Test
    public void should_ask_biblioteca_to_show_log_in_info_if_user_does_not_logged_in() {
        reserveABookOption.execute(biblioteca);
        verify(console).show(ReserveABookOption.HAVE_NOT_LOG_IN_INFO);
    }

    private void userLogin() {
        biblioteca.userLogIn(new User("11", "ss"));
    }

    @Test
    public void should_ask_biblioteca_show_input_selected_book_id_if_user_have_logged_in() {
        userLogin();
        reserveABookOption.execute(biblioteca);
        verify(console).show(INPUT_THE_BOOK_NUMBER_YOU_WANT_TO_RESERVE);
    }

    @Test
    public void should_get_user_input_of_the_book_num_if_user_have_logged_in() {
        userLogin();
        reserveABookOption.execute(biblioteca);
        verify(console).getUserInput();
    }

    @Test
    public void should_ask_biblioteca_to_show_do_not_have_book_info_if_user_have_logged_in() {
        userLogin();
        when(console.getUserInput()).thenReturn("3");

        reserveABookOption.execute(biblioteca);
        verify(console).show(DO_NOT_HAVE_BOOK_INFO);
    }

    @Test
    public void should_ask_biblioteca_to_show_reserve_success_info_if_the_book_exist_and_user_have_logged_in() {
        userLogin();
        when(console.getUserInput()).thenReturn("1");

        reserveABookOption.execute(biblioteca);

        verify(console).show(RESERVE_BOOK_SUCCESS_INFO);
    }

    @Test
    public void should_ask_biblioteca_to_show_do_not_have_book_info_if_user_input_invalid_and_user_have_logged_in() {
        userLogin();
        when(console.getUserInput()).thenReturn("invalid");

        reserveABookOption.execute(biblioteca);
        verify(console).show(DO_NOT_HAVE_BOOK_INFO);
    }

    @Test
    public void should_ask_biblioteca_to_show_do_not_have_book_info_if_book_have_been_reserved() {
        userLogin();
        Book book = BookStack.getBook(1);
        book.setStatus(1);
        when(console.getUserInput()).thenReturn("1");

        reserveABookOption.execute(biblioteca);
        verify(console).show(DO_NOT_HAVE_BOOK_INFO);
    }

    @Test
    public void should_set_book_status_to_reserved_when_book_reserved_success() {
        userLogin();
        when(console.getUserInput()).thenReturn("1");

        reserveABookOption.execute(biblioteca);
        assertThat(BookStack.getBook(1).status, is(1));
    }
}
