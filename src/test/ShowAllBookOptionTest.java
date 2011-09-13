import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ShowAllBookOptionTest {
    @Mock
    private Console console;
    private Biblioteca biblioteca;
    private ShowAllBookOption showAllBookOption;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        biblioteca = new Biblioteca(console);
        showAllBookOption = new ShowAllBookOption();
    }

    @Test
    public void should_ask_console_show_book_information_when_user_select_to_show_all_books() {
        showAllBookOption.execute(biblioteca);
        verify(console).show("1. Agile China\n2. XP");
    }
}
