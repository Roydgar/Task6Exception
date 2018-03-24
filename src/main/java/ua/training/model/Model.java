package ua.training.model;

import ua.training.NotUniqueLoginException;
import ua.training.entity.User;

import java.util.*;

import static ua.training.constants.MessagesConstants.INPUT_LOGIN_EXISTS;
import static ua.training.constants.MessagesConstants.MESSAGES_BUNDLE_NAME;

public class Model {
    private List<User> users = new ArrayList<>();
    private static ResourceBundle bundle = ResourceBundle.getBundle(
            MESSAGES_BUNDLE_NAME,
            Locale.getDefault()
    );

    public Model() {
        users.add(new User(DBRecords.FIRST.getLogin(), DBRecords.FIRST.getPassword()));
        users.add(new User(DBRecords.SECOND.getLogin(), DBRecords.SECOND.getPassword()));
    }

    public List<User> getUsers() { return users; }

    public void addUser(User newUser) throws NotUniqueLoginException{
        for (User user : users) {
            if (user.getLogin().equals(newUser.getLogin())) {
                throw new NotUniqueLoginException(bundle.getString(INPUT_LOGIN_EXISTS));
            }
        }
        users.add(newUser);
    }

    @Override
    public String toString() {
        return users.toString();
    }
}
