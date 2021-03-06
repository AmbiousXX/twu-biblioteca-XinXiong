package com.twu.biblioteca.movieitem;

import com.twu.biblioteca.MessageInformation;
import com.twu.biblioteca.elementusage.ElementManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieManagement implements ElementManagement<Movie> {
    private MovieManagement() {}

    private static MovieManagement movieManagement = new MovieManagement();

    public static MovieManagement getMovieManagement() {
        return movieManagement;
    }

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

    @Override
    public boolean isInTheList(List<Movie> movies, int elementNumber) {
        return elementNumber <= movies.size();
    }

    @Override
    public boolean isChecked(List<Movie> movies, int movieNumber) {
        return movies.get(movieNumber - 1).getIsChecked();
    }

    @Override
    public void viewList(List<Movie> movies) {
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (!movie.getIsChecked()) {
                System.out.println((i + 1) + " | " + movie.getName() + " | "
                        + movie.getDirector() + " | " + movie.getYear() + " | " + movie.getRating());
            }
        }
    }

    @Override
    public boolean checkoutElement(List<Movie> movies, int elementNumber) {
        if (isInTheList(movies, elementNumber) && !isChecked(movies, elementNumber)) {
            movies.get(elementNumber - 1).setIsChecked(true);
            MessageInformation.getMessageInformation().showCheckoutMovieSuccessfully();
            return true;
        }

        return false;
    }

    public void viewMovieList(List<Movie> movies) {
        viewList(movies);
    }

    public boolean checkoutMovie(List<Movie> movies, int movieNumber) {
        return  checkoutElement(movies, movieNumber);
    }
}
