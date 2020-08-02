package com.twu.biblioteca.movieitem;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieManagementTest {
    private MovieManagement movieManagement;
    private List<Movie> movies;

    @Before
    public void setUp() {
        this.movieManagement = MovieManagement.getMovieManagement();
    }

    @Test
    public void initializeMovieList() {
        this.movies = movieManagement.initializeMovieList();
        Movie theSecondMovie = movies.get(1);
        assertEquals(theSecondMovie.getName(), "Catch Me If You Can");
        assertEquals(theSecondMovie.getYear(), 2002);
        assertEquals(theSecondMovie.getDirector(), "Steven Spielberg");
        assertEquals(theSecondMovie.getRating(), 9);
        assertEquals(theSecondMovie.getIsChecked(), false);
    }

    @Test
    public void checkoutMovieSuccessfully() {
        this.movies = movieManagement.initializeMovieList();
        assertEquals(false, movies.get(5).getIsChecked());
        movieManagement.checkoutMovie(movies, 6);
        assertEquals(true, movies.get(5).getIsChecked());
    }
}