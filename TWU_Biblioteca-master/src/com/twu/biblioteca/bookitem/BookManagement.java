package com.twu.biblioteca.bookitem;

import com.twu.biblioteca.MessageInformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookManagement {
    // injection
    private MessageInformation messageInformation;

    public BookManagement(MessageInformation messageInformation) {
        this.messageInformation = messageInformation;
    }

    public List<Book> initializeBookList() {
        // make a new book list
        List<Book> books = new ArrayList<>(Arrays.asList(
                new Book("A Midsummer Night's Dream", "W. William Shakespeare", 1600),
                new Book("Gone With the Wind", "Margaret Mitchell", 1936),
                new Book("Les Misérables", "Victor Hugo", 1862),
                new Book("The Decameron", "Giovanni Boccaccio", 1353),
                new Book("The Little Prince", "Antoine de Saint-Exupéry", 1942)
        ));

        return books;
    }

    public void viewBookList(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (!book.getIsChecked()) {
                System.out.println((i + 1) + " | " + book.getName() + " | "
                        + book.getAuthor() + " | " + book.getPublicationYear());
            }
        }
    }

    // suppose there's a number sticky on the book
    public void checkoutBook(List<Book> books, int bookNumber) {
        if (bookNumber <= books.size() && !books.get(bookNumber - 1).getIsChecked()) {
            books.get(bookNumber - 1).setIsChecked(true);
            messageInformation.showCheckoutBookSuccessfully();
        } else if (books.get(bookNumber - 1).getIsChecked()) {
            messageInformation.showCheckoutBookUnsuccessfully();
        }
    }

    public void returnBook(List<Book> books, int bookNumber) {
        if (bookNumber <= books.size() && books.get(bookNumber - 1).getIsChecked()) {
            books.get(bookNumber - 1).setIsChecked(false);
            messageInformation.showReturnBookSuccessfully();
        } else if (!books.get(bookNumber - 1).getIsChecked()) {
            messageInformation.showReturnBookUnsuccessfully();
        }
    }
}
