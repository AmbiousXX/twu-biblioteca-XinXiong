package com.twu.biblioteca.useritem;

import com.twu.biblioteca.bookitem.Book;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    public void userRegisterCheckoutBook(MyState myState, List<Book> books, int checkoutBookNumber) {
        Book checkoutBook = books.get(checkoutBookNumber - 1);
        myState.getUserAccount().addNewElementToCheckoutBookList(checkoutBook, checkoutBookNumber);
    }

    public void userRegisterReturnBook(MyState myState, int returnBookNumber) {
        myState.getUserAccount().removeReturnBookFromCheckoutBookList(returnBookNumber);
    }

    // 未来打印book信息的部分应可以与BookManagement内相同部分复用（？）
    public void viewCheckoutBookList(MyState myState) {
        Hashtable<Integer, Book> checkoutBookList = myState.getUserAccount().getUserCheckoutBookList();
        if(checkoutBookList.isEmpty()) {
            // 异常信息
        }

        Iterator iter = checkoutBookList.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            Integer bookNumber = (Integer)entry.getKey();
            Book book = (Book)entry.getValue();
            System.out.println(bookNumber.intValue() + " | " + book.getName() + " | "
                    + book.getAuthor() + " | " + book.getPublicationYear());
        }
    }

    public void viewMyInformation(){

    }
}
