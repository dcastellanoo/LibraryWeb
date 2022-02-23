package model;

import java.util.ArrayList;
import java.util.Date;

public class Book {
    private String title;
    private String isbn;
    private Long pageCount;
    private String imageURL;
    private String description;
    private ArrayList<String> authors;
    private ArrayList<String> categories;
    private double price;

    public Book(String title, String isbn, Long pageCount, String imageURL, String description, ArrayList<String> authors, ArrayList<String> categories, double price) {
        this.title = title;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.imageURL = imageURL;
        this.description = description;
        this.authors = authors;
        this.categories = categories;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public double getPrice() {
        return price;
    }
}
