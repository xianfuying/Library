package com.twu;

import com.twu.MenuOption;
import com.twu.ReserveABookOption;
import com.twu.ShowAllBooksOption;
import com.twu.ShowAllMoviesOption;

public class OptionFactory {
    public static Option generateOption(MenuOption selectedOption) {
        switch (selectedOption){
            case SHOW_ALL_BOOKS:
                return new ShowAllBooksOption();
            case RESERVE_A_BOOK:
                return new ReserveABookOption();
            case CHECK_LIBRARY_NUMBER:
                return new CheckLibraryNumberOption();
            case SHOW_ALL_MOVIES:
                return new ShowAllMoviesOption();
            case LOG_IN:
                return new LoginOption();
            default:
                return null;
        }
    }
}
