package com.twu;

public class Movie {
    private String name;
    private String director;
    private int rating;

    public Movie(String name, String director, int rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object obj) {
        Movie movie = (Movie) obj;
        return this.name == movie.name && this.director == movie.director && this.rating == movie.rating;
    }

    @Override
    public String toString() {
        if (rating != 0) {
            return name + " " + director + " " + rating;
        } else {
            return name + " " + director + " N/A";
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode() + director.hashCode() + rating;
    }
}
