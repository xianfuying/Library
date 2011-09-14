package com.twu;

import java.util.ArrayList;
import java.util.List;

public class UserStack {
    public static List<User> users;

    public static void initUserStack() {
        users = new ArrayList<User>();
        users.add(new User("111-1111", "123"));
        users.add(new User("111-1112", "eie"));
        users.add(new User("111-1113", "tet"));
        users.add(new User("111-1114", "ara"));
    }

    public static String getUserPassword(String userLibraryNumber) {
        for (User user : users) {
            if (user.libraryNumber.equals(userLibraryNumber)) {
                return user.password;
            }
        }
        return null;
    }
}
