package com.twu;

import java.util.ArrayList;
import java.util.List;

public class MovieStack {
    protected static List<Movie> movies;

    public static String getAllMovies() {
        StringBuffer movieList = new StringBuffer();
        for (Movie movie : movies) {
            movieList.append(movie.toString() + "\n");
        }
        return movieList.toString().trim();
    }


    public static void initMovieStack() {
        movies = new ArrayList<Movie>();
        movies.add(new Movie("BlackSwing", "Tomas", 2));
        movies.add(new Movie("movie1", "director1", 3));
        movies.add(new Movie("movie2", "director2", 4));
        movies.add(new Movie("movie3", "director3", 5));
        movies.add(new Movie("movie4", "director4", 6));
        movies.add(new Movie("movie5", "director5", 0));
        movies.add(new Movie("movie6", "director6", 3));
        movies.add(new Movie("movie7", "director7", 1));
        movies.add(new Movie("movie8", "director8", 2));
        movies.add(new Movie("movie9", "director9", 7));
        movies.add(new Movie("movie10", "director10", 8));
        movies.add(new Movie("movie11", "director11", 9));
        movies.add(new Movie("movie12", "director12", 3));
        movies.add(new Movie("movie13", "director13", 0));
        movies.add(new Movie("movie14", "director14", 4));
        movies.add(new Movie("movie15", "director15", 6));
    }
}
