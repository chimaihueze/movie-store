package models;

import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

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
        if (action == null || action.isBlank()) {
            throw new IllegalArgumentException("Sorry! Action shouldn't be null/blank");
        }

        if (!(action.equalsIgnoreCase("sell") || action.equalsIgnoreCase("rent") || action.equalsIgnoreCase("return"))) {
            throw new IllegalArgumentException("Sorry! Action should either be sell, rent or return ");
        }

        if (movies.isEmpty()) {
            throw new IllegalStateException("Sorry, the list is empty");
        }

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(name)) {
                switch (action) {
                    case "sell": if (!(movies.get(i).isAvailable())) {
                        throw new IllegalStateException("Can't sell a movie that's rented out");
                    }
                        this.movies.remove(i); break;
                    case "rent": this.movies.get(i).setAvailable(false); break;
                    case "return": this.movies.get(i).setAvailable(true); break;
                }
            }
        }
    }

    // toString
    public String toString() {
        String temp = " ";
        for (int i = 0; i < movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        } return temp;
    }
}
