package com.twu.biblioteca.movieitem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        this.movie = new Movie("Vertigo", 1958, "Alfred Hitchcock", 9);
    }

    @Test
    public void testGetName() {
        assertEquals("Vertigo", movie.getName());
    }

    @Test
    public void testIsChecked() {
        assertEquals(false, movie.getIsChecked());
        movie.setIsChecked(true);
        assertEquals(true, movie.getIsChecked());
        movie.setIsChecked(false);
        assertEquals(false, movie.getIsChecked());
    }

    @Test
    public void testGetYear() {
        assertEquals(1958, movie.getYear());
    }

    @Test
    public void testGetDirector() {
        assertEquals("Alfred Hitchcock", movie.getDirector());
    }

    @Test
    public void testGetRating() {
        assertEquals(9, movie.getRating());
    }
}