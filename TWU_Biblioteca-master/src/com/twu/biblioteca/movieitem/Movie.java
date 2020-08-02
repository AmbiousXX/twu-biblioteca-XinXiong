package com.twu.biblioteca.movieitem;

import com.twu.biblioteca.elementusage.Element;

public class Movie extends Element {
    private String director;
    private int year;
    private int rating;      /* 0 for unrated */

    public Movie(String name, int year, String director, int rating) {
        super(name);
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }
}
