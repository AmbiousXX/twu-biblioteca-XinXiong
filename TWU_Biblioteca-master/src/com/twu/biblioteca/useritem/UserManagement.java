package com.twu.biblioteca.useritem;

import com.twu.biblioteca.MessageInformation;
import com.twu.biblioteca.bookitem.Book;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserManagement {
    private UserManagement() {}
    private static UserManagement userManagement = new UserManagement();
    public static UserManagement getUserManagement() {
        return userManagement;
    }

    public Hashtable<String, User> initializeUserList() {
        Hashtable<String, User> users = new Hashtable();
        users.put("lxm-0376", new User("lxm-0376", "!ad7dl23", "lxm", "lxm0376@xyy.com", "18743304207"));
        users.put("0wm-9232", new User("0wm-9232", "kdf1h04h@@ksw", "wm", "wm9232@xyy.com", "14489649277"));
        users.put("nny-8855", new User("nny-8855", "67yd7tDJK0", "nny", "mmy8855@163.com", "18824569636"));

        return users;
    }

    public void logIn(Hashtable<String, User> users, MyState myState, String accountNumber, String password) {
        if(users.containsKey(accountNumber)) {
            if(users.get(accountNumber).matchesAccountNumberAndPassword(accountNumber, password)) {
                // log in successfully
                myState.setIsUser(true, users.get(accountNumber));
            } else {
                MessageInformation.getMessageInformation().showInputWrongPasswordWhenLogIn();
            }
        } else {
            MessageInformation.getMessageInformation().showTryToLogInNonexistentAccount();
        }
    }

    public void logOut(MyState myState) {
        myState.setIsUser(false);
    }

    public void userRegisterCheckoutBook(MyState myState, List<Book> books, int checkoutBookNumber) {
        Book checkoutBook = books.get(checkoutBookNumber - 1);
        myState.getUserAccount().addNewElementToCheckoutBookList(checkoutBook, checkoutBookNumber);
        MessageInformation.getMessageInformation().showCheckoutBookSuccessfully();
    }

    public void userRegisterReturnBook(MyState myState, int returnBookNumber) {
        myState.getUserAccount().removeReturnBookFromCheckoutBookList(returnBookNumber);
    }

     public void viewCheckoutBookList(MyState myState) {
        Hashtable<Integer, Book> checkoutBookList = myState.getUserAccount().getUserCheckoutBookList();
        if(checkoutBookList.isEmpty()) {
            MessageInformation.getMessageInformation().showCheckoutBookListIsEmpty();
            return;
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

    public void showMyInformation(MyState myState){
        User myAccount = myState.getUserAccount();
        System.out.println(myAccount.getAccountNumber() + " | " + myAccount.getName() + " | " +
                myAccount.getEmail() + " | " + myAccount.getPhoneNumber());
    }
}
