import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public static final int INVALID_INPUT = 0;

    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            return INVALID_INPUT;
        }
    }

    public void show(String information) {
        System.out.println(information);
    }
}
