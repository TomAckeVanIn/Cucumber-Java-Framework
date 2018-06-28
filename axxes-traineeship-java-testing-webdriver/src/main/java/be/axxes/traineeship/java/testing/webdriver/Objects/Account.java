package be.axxes.traineeship.java.testing.webdriver.Objects;

import java.util.List;

public class Account {

    private static String accountName;
    private static String accountLogin;
    private static String accountPassword;

    public Account(String accountName, String accountLogin, String accountPasswword) {
        this.accountName = accountName;
        this.accountLogin = accountLogin;
        this.accountPassword = accountPasswword;
    }


    //getters
    public static String getAccountName() {
        return accountName;
    }

    public static String getAccountLogin() {
        return accountLogin;
    }

    public static String getAccountPassword() {
        return accountPassword;
    }


    //setters
    public static void setAccountName(String newAccountName) {
        accountName = newAccountName;
    }

    public static void setAccountLogin(String newAccountLogin) {
        accountLogin = newAccountLogin;
    }

    public static void sesetAccountPassword(String newAccountPassword) {
        accountPassword = newAccountPassword;
    }

}
