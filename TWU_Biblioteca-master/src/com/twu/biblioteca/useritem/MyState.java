package com.twu.biblioteca.useritem;

public class MyState {
    private boolean isUser;
    private User userAccount;

    public void setIsUser(boolean isUser, User... user) {
        this.isUser = isUser;

        if (isUser) {
            userAccount = user[0];
        } else {
            userAccount = null;
        }
    }

    public User getUserAccount() {
        return userAccount;
    }

    public boolean getIsUser() {
        return isUser;
    }
}
