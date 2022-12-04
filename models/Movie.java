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
        this.name = name;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private void setRentingPrice(double rentingPrice) {
        this.rentingPrice = rentingPrice;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
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
