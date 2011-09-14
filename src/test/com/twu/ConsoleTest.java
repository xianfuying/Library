package com.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConsoleTest {

    private ByteArrayOutputStream bos;
    private Console console;
    private ByteArrayInputStream bis;

    @Before
    public void setUp() {
        console = new Console();
        bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos);
        System.setOut(printStream);
    }

    @Test
    public void should_get_user_input_string_from_console(){
        simulateUserInputFromConsole("userInput\n");
        assertThat(console.getUserInput(), is("userInput"));
    }

    private void simulateUserInputFromConsole(String input) {
        bis = new ByteArrayInputStream(input.getBytes());
        System.setIn(bis);
    }

    @Test
    public void should_information_from_biblioteca() {
        console.show("message");
        assertThat(bos.toString(), is("message\n"));
    }
}
