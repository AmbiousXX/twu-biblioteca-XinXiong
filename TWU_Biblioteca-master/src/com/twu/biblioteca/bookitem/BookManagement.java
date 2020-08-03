package com.twu.biblioteca.bookitem;

import com.twu.biblioteca.MessageInformation;
import com.twu.biblioteca.elementusage.ElementManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookManagement implements ElementManagement<Book>  {
    private BookManagement() {}
    private static BookManagement bookManagement = new BookManagement();
    public static BookManagement getBookManagement() {
        return bookManagement;
    }

    public List<Book> initializeBookList() {
        List<Book> books = new ArrayList<>(Arrays.asList(
                new Book("A Midsummer Night's Dream", "W. William Shakespeare", 1600),
                new Book("Gone With the Wind", "Margaret Mitchell", 1936),
                new Book("Les Misérables", "Victor Hugo", 1862),
                new Book("The Decameron", "Giovanni Boccaccio", 1353),
                new Book("The Little Prince", "Antoine de Saint-Exupéry", 1942)
        ));

        return books;
    }

    @Override
    public boolean isInTheList(List<Book> books, int elementNumber) {
        return elementNumber <= books.size();
    }

    @Override
    public boolean isChecked(List<Book> books, int bookNumber) {
        return books.get(bookNumber - 1).getIsChecked();
    }

    @Override
    public void viewList(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (!book.getIsChecked()) {
                System.out.println((i + 1) + " | " + book.getName() + " | "
                        + book.getAuthor() + " | " + book.getPublicationYear());
            }
        }
    }

    @Override
    public boolean checkoutElement(List<Book> books, int elementNumber) {
        if (isInTheList(books, elementNumber) && !isChecked(books, elementNumber)) {
            books.get(elementNumber - 1).setIsChecked(true);
            return true;
        } else {
            MessageInformation.getMessageInformation().showCheckoutBookUnsuccessfully();
        }

        return false;
    }

    public void viewBookList(List<Book> books) {
        viewList(books);
    }

    public boolean checkoutBook(List<Book> books, int bookNumber) {
        return checkoutElement(books, bookNumber);
    }

    public void returnBook(List<Book> books, int bookNumber) {
        if (isInTheList(books, bookNumber) && isChecked(books, bookNumber)) {
            books.get(bookNumber - 1).setIsChecked(false);
            MessageInformation.getMessageInformation().showReturnBookSuccessfully();
        } else {
            MessageInformation.getMessageInformation().showReturnBookUnsuccessfully();
        }
    }
}
