import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

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
    public void should_ask_biblioteca_show_input_selected_book_id() {
        reserveABookOption.execute(biblioteca);
        verify(console).show(ReserveABookOption.INPUT_THE_BOOK_NUMBER_YOU_WANT_TO_RESERVE);
    }

    @Test
    public void should_get_user_input_of_the_book_num() {
        reserveABookOption.execute(biblioteca);
        verify(console).getUserInput();
    }

    @Test
    public void should_ask_biblioteca_to_show_do_not_have_book_info() {
        when(console.getUserInput()).thenReturn(3);

        reserveABookOption.execute(biblioteca);
        verify(console).show(ReserveABookOption.DO_NOT_HAVE_BOOK_INFO);
    }

    @Test
    public void should_ask_biblioteca_to_show_reserve_success_info_if_the_book_exist() {
        when(console.getUserInput()).thenReturn(1);

        reserveABookOption.execute(biblioteca);

        verify(console).show(ReserveABookOption.RESERVE_BOOK_SUCCESS_INFO);
    }

    @Test
    public void should_ask_biblioteca_to_show_input_book_id() {
        when(console.getUserInput()).thenReturn(Console.INVALID_INPUT);

        reserveABookOption.execute(biblioteca);
        verify(console).show(ReserveABookOption.DO_NOT_HAVE_BOOK_INFO);
    }
}
