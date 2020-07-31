package com.twu.biblioteca.movieitem;

public class Movie {
    private String name;
    private String director;
    private int year;
    private int rating;
    private boolean isChecked;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    // 0 for unrated
    public int getRating() {
        return rating;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
