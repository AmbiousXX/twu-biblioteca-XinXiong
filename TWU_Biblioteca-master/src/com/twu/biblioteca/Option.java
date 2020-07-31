package com.twu.biblioteca;

import com.twu.biblioteca.bookitem.*;
import com.twu.biblioteca.movieitem.*;
import com.twu.biblioteca.useritem.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Option {
    boolean isQuit;

    public void initializeAndViewOptionMenu() {
        List<String> options = new ArrayList<String>();
        // TODO
        options.add("List of Books");
        options.add("Check out book");
        options.add("Return book");
        options.add("Quit");
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void dealWithInputOption(Scanner scanner, MyState myState, List<Book> books,
                                    List<Movie> movies, Hashtable<String, User> users) {
        MessageInformation messageInformation = new MessageInformation();
        BookManagement bookManagement = new BookManagement(messageInformation);
        MovieManagement movieManagement = new MovieManagement();
        UserManagement userManagement = new UserManagement();

        do {
            // get an input from console
            String inputOption = scanner.nextLine();

            // TODO:很多时候需要判断一下是否登录了
            switch (inputOption) {
                case "list of books":
                    bookManagement.viewBookList(books);
                    break;
                case "list of movies":
                    // TODO
                    // movieManagement.viewMovieList();
                    break;
                case "check out book":
                    String checkoutBookNumberStr = scanner.nextLine();
                    bookManagement.checkoutBook(books, Integer.parseInt(checkoutBookNumberStr));
                    userManagement.userRegisterCheckoutBook(myState, books, Integer.parseInt(checkoutBookNumberStr));
                    break;
                case "return book":
                    String returnBookNumberStr = scanner.nextLine();
                    userManagement.userRegisterReturnBook(myState, Integer.parseInt(returnBookNumberStr));
                    bookManagement.returnBook(books, Integer.parseInt(returnBookNumberStr));
                    break;
                case "check out movie":
                    String checkoutMovieNumberStr = scanner.nextLine();
                    movieManagement.checkoutMovie(movies, Integer.parseInt(checkoutMovieNumberStr));
                    break;
                case "log in":
                    String inputAccountNumberAndPassword = scanner.nextLine();
                    String[] inputAccountInfo = inputAccountNumberAndPassword.split(" ");
                    userManagement.logIn(users, myState,inputAccountInfo[0], inputAccountInfo[1]);
                    break;
                case "view my checkout book":
                    userManagement.viewCheckoutBookList(myState);
                    break;
                case "show my information":
                    break;
                case "log out":
                    userManagement.logOut(myState);
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
}
