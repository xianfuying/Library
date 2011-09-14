package com.twu;

import java.util.Scanner;

public class Console {

    public static final int INVALID_INPUT = 0;

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
            return scanner.nextLine().trim();
    }

    public void show(String information) {
        System.out.println(information);
    }
}
