import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OptionFactoryTest {
    @Test
    public void should_create_show_all_books_option_when_given_menu_option() {
        Option option = OptionFactory.generateOption(MenuOption.SHOW_ALL_BOOKS);
        assertThat(option, is(ShowAllBookOption.class));
    }

    @Test
    public void should_create_reserve_a_book_option_when_given_menu_option() {
        Option option = OptionFactory.generateOption(MenuOption.RESERVE_A_BOOK);
        assertThat(option, is(ReserveABookOption.class));
    }

    @Test
    public void should_create_check_library_number_option_when_given_menu_option() {
        Option option = OptionFactory.generateOption(MenuOption.CHECK_LIBRARY_NUMBER);
        assertThat(option, is(CheckLibraryNumberOption.class));
    }
}
