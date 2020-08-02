package com.twu.biblioteca;

import com.twu.biblioteca.bookitem.*;
import com.twu.biblioteca.movieitem.*;
import com.twu.biblioteca.useritem.*;

import java.util.Scanner;

public class BibliotecaApp {
    private MessageInformation messageInformation;
    private BookManagement bookManagement;
    private MovieManagement movieManagement;
    private UserManagement userManagement;
    private Option option;
    private MyState myState;

    public BibliotecaApp(MessageInformation messageInformation, BookManagement bookManagement,
                         MovieManagement movieManagement, UserManagement userManagement,
                         Option option, MyState myState) {
        this.messageInformation = messageInformation;
        this.bookManagement = bookManagement;
        this.movieManagement = movieManagement;
        this.userManagement = userManagement;
        this.option = option;
        this.myState = myState;
    }

    public void manualDealWithOptionMenu() {
        messageInformation.showWelcomeMessage();

        option.viewOptionMenuBeforeLogIn();
        MessageInformation.getMessageInformation().showHintBeforeChooseOption();

        Scanner scanner = new Scanner(System.in);

        option.dealWithInputOptionBeforeLogIn(scanner, myState, bookManagement, movieManagement, userManagement);
    }

    public static void main(String[] args) {
        MessageInformation messageInformation = MessageInformation.getMessageInformation();
        BookManagement bookManagement = BookManagement.getBookManagement();
        MovieManagement movieManagement = MovieManagement.getMovieManagement();
        UserManagement userManagement = UserManagement.getUserManagement();
        Option option = Option.getOption();
        MyState myState = new MyState();

        BibliotecaApp bibliotecaApp = new BibliotecaApp(messageInformation, bookManagement,
                movieManagement, userManagement, option, myState);
        bibliotecaApp.manualDealWithOptionMenu();
    }
}
