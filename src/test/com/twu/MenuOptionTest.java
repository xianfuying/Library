package com.twu;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class MenuOptionTest {
    @Test
    public void should_return_all_menu_option_in_string() {

        String allOptions = MenuOption.getAllOptions();

        assertThat(allOptions, containsString("Show All Books"));
        assertThat(allOptions, containsString("Reserve A com.twu.Book"));
        assertThat(allOptions, containsString("Check Library Number"));
        assertThat(allOptions, containsString("Show All Movies"));
        assertThat(allOptions, containsString("Log in"));
    }
}
