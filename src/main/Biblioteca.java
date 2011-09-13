public class Biblioteca {
    public static final String ERROR_INFO_SELECT_A_VALID_OPTION = "Select a valid option!!";
    public static final String WELCOME_MESSAGE = "Welcome to Bangalore Public Library System";
    public static final String INPUT_CHOSEN_OPTION = "Input your choose:";
    protected Console console;
    protected BookStack bookStack;
    protected User user;

    public Biblioteca(Console console) {
        this.console = console;
        bookStack = new BookStack();
        bookStack.initBookStack();
        user = new User(1, "user1");
    }

    private void selectMenuOption() {
        int userInput = console.getUserInput();
        MenuOption selectOption = generateSelectedMenuOption(userInput);
        if (selectOption == null) {
            console.show(ERROR_INFO_SELECT_A_VALID_OPTION);
        } else {
            executeSelectOption(selectOption);
        }
    }

    private MenuOption generateSelectedMenuOption(int userInput) {
        if (isInvalidMenuOption(userInput)) {
            return null;
        }
        return MenuOption.getOption(userInput);
    }

    private boolean isInvalidMenuOption(int userInput) {
        return userInput == Console.INVALID_INPUT || MenuOption.getOption(userInput) == null;
    }

    private void executeSelectOption(MenuOption selectedOption) {
        Option option = OptionFactory.generateOption(selectedOption);
        option.execute(this);
    }

    public void start() {
        console.show(WELCOME_MESSAGE);
        console.show(MenuOption.getAllOptions());
        console.show(INPUT_CHOSEN_OPTION);
        selectMenuOption();
    }
}
