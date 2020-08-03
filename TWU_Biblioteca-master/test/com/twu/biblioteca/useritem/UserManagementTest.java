package com.twu.biblioteca.useritem;

import com.twu.biblioteca.bookitem.Book;
import com.twu.biblioteca.bookitem.BookManagement;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;

import static org.junit.Assert.*;

public class UserManagementTest {
    private UserManagement userManagement;
    private MyState myState;
    private Hashtable<String, User> users;
    private List<Book> books;

    @Before
    public void setUp() {
        this.userManagement = UserManagement.getUserManagement();
        this.myState = new MyState();
        this.users = userManagement.initializeUserList();
        this.books = BookManagement.getBookManagement().initializeBookList();
    }

    @Test
    public void testLogInSuccessfully() {
        assertEquals(false, myState.getIsUser());
        userManagement.logIn(users, myState, "lxm-0376", "!ad7dl23");
        assertEquals(true, myState.getIsUser());
        assertEquals("lxm-0376", myState.getUserAccount().getAccountNumber());
    }

    @Test
    public void testLoginUnsuccessfullyForWrongPassword() {
        String inputWrongPasswordWhenLogIn = "Incorrect password. Please log in again";

        assertEquals(false, myState.getIsUser());
        String wrongPassword = "mmm";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        userManagement.logIn(users, myState, "lxm-0376", wrongPassword);

        assertEquals(inputWrongPasswordWhenLogIn + "\r" + "\n", buffer.toString());
        assertEquals(false, myState.getIsUser());
    }

    @Test
    public void testLoginUnsuccessfullyForNonexistentAccount() {
        String tryToLogInNonexistentAccount = "Non-existent account";

        assertEquals(false, myState.getIsUser());
        String wrongAccountNumber = "nnn";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        userManagement.logIn(users, myState, wrongAccountNumber, "!ad7dl23");

        assertEquals(tryToLogInNonexistentAccount + "\r" + "\n", buffer.toString());
        assertEquals(false, myState.getIsUser());
    }

    @Test
    public void logOut() {
        assertEquals(false, myState.getIsUser());
        userManagement.logIn(users, myState, "lxm-0376", "!ad7dl23");
        assertEquals(true, myState.getIsUser());
        userManagement.logOut(myState);
        assertEquals(false, myState.getIsUser());
    }

    @Test
    public void userRegisterCheckoutBook() {
        String checkoutBookSuccessfully = "Thank you! Enjoy the book";
        userManagement.logIn(users, myState, "lxm-0376", "!ad7dl23");

        assertEquals(true, myState.getUserAccount().getUserCheckoutBookList().isEmpty());

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        userManagement.userRegisterCheckoutBook(myState, books, 1);

        assertEquals(checkoutBookSuccessfully + "\r" + "\n", buffer.toString());
        assertEquals(false, myState.getUserAccount().getUserCheckoutBookList().isEmpty());
        assertEquals(true, myState.getUserAccount().getUserCheckoutBookList().containsKey(1));
    }

    @Test
    public void userRegisterReturnBook() {
        userManagement.logIn(users, myState, "lxm-0376", "!ad7dl23");

        assertEquals(true, myState.getUserAccount().getUserCheckoutBookList().isEmpty());
        userManagement.userRegisterCheckoutBook(myState, books, 1);
        assertEquals(false, myState.getUserAccount().getUserCheckoutBookList().isEmpty());
        assertEquals(true, myState.getUserAccount().getUserCheckoutBookList().containsKey(1));
        userManagement.userRegisterReturnBook(myState, 1);
        assertEquals(true, myState.getUserAccount().getUserCheckoutBookList().isEmpty());
        assertEquals(false, myState.getUserAccount().getUserCheckoutBookList().containsKey(1));
    }

    @Test
    public void viewCheckoutBookListUnsuccessfully() {
        String checkoutBookListIsEmpty = "You have not checked out any book";
        userManagement.logIn(users, myState, "lxm-0376", "!ad7dl23");

        assertEquals(true, myState.getUserAccount().getUserCheckoutBookList().isEmpty());

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        userManagement.viewCheckoutBookList(myState);
        assertEquals(checkoutBookListIsEmpty + "\r" + "\n", buffer.toString());
    }
}