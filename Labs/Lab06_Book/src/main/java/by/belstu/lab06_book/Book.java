package com.example.task1.model;

public class Book {
    private String author;
    private String book_name;
    private int publication_year;
    private int pages;

    //region Getter and Setter
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    //endregion
    //region Constructor
    public Book(String author, String book_name, int publication_year, int pages) {
        this.author = author;
        this.book_name = book_name;
        this.publication_year = publication_year;
        this.pages = pages;
    }
    public Book() {}
    //endregion
}
