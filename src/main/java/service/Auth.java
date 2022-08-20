package service;

import model.User;
import utils.UsersUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Auth {
    private UsersUtils usersUtils;

    public Auth(UsersUtils usersUtils) {
        this.usersUtils = usersUtils;
    }

    public void printAuthMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Login: ");
            System.out.println("2.Register: ");
            System.out.println("3.Exit: ");
            System.out.println("Enter Your Choice: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Name: ");
                String name = scanner.next();
                System.out.println("Password: ");
                int password = scanner.nextInt();
                ArrayList<User> users = usersUtils.getUsers();
                boolean isUserExit = users.stream().anyMatch(user -> user.getName().equals(name));

                if (isUserExit) {
                    User loggedInUser = users.stream().filter(user -> (user.getName().equals(name)) && (user.getPassword() == password)).findFirst().get();
                    usersUtils.setLoggedInUser(loggedInUser);
                    System.out.println("Login Successful");
                    break;
                } else {
                    System.out.println("User does not Exist");
                }
            } else if (choice == 2) {
                System.out.println("Name:");
                String name = scanner.next();
                System.out.println("Password:");
                int password = scanner.nextInt();
                System.out.println("Age: ");
                int age = scanner.nextInt();
                System.out.println("Height: ");
                int height = scanner.nextInt();
                System.out.println("Weight: ");
                int weight = scanner.nextInt();
                ArrayList<User> users = usersUtils.getUsers();
                boolean isUserExit = users.stream().anyMatch(user -> user.getName().equals(name));

                if (isUserExit) {
                    System.out.println("User Already Exists");
                } else {
                    User user = new User();
                    user.setId(users.size() + 1);
                    user.setName(name);
                    user.setPassword(password);
                    user.setHeight(height);
                    user.setWeight(weight);
                    user.setAge(age);
                    users.add(user);
                    System.out.println("Registration Successful");
                }

            } else if (choice == 3) {
                System.out.println("Exit");
            } else {
                System.out.println("INVALID USER!!!!!");
            }
        }
    }
}