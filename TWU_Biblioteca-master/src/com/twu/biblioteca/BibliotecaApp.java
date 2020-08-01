package com.twu.biblioteca;

import com.twu.biblioteca.bookitem.*;
import com.twu.biblioteca.movieitem.Movie;
import com.twu.biblioteca.movieitem.MovieManagement;
import com.twu.biblioteca.useritem.MyState;
import com.twu.biblioteca.useritem.User;
import com.twu.biblioteca.useritem.UserManagement;

import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    // TODO
    public void systemInitialization() {
        // 几个板块的初始化
    }

    MessageInformation messageInformation = new MessageInformation();
    MyState myState = new MyState();
    BookManagement bookManagement = new BookManagement(messageInformation);
    MovieManagement movieManagement = new MovieManagement();
    UserManagement userManagement = new UserManagement();
    Option option = new Option();

    List<Book> books = bookManagement.initializeBookList();
    List<Movie> movies = movieManagement.initializeMovieList();
    Hashtable<String, User> users = userManagement.initializeUserList();

    public void manualDealWithOptionMenu() {
        messageInformation.showWelcomeMessage();

        option.initializeAndViewOptionMenuBeforeLogIn();

        Scanner scanner = new Scanner(System.in);

        option.dealWithInputOptionBeforLogIn(scanner, myState, books, movies, users);
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.manualDealWithOptionMenu();
//        UserManagement userManagement = new UserManagement();
//        MyState myState = new MyState();
//        Hashtable<String, User> users = userManagement.initializeUserList();
//        Scanner scanner = new Scanner(System.in);
//        String inputOption = scanner.nextLine();
//        // userManagement.logIn(users, "lxm-0376", "!ad7dl23");
//        userManagement.logIn(users, myState,"lxm-0376", inputOption);
//        System.out.println(myState.getUserAccount().getAccountNumber());
//        userManagement.logOut(myState);
//        System.out.println(myState.getUserAccount().getAccountNumber());
    }
}
