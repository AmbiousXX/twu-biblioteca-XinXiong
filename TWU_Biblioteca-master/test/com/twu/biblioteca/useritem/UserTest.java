package com.twu.biblioteca.useritem;

import com.twu.biblioteca.bookitem.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @Before
    public void setUp() {
        this.user = new User("0wm-9232", "kdf1h04h@@ksw", "wm", "wm9232@xyy.com", "14489649277");
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals("0wm-9232", user.getAccountNumber());
    }

    @Test
    public void testGetName() {
        assertEquals("wm", user.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("wm9232@xyy.com", user.getEmail());
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("14489649277", user.getPhoneNumber());
    }

    @Test
    public void testAddNewElementToCheckoutBookList() {
        assertEquals(true, user.getUserCheckoutBookList().isEmpty());
        user.addNewElementToCheckoutBookList(new Book("The Decameron", "Giovanni Boccaccio", 1353), 4);
        assertEquals(true, user.getUserCheckoutBookList().containsKey(4));
        assertEquals("The Decameron", user.getUserCheckoutBookList().get(4).getName());
        assertEquals("Giovanni Boccaccio", user.getUserCheckoutBookList().get(4).getAuthor());
        assertEquals(1353, user.getUserCheckoutBookList().get(4).getPublicationYear());
    }

    @Test
    public void testRemoveReturnBookFromCheckoutBookList() {
        user.addNewElementToCheckoutBookList(new Book("The Decameron", "Giovanni Boccaccio", 1353), 4);
        assertEquals(true, user.getUserCheckoutBookList().containsKey(4));
        user.removeReturnBookFromCheckoutBookList(4);
        assertEquals(false, user.getUserCheckoutBookList().containsKey(4));
    }

    @Test
    public void testMatchesAccountNumberAndPasswordSuccessfully() {
        String correctAccountNumber = "0wm-9232";
        String correctPassword = "kdf1h04h@@ksw";
        assertEquals(true, user.matchesAccountNumberAndPassword(correctAccountNumber, correctPassword));
    }

    @Test
    public void testMatchesAccountNumberAndPasswordUnsuccessfully() {
        String wrongAccountNumber = "123";
        String inputPassword = "xxx";
        assertEquals(false, user.matchesAccountNumberAndPassword(wrongAccountNumber, inputPassword));

        String correctAcountNumber = "0wm-9232";
        String wrongPassword = "yyy";
        assertEquals(false, user.matchesAccountNumberAndPassword(correctAcountNumber, wrongPassword));
    }
}