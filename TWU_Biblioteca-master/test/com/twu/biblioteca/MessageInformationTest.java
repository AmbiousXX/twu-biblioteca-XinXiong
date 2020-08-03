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

        messageInformation.showCheckoutBookSuccessfully();

        assertEquals(checkoutBookSuccessfully + "\r" + "\n", buffer.toString());
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
    public void testCheckoutMovieSuccessfully() {
        String checkoutBookSuccessfully = "Thank you! Enjoy the movie";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        messageInformation.showCheckoutMovieSuccessfully();

        assertEquals(checkoutBookSuccessfully + "\r" + "\n", buffer.toString());
    }

    @Test
    public void testHintBeforeInputAccountNumberAndPassword() {
        String hintBeforeInputAccountNumberAndPassword =
                "Please input your account number and password(Format:xxx-xxxx password):";
        String input = "log in";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        switch (input) {
            case "log in":
                messageInformation.showHintBeforeInputAccountNumberAndPassword();
                break;
            default:
                break;
        }

        assertEquals(hintBeforeInputAccountNumberAndPassword + "\r" + "\n", buffer.toString());
    }

    @Test
    public void testHintBeforeChooseElement() {
        String hintBeforeChooseElement = "Please input the number:";
        String input = "check out movie";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(buffer);
        System.setOut(output);

        switch (input) {
            case "check out movie":
                messageInformation.showHintBeforeChooseElement();
                break;
            default:
                break;
        }

        assertEquals(hintBeforeChooseElement + "\r" + "\n", buffer.toString());
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

