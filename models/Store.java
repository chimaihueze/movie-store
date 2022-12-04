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

    // addMovie
    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public void action(String name, String action) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(name)) {
                switch (action) {
                    case "sell": this.movies.remove(i); break;
                    case "rent": this.movies.get(i).setAvailable(false); break;
                    case "return": this.movies.get(i).setAvailable(true); break;
                }
            }
        }
    }
}
