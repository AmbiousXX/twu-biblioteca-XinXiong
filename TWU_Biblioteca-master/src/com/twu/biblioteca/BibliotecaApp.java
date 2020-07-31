package com.twu.biblioteca;

import com.twu.biblioteca.bookitem.*;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    MessageInformation messageInformation = new MessageInformation();
    BookManagement bookManagement = new BookManagement(messageInformation);
    Option option = new Option();

    List<Book> books = bookManagement.initializeBookList();

    public void manualDealWithOptionMenu() {
        messageInformation.showWelcomeMessage();

        option.initializeAndViewOptionMenu();

        Scanner scanner = new Scanner(System.in);

        option.dealWithInputOption(scanner, books);
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.manualDealWithOptionMenu();
    }
}
