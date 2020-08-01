package com.twu.biblioteca.useritem;

import com.twu.biblioteca.bookitem.Book;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class User {
    private String accountNumber;
    private int password;       /* hash code for safety */
    private Hashtable<Integer, Book> checkoutBookList;

    public User(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password.hashCode();
        this.checkoutBookList = new Hashtable<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Hashtable<Integer, Book> getUserCheckoutBookList() {
        return checkoutBookList;
    }

    public void addNewElementToCheckoutBookList(Book checkoutBook, int bookNumber) {
        checkoutBookList.put(Integer.valueOf(bookNumber), checkoutBook);
    }

    public void removeReturnBookFromCheckoutBookList(int bookNumber) {
        checkoutBookList.remove(Integer.valueOf(bookNumber));
    }

    public boolean matchesAccountNumberAndPassword(String inputAccountNumber, String inputPassword) {
        return (inputAccountNumber.equals(this.accountNumber)) &&
                (inputPassword.hashCode() == this.password);
    }
}
