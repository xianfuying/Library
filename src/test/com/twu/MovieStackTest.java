package com.twu;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.hasItem;

public class MovieStackTest {
    @Test
    public void should_add_default_movies_when_initial_movie_stack() {
        Movie movie = new Movie("BlackSwing", "Tomas", 2);
        MovieStack.initMovieStack();

        assertThat(MovieStack.movies, hasItem(movie));
    }

    @Test
    public void should_return_all_movie_info() {
        MovieStack.initMovieStack();
        String allMovies = MovieStack.getAllMovies();
        assertThat(allMovies, containsString("BlackSwing Tomas 2\n"));
    }
}
