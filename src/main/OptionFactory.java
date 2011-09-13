public class OptionFactory {
    public static Option generateOption(MenuOption selectedOption) {
        switch (selectedOption){
            case SHOW_ALL_BOOKS:
                return new ShowAllBookOption();
            case RESERVE_A_BOOK:
                return new ReserveABookOption();
            case CHECK_LIBRARY_NUMBER:
                return new CheckLibraryNumberOption();
            default:
                return null;
        }
    }
}
