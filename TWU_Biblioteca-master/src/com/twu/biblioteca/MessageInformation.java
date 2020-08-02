package com.twu.biblioteca;

public class MessageInformation {
    private final String welcomeMessage = "Welcome to Bibloteca. Your one-step-shop for great book titles in Bangalore!";
    private final String invalidOptionNotice = "Please select a valid option!";
    private final String checkoutBookSuccessfully = "Thank you! Enjoy the book";
    private final String checkoutBookUnsuccessfully = "Sorry, that book is not available";
    private final String returnBookSuccessfully = "Thank you for returning the book";
    private final String returnBookUnsuccessfully = "That is not a valid book to return.";
    private final String checkoutMovieSuccessfully = "Thank you! Enjoy the movie";
    private final String inputWrongPasswordWhenLogIn = "Incorrect password. Please log in again";
    private final String tryToLogInNonexistentAccount = "Non-existent account";
    private final String checkoutBookListIsEmpty = "You have not checked out any book";
    private final String hintBeforeChooseOption = "Please input your option(Format:all lowercase letters):";
    private final String hintBeforeInputAccountNumberAndPassword =
            "Please input your account number and password(Format:xxx-xxxx password):";
    private final String hintBeforeChooseElement = "Please input the number:";

    private MessageInformation() {}
    private static MessageInformation messageInformation = new MessageInformation();
    public static MessageInformation getMessageInformation() {
        return messageInformation;
    }

    // welcome message
    public void showWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    // option message
    public void showInvalidOptionNotice() {
        System.out.println(invalidOptionNotice);
    }

    // book message
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

    // movie message
    public void showCheckoutMovieSuccessfully() {
        System.out.println(checkoutMovieSuccessfully);
    }

    // user message
    public void showInputWrongPasswordWhenLogIn() {
        System.out.println(inputWrongPasswordWhenLogIn);
    }

    public void showTryToLogInNonexistentAccount() {
        System.out.println(tryToLogInNonexistentAccount);
    }

    public void showCheckoutBookListIsEmpty() {
        System.out.println(checkoutBookListIsEmpty);
    }

    // type-ahead message
    public void showHintBeforeChooseOption() {
        System.out.println(hintBeforeChooseOption);
    }

    public void showHintBeforeInputAccountNumberAndPassword() {
        System.out.println(hintBeforeInputAccountNumberAndPassword);
    }

    public void showHintBeforeChooseElement() {
        System.out.println(hintBeforeChooseElement);
    }
}
