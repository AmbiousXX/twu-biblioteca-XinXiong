package com.twu.biblioteca;

import com.twu.biblioteca.bookitem.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MessageInformationTest {
    MessageInformation messageInformation = MessageInformation.getMessageInformation();
    BookManagement bookManagement = BookManagement.getBookManagement();

    List<Book> books = bookManagement.initializeBookList();

    @Test
    public void testWelcomeMessage() {
        String welcomeMessage = "Welcome to Bibloteca. Your one-step-shop for great book titles in Bangalore!";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        messageInformation.showWelcomeMessage();

        // add  + "\r" + "\n" for CRLF format
        // the same below
        assertEquals(welcomeMessage + "\r" + "\n", buffer.toString());
    }

    @Test
    public void testCheckoutBookSuccessfully() {
        String checkoutBookSuccessfully = "Thank you! Enjoy the book";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        bookManagement.checkoutBook(books, 3);

        assertEquals(checkoutBookSuccessfully + "\r" + "\n", buffer.toString());
    }

    @Test
    public void testCheckoutBookUnsuccessfully() {
        String checkoutBookUnsuccessfully = "Sorry, that book is not available";

        bookManagement.checkoutBook(books, 3);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        bookManagement.checkoutBook(books, 3);

        assertEquals(checkoutBookUnsuccessfully + "\r" + "\n", buffer.toString());
    }

    @Test
    public void testReturnBookSuccessfully() {
        String returnBookSuccessfully = "Thank you for returning the book";

        bookManagement.checkoutBook(books, 3);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        bookManagement.returnBook(books, 3);

        assertEquals(returnBookSuccessfully + "\r" + "\n", buffer.toString());
    }

    @Test
    public void testReturnBookUnsuccessfully() {
        String returnBookUnsuccessfully = "That is not a valid book to return.";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        bookManagement.returnBook(books, 3);

        assertEquals(returnBookUnsuccessfully + "\r" + "\n", buffer.toString());
    }

    @Test
    public void testInvalidOptionNotice() {
        String invalidOptionNotice = "Please select a valid option!";
        String invalidInputOption = "remove book";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        switch (invalidInputOption) {
            case "validInputOption":
                break;
            default:
                messageInformation.showInvalidOptionNotice();
                break;
        }

        assertEquals(invalidOptionNotice + "\r" + "\n", buffer.toString());
    }
}

