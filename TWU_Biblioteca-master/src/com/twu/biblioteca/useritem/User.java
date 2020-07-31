package com.twu.biblioteca.useritem;

public class User {
    private String accountNumber;
    private int password;       /* hash code for safety */

    public User(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password.hashCode();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getPassword() {
        return password;
    }

    public boolean matchesAccountNumberAndPassword(String inputAccountNumber, String inputPassword) {
        return (inputAccountNumber.equals(this.accountNumber)) &&
                (inputPassword.hashCode() == this.password);
    }
}
