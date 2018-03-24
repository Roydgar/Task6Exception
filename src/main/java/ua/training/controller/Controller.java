package ua.training.controller;


import ua.training.NotUniqueLoginException;
import ua.training.entity.User;
import ua.training.model.Model;
import ua.training.view.View;

import java.util.ResourceBundle;
import java.util.Scanner;

import static ua.training.constants.MessagesConstants.INPUT_LOGIN;
import static ua.training.constants.MessagesConstants.INPUT_PASSWORD;
import static ua.training.constants.RegexConstants.*;


public class Controller {
    private ResourceBundle regexBundle = ResourceBundle.getBundle(REGEX_BUNDLE_NAME);

    private Scanner inputScanner = new Scanner(System.in);
    private View view;
    private Model model;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        String login    = getUserInput(regexBundle.getString(REGEX_LOGIN), INPUT_LOGIN);
        String password = getUserInput(regexBundle.getString(REGEX_PASSWORD), INPUT_PASSWORD);
        while(true) {
            try {
                model.addUser(new User(login, password));
                break;
            } catch (NotUniqueLoginException e) {
                view.printLoginExistsMessage();
                login    = getUserInput(regexBundle.getString(REGEX_LOGIN), INPUT_LOGIN);
            }
        }
    }

    private String getUserInput(String regex, String messagePropertyKey) {
        String input;
        view.printInputOffering(messagePropertyKey);
        while (!(inputScanner.hasNext() && (input = inputScanner.nextLine().trim()).matches(regex))) {
            view.printWrongInputMessage();
        }
        return input;
    }

}
