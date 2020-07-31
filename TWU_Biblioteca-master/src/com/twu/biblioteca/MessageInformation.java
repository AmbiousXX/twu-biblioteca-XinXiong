package com.twu.biblioteca;

public class MessageInformation {
    private final String welcomeMessage = "Welcome to Bibloteca. Your one-step-shop for great book titles in Bangalore!";
    private final String invalidOptionNotice = "Please select a valid option!";
    private final String checkoutBookSuccessfully = "Thank you! Enjoy the book";
    private final String checkoutBookUnsuccessfully = "Sorry, that book is not available";
    private final String returnBookSuccessfully = "Thank you for returning the book";
    private final String returnBookUnsuccessfully = "That is not a valid book to return.";

    public void showWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public void showInvalidOptionNotice() {
        System.out.println(invalidOptionNotice);
    }

    public void showCheckoutBookSuccessfully() {
        System.out.println(checkoutBookSuccessfully);
    }

    public void showCheckoutBookUnsuccessfully() {
        System.out.println(checkoutBookUnsuccessfully);
    }

    public void showReturnBookSuccessfully() {
        System.out.println(returnBookSuccessfully);
    }

    public void showReturnBookUnsuccessfully() {
        System.out.println(returnBookUnsuccessfully);
    }
}
