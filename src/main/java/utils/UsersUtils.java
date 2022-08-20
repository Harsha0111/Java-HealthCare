package utils;
import model.User;

import java.util.ArrayList;

public class UsersUtils {

    private User loggedInUser;
    private ArrayList<User> users = new ArrayList<User>();

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
