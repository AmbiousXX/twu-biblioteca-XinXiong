package com.twu.biblioteca;

import com.twu.biblioteca.bookitem.*;
import com.twu.biblioteca.movieitem.*;
import com.twu.biblioteca.useritem.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Option {
    private boolean isQuit;

    public void initializeAndViewOptionMenuBeforeLogIn() {
        List<String> options = new ArrayList<String>();
        options.add("List of Books");
        options.add("List of Movies");
        options.add("Check out Movie");
        options.add("Log in");
        options.add("Quit");
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void initializeAndViewOptionMenuAfterLogIn() {
        List<String> options = new ArrayList<String>();
        options.add("List of Books");
        options.add("Check out Book");
        options.add("Return Book");
        options.add("My Checkout Books");
        options.add("My Information");
        options.add("Log out");
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void dealWithInputOptionBeforeLogIn(Scanner scanner, MyState myState, BookManagement bookManagement,
                                    MovieManagement movieManagement, UserManagement userManagement) {
        MessageInformation messageInformation = MessageInformation.getMessageInformation();
        List<Book> books = bookManagement.initializeBookList();
        List<Movie> movies = movieManagement.initializeMovieList();
        Hashtable<String, User> users = userManagement.initializeUserList();

        do {
            // get an input from console
            String inputOption = scanner.nextLine();
            
            switch (inputOption) {
                case "list of books":
                    bookManagement.viewBookList(books);
                    break;
                case "list of movies":
                    movieManagement.viewMovieList(movies);
                    break;
                case "check out movie":
                    MessageInformation.getMessageInformation().showHintBeforeChooseElement();
                    String checkoutMovieNumberStr = scanner.nextLine();
                    movieManagement.checkoutMovie(movies, Integer.parseInt(checkoutMovieNumberStr));
                    break;
                case "log in":
                    MessageInformation.getMessageInformation().showHintBeforeInputAccountNumberAndPassword();
                    String inputAccountNumberAndPassword = scanner.nextLine();
                    // split input account number and password by a space
                    String[] inputAccountInfo = inputAccountNumberAndPassword.split(" ");
                    userManagement.logIn(users, myState,inputAccountInfo[0], inputAccountInfo[1]);
                    if(myState.getIsUser()) {
                        initializeAndViewOptionMenuAfterLogIn();
                        MessageInformation.getMessageInformation().showHintBeforeChooseOption();
                        dealWithInputOptionAfterLogIn(scanner, myState, books, bookManagement, userManagement);
                    }
                    break;
                case "quit":
                    isQuit = true;
                    break;
                default:
                    messageInformation.showInvalidOptionNotice();
                    break;
            }
        } while (!isQuit);
    }

    private void dealWithInputOptionAfterLogIn(Scanner scanner, MyState myState, List<Book> books,
                                               BookManagement bookManagement, UserManagement userManagement){
        boolean hasLoggedOut = false;

        do{
            // get an input from console
            String inputOption = scanner.nextLine();

            switch (inputOption) {
                case "list of books":
                    bookManagement.viewBookList(books);
                    break;
                case "check out book":
                    MessageInformation.getMessageInformation().showHintBeforeChooseElement();
                    String checkoutBookNumberStr = scanner.nextLine();
                    bookManagement.checkoutBook(books, Integer.parseInt(checkoutBookNumberStr));
                    userManagement.userRegisterCheckoutBook(myState, books, Integer.parseInt(checkoutBookNumberStr));
                    break;
                case "return book":
                    MessageInformation.getMessageInformation().showHintBeforeChooseElement();
                    String returnBookNumberStr = scanner.nextLine();
                    userManagement.userRegisterReturnBook(myState, Integer.parseInt(returnBookNumberStr));
                    bookManagement.returnBook(books, Integer.parseInt(returnBookNumberStr));
                    break;
                case "my checkout books":
                    userManagement.viewCheckoutBookList(myState);
                    break;
                case "my information":
                    userManagement.showMyInformation(myState);
                    break;
                case "log out":
                    userManagement.logOut(myState);
                    hasLoggedOut = true;
                    initializeAndViewOptionMenuBeforeLogIn();
                    MessageInformation.getMessageInformation().showHintBeforeChooseOption();
                    break;
                default:
                    MessageInformation.getMessageInformation().showInvalidOptionNotice();
                    break;
            }
        } while(!hasLoggedOut);
    }
}
