import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    public void should_ask_biblioteca_to_show_connect_with_librarian_info(){
        checkLibraryNumberOption.execute(biblioteca);
        verify(console).show(CheckLibraryNumberOption.CONNECT_WITH_LIBRARIAN_INFO);
    }
}
