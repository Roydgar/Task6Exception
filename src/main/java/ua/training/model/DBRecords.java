package ua.training.model;


public enum DBRecords {
    FIRST("Vova228", "123123313"),
    SECOND("Vitia228", "13151512");

    private final String login;
    private final String password;

    DBRecords(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
