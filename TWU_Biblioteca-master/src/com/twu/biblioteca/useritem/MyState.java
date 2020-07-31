package com.twu.biblioteca.useritem;

public class MyState {
    private boolean isUser;
    private User userAccount;

    public void setIsUser(boolean isUser, User... user) {
        this.isUser = isUser;

        if(isUser) {
            // only one user at most
            userAccount = user[0];
        } else {
            userAccount = null;
        }
    }

    public User getUserAccount() {
        if(isUser) {
            return userAccount;
        }
        // 应当给予提示信息或异常
        return null;
    }

    public boolean judgeIsUserOrNot() {
        return isUser;
    }
}
