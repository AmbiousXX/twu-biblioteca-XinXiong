package com.twu.biblioteca.bookitem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        this.book = new Book("Gone With the Wind", "Margaret Mitchell", 1936);
    }

    @Test
    public void testGetName() {
        assertEquals("Gone With the Wind", book.getName());
    }

    @Test
    public void testIsChecked() {
        assertEquals(false, book.getIsChecked());
        book.setIsChecked(true);
        assertEquals(true, book.getIsChecked());
        book.setIsChecked(false);
        assertEquals(false, book.getIsChecked());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Margaret Mitchell", book.getAuthor());
    }

    @Test
    public void testGetPublicationYear() {
        assertEquals(1936, book.getPublicationYear());
    }
}