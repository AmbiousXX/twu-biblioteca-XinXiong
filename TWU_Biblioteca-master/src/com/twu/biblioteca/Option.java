package com.twu.biblioteca;

import com.twu.biblioteca.bookitem.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Option {
    boolean isQuit;

    public void initializeAndViewOptionMenu() {
        List<String> options = new ArrayList<String>();
        options.add("List of Books");
        options.add("Check out book");
        options.add("Return book");
        options.add("Quit");
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void dealWithInputOption(Scanner scanner, List<Book> books) {
        MessageInformation messageInformation = new MessageInformation();
        BookManagement bookManagement = new BookManagement(messageInformation);

        do {
            // get an input from console
            String inputOption = scanner.nextLine();

            switch (inputOption) {
                case "list of books":
                    bookManagement.viewBookList(books);
                    break;
                case "check out book":
                    String checkoutBookNumberStr = scanner.nextLine();
                    bookManagement.checkoutBook(books, Integer.parseInt(checkoutBookNumberStr));
                    break;
                case "return book":
                    String returnBookNumberStr = scanner.nextLine();
                    bookManagement.returnBook(books, Integer.parseInt(returnBookNumberStr));
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
