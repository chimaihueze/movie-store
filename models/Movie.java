package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentingPrice;
    private boolean isAvailable;

    // Constructor
    public Movie(String name, String format, double rating) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Sorry, name cannot be blank/null");
        }

        if (format.equalsIgnoreCase("Blue-Ray") || format.equalsIgnoreCase("DVD")) {
            throw new IllegalArgumentException("Sorry, format must be Blue-Ray or DVD");
        }

        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Sorry, improper rating scale.");
        }

        this.name = name;
        this.format = format;
        this.rating = rating;
        this.sellingPrice = format.equals("Blue-Ray") ? 4.25 : 2.25;
        this.rentingPrice = format.equals("Blue-Ray") ? 1.99 : 0.99;
        this.isAvailable = true;
    }

    // copy constructor
    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.sellingPrice;
        this.rentingPrice = source.rentingPrice;
        this.isAvailable = source.isAvailable;
    }

    // getters

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public double getRating() {
        return rating;
    }

    public double getRentingPrice() {
        return rentingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // setters

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Sorry, name can not be set to blank/null.");
        }
        this.name = name;
    }

    public void setFormat(String format) {
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("Sorry, format cannot be set to blank/null");
        }
        this.format = format;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating> 10) {
            throw new IllegalArgumentException("Sorry, rating can not be set to less than 0 or more than 10");
        }
        this.rating = rating;
    }

    private void setRentingPrice(double rentingPrice) {
        this.rentingPrice = rentingPrice;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    // setAvailable
    public void setAvailable(boolean availability) {
        this.isAvailable = availability;

    }

    // toString
    public String toString() {
        return "\t Name: " + this.name + "\n" +

                "\t Format: " + this.format + "\n" +

                "\t Rating: " + this.rating + "\n" +

                "\t Selling Price: " + this.sellingPrice + "\n" +

                "\t Rental Price: " + this.rentingPrice + "\n" +

                "\t Availability: " + (this.isAvailable ? "in-stock" : "rented") + "\n";
    }
    
}
