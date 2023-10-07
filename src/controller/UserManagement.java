package controller;

import common.Library;
import model.User;
import model.UserSystem;
import view.Menu;

public class UserManagement extends Menu<String> {

    static String[] menu = {"Creat new account", "Login system"};
    private UserSystem us = new UserSystem();
    private Library lib = new Library();

    public UserManagement() {
        super("==== User Management System ====", menu, "Exit");
        us.readFile("user.dat");
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                us.addAccount(enterAccount(1));
                us.saveFile("user.dat.txt");
                break;
            case 2:
                User a = enterAccount(2);
                if (us.login(a)) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("User name or password is incorrect");
                }
                break;
            default:
                return;
        }
    }

    private User enterAccount(int t) {
        while (true) {
            String name = lib.getAccount("Enter User Name", 1, t, us.list);
            String pass = lib.getAccount("Enter Password", 2, t, us.list);
            if (us.list.size() == 0) {
                return new User(name, pass);
            }

            return new User(name, pass);
        }
    }
}
