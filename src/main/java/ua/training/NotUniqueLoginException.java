package ua.training;

public class NotUniqueLoginException extends Exception{
    public NotUniqueLoginException(String message) {
        super(message);
    }
}

