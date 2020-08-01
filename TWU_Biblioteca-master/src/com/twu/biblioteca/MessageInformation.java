package com.twu.biblioteca;

public class MessageInformation {
    private final String welcomeMessage = "Welcome to Bibloteca. Your one-step-shop for great book titles in Bangalore!";
    private final String invalidOptionNotice = "Please select a valid option!";
    private final String checkoutBookSuccessfully = "Thank you! Enjoy the book";
    private final String checkoutBookUnsuccessfully = "Sorry, that book is not available";
    private final String returnBookSuccessfully = "Thank you for returning the book";
    private final String returnBookUnsuccessfully = "That is not a valid book to return.";

    public void showWelcomeMessage() {
        printMessageToConsole(welcomeMessage);
    }

    public void showInvalidOptionNotice() {
        printMessageToConsole(invalidOptionNotice);
    }

    public void showCheckoutBookSuccessfully() {
        printMessageToConsole(checkoutBookSuccessfully);
    }

    public void showCheckoutBookUnsuccessfully() {
        printMessageToConsole(checkoutBookUnsuccessfully);
    }

    public void showReturnBookSuccessfully() {
        printMessageToConsole(returnBookSuccessfully);
    }

    public void showReturnBookUnsuccessfully() {
        printMessageToConsole(returnBookUnsuccessfully);
    }
    
    private void printMessageToConsole(String message) {
        System.out.println(message)
    }
}
