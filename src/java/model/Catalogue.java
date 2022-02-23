package model;

import java.util.ArrayList;

public class Catalogue {
    private ArrayList<Book> bookList;

    public Catalogue(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
    
    public Book findBookByIsbn(String isbn) {
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }
}
