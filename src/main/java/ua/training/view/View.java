package ua.training.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static ua.training.constants.MessagesConstants.*;

public class View {
    private static ResourceBundle bundle = ResourceBundle.getBundle(
            MESSAGES_BUNDLE_NAME,
            Locale.getDefault()
    );

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printInputOffering(String propertyKey) { printMessage(bundle.getString(propertyKey)); }

    public void printWrongInputMessage() { printMessage(bundle.getString(WRONG_INPUT)); }

    public void printLoginExistsMessage() { printMessage(bundle.getString(INPUT_LOGIN_EXISTS));}
}
