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
    private List<String> optionMenuBeforeLogIn;
    private List<String> optionMenuAfterLogIn;

    private Option() {
        this.optionMenuBeforeLogIn = new ArrayList<String>();
        optionMenuBeforeLogIn.add("List of Books");
        optionMenuBeforeLogIn.add("List of Movies");
        optionMenuBeforeLogIn.add("Check out Movie");
        optionMenuBeforeLogIn.add("Log in");
        optionMenuBeforeLogIn.add("Quit");

        this.optionMenuAfterLogIn = new ArrayList<String>();
        optionMenuAfterLogIn.add("List of Books");
        optionMenuAfterLogIn.add("Check out Book");
        optionMenuAfterLogIn.add("Return Book");
        optionMenuAfterLogIn.add("My Checkout Books");
        optionMenuAfterLogIn.add("My Information");
        optionMenuAfterLogIn.add("Log out");
    }
    private static Option option = new Option();
    public static Option getOption() {
        return option;
    }

    public void viewOptionMenuBeforeLogIn() {
        for (String option : optionMenuBeforeLogIn) {
            System.out.println(option);
        }
    }

    public void viewOptionMenuAfterLogIn() {
        for (String option : optionMenuAfterLogIn) {
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
                    String[] inputAccountInfo = inputAccountNumberAndPassword.split(" ");
                    userManagement.logIn(users, myState,inputAccountInfo[0], inputAccountInfo[1]);
                    if(myState.getIsUser()) {
                        viewOptionMenuAfterLogIn();
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
            String inputOption = scanner.nextLine();

            switch (inputOption) {
                case "list of books":
                    bookManagement.viewBookList(books);
                    break;
                case "check out book":
                    MessageInformation.getMessageInformation().showHintBeforeChooseElement();
                    String checkoutBookNumberStr = scanner.nextLine();
                    boolean ok = bookManagement.checkoutBook(books, Integer.parseInt(checkoutBookNumberStr));
                    if(ok) {
                        userManagement.userRegisterCheckoutBook(myState, books, Integer.parseInt(checkoutBookNumberStr));
                    }
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
                    viewOptionMenuBeforeLogIn();
                    MessageInformation.getMessageInformation().showHintBeforeChooseOption();
                    break;
                default:
                    MessageInformation.getMessageInformation().showInvalidOptionNotice();
                    break;
            }
        } while(!hasLoggedOut);
    }
}
