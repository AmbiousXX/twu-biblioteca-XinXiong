package com.twu.biblioteca.bookitem;

import com.twu.biblioteca.MessageInformationTest;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class BookManagementTest {
    private BookManagement bookManagement;
    private List<Book> books;

    @Before
    public void setUp() {
        this.bookManagement = BookManagement.getBookManagement();
    }

    @Test
    public void initializeBookList() {
        this.books = bookManagement.initializeBookList();
        Book theFourthBook = books.get(4);
        assertEquals(theFourthBook.getName(), "The Little Prince");
        assertEquals(theFourthBook.getAuthor(), "Antoine de Saint-Exupéry");
        assertEquals(theFourthBook.getPublicationYear(), 1942);
        assertEquals(theFourthBook.getIsChecked(), false);
    }

    @Test
    public void checkoutBookSuccessfully() {
        this.books = bookManagement.initializeBookList();
        assertEquals(false, books.get(2).getIsChecked());
        bookManagement.checkoutBook(books, 3);
        assertEquals(true, books.get(2).getIsChecked());
    }

    @Test
    public void testCheckoutBookUnsuccessfullyForRepeatedSelection() {
        this.books = bookManagement.initializeBookList();
        String checkoutBookUnsuccessfully = "Sorry, that book is not available";

        bookManagement.checkoutBook(books, 3);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        bookManagement.checkoutBook(books, 3);

        assertEquals(checkoutBookUnsuccessfully + "\r" + "\n", buffer.toString());
    }

    @Test
    public void testCheckoutBookUnsuccessfullyForExceedBookListSize() {
        this.books = bookManagement.initializeBookList();
        String checkoutBookUnsuccessfully = "Sorry, that book is not available";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        bookManagement.checkoutBook(books, 10);

        assertEquals(checkoutBookUnsuccessfully + "\r" + "\n", buffer.toString());
    }

    @Test
    public void returnBookSuccessfully() {
        this.books = bookManagement.initializeBookList();
        assertEquals(false, books.get(2).getIsChecked());
        bookManagement.checkoutBook(books, 3);
        assertEquals(true, books.get(2).getIsChecked());
        bookManagement.returnBook(books, 3);
        assertEquals(false, books.get(2).getIsChecked());
    }

    @Test
    public void testReturnBookUnsuccessfullyForIncorrectBook() {
        this.books = bookManagement.initializeBookList();
        String returnBookUnsuccessfully = "That is not a valid book to return.";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        bookManagement.returnBook(books, 3);

        assertEquals(returnBookUnsuccessfully + "\r" + "\n", buffer.toString());
    }

    @Test
    public void testReturnBookUnsuccessfullyForExceedBookListSize() {
        this.books = bookManagement.initializeBookList();
        String returnBookUnsuccessfully = "That is not a valid book to return.";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        bookManagement.returnBook(books, 10);

        assertEquals(returnBookUnsuccessfully + "\r" + "\n", buffer.toString());
    }
}