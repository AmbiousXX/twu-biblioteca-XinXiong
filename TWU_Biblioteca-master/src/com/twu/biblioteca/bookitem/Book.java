package com.twu.biblioteca.bookitem;

import com.twu.biblioteca.elementusage.Element;

public class Book extends Element {
    private String author;
    private int publicationYear;
    private boolean isChecked;

    public Book(String name, String author, int publicationYear) {
        super(name);
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
