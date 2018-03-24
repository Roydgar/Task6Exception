package ua.training.entity;

import java.util.Optional;

public class User {
    private Optional<String> login;
    private Optional<String> password;

    public User(String login, String password) {
        this.login = Optional.of(login.toLowerCase());
        this.password = Optional.of(password);
    }

    public void setLogin(Optional<String> login) {
        this.login = login;
    }

    public void setPassword(Optional<String> password) {
        this.password = password;
    }

    public Optional<String> getLogin() {
        return login;
    }

    public Optional<String> getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login=" + login +
                ", password=" + password +
                '}';
    }
}
