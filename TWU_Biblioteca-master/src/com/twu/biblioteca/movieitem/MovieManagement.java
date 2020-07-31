package com.twu.biblioteca.movieitem;

import com.twu.biblioteca.bookitem.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieManagement {
    public List<Movie> initializeMovieList() {
        // make a new movie list
        List<Movie> movies = new ArrayList<>(Arrays.asList(
                new Movie("Blood Beach", 1980, "Jeffrey Bloom", 0),
                new Movie("Catch Me If You Can", 2002, "Steven Spielberg", 9),
                new Movie("Roma", 2018, "Alfonso Cuarón", 8),
                new Movie("The Reader", 2008, "Stephen Daldry", 8),
                new Movie("The Room", 2003, "Tommy Wiseau",4),
                new Movie("Vertigo", 1958, "Alfred Hitchcock", 9)
        ));

        return movies;
    }

    public void viewBookList(List<Movie> movies) {
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (!movie.getIsChecked()) {
                System.out.println((i + 1) + " | " + movie.getName() + " | "
                        + movie.getDirector() + " | " + movie.getYear() + " | " + movie.getRating());
            }
        }
    }

    public void checkoutMovie(List<Movie> movies, int movieNumber) {
        if (movieNumber <= movies.size() && !movies.get(movieNumber - 1).getIsChecked()) {
            movies.get(movieNumber - 1).setIsChecked(true);
        }
    }
}
