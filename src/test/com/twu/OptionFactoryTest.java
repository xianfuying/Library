package com.twu;

import org.junit.Test;

import static com.twu.MenuOption.*;
import static com.twu.MenuOption.LOG_IN;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OptionFactoryTest {
    @Test
    public void should_create_show_all_books_option_when_given_menu_option() {
        Option option = OptionFactory.generateOption(SHOW_ALL_BOOKS);
        assertThat(option, is(ShowAllBooksOption.class));
    }

    @Test
    public void should_create_reserve_a_book_option_when_given_menu_option() {
        Option option = OptionFactory.generateOption(RESERVE_A_BOOK);
        assertThat(option, is(ReserveABookOption.class));
    }

    @Test
    public void should_create_check_library_number_option_when_given_menu_option() {
        Option option = OptionFactory.generateOption(CHECK_LIBRARY_NUMBER);
        assertThat(option, is(CheckLibraryNumberOption.class));
    }

    @Test
    public void should_create_show_all_movies_option_when_given_menu_option() {
        Option option = OptionFactory.generateOption(SHOW_ALL_MOVIES);
        assertThat(option, is(ShowAllMoviesOption.class));
    }

    @Test
    public void should_create_log_in_option_when_given_menu_option() {
        Option option = OptionFactory.generateOption(LOG_IN);
        assertThat(option, is(LoginOption.class));

    }
}
