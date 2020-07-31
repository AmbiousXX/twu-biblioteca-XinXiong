package com.twu.biblioteca.useritem;

import java.util.Hashtable;

public class UserManagement {
//    //injection
//    MyState myState;
//
//    public UserManagement(MyState myState) {
//        this.myState = myState;
//    }

    public Hashtable<String, User> initializeUserList() {
        Hashtable<String, User> users = new Hashtable();
        users.put("lxm-0376", new User("lxm-0376", "!ad7dl23"));
        users.put("0wm-9232", new User("0wm-9232", "kdf1h04h@@ksw"));
        users.put("nny-8855", new User("nny-8855", "67yd7tDJK0"));

        return users;
    }

    public void logIn(Hashtable<String, User> users, MyState myState, String accountNumber, String password) {
        if(users.containsKey(accountNumber)) {
            if(users.get(accountNumber).matchesAccountNumberAndPassword(accountNumber, password)) {
                // 登录成功，思考如何判定
                myState.setIsUser(true, users.get(accountNumber));
                System.out.println("Congratulations! You log in!");
            } else {
                // 异常情况，错误的登录信息
            }
        } else {
            // 异常情况，不存在的账户
        }
    }

    // may not exist
    public void logOut(MyState myState) {
        myState.setIsUser(false);
    }

    public void userRegisterCheckoutBook() {

    }

    public void userRegisterReturnBook() {

    }

    public void viewMyInformation(){

    }
}
