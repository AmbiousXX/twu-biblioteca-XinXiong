package com.twu.biblioteca;

import com.twu.biblioteca.bookitem.Book;
import com.twu.biblioteca.bookitem.BookManagement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class ExampleTest {

    MessageInformation messageInformation = new MessageInformation();
    BookManagement bookManagement = new BookManagement(messageInformation);

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void testWelcomeMessage() {
        messageInformation.showWelcomeMessage();
    }

    @Test
    public void testGetBookList() {
        messageInformation.showWelcomeMessage();
        List<Book> books = bookManagement.initializeBookList();
        bookManagement.viewBookList(books);
    }

    @Test
    public void testViewOptionMenu() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.viewOptionMenu();
    }

    @Test
    public void testCheckoutBookSuccessfully() {
        List<Book> books = bookManagement.initializeBookList();
        bookManagement.viewBookList(books);
        bookManagement.checkoutBook(books, 3);
        bookManagement.viewBookList(books);
    }

    @Test
    public void testCheckoutBookUnsuccessfully() {
        List<Book> books = bookManagement.initializeBookList();
        bookManagement.viewBookList(books);
        bookManagement.checkoutBook(books, 3);
        bookManagement.viewBookList(books);
        bookManagement.checkoutBook(books, 3);
    }

    @Test
    public void testReturnBookSuccessfully() {
        List<Book> books = bookManagement.initializeBookList();
        bookManagement.checkoutBook(books, 3);
        bookManagement.viewBookList(books);
        bookManagement.returnBook(books, 3);
        bookManagement.viewBookList(books);
    }

    @Test
    public void testReturnBookUnsuccessfully() {
        List<Book> books = bookManagement.initializeBookList();
        bookManagement.viewBookList(books);
        bookManagement.returnBook(books, 3);
    }
}
