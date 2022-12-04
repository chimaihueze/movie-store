package models;

import java.util.ArrayList;

public class Store {
    private ArrayList<Movie> movies;

    // constructor
    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    // getter

    public Movie getMovies(int index) {
        return new Movie(this.movies.get(index));
    }

    // setter

    public void setMovies(int index, Movie movie) {
        this.movies.set(index, movie);
    }
}
