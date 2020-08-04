package com.twu.biblioteca;

import com.twu.biblioteca.bookitem.*;
import com.twu.biblioteca.movieitem.*;
import com.twu.biblioteca.useritem.*;

import java.util.Scanner;

public class RunApplication {
    public void runApplication() {
        MessageInformation messageInformation = MessageInformation.getMessageInformation();
        BookManagement bookManagement = BookManagement.getBookManagement();
        MovieManagement movieManagement = MovieManagement.getMovieManagement();
        UserManagement userManagement = UserManagement.getUserManagement();
        Option option = Option.getOption();
        MyState myState = new MyState();

        messageInformation.showWelcomeMessage();

        option.viewOptionMenuBeforeLogIn();
        MessageInformation.getMessageInformation().showHintBeforeChooseOption();

        Scanner scanner = new Scanner(System.in);

        option.dealWithInputOptionBeforeLogIn(scanner, myState, bookManagement, movieManagement, userManagement);
    }
}
