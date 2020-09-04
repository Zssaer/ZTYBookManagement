package com.zssaer.ztybookmanagement.bean;

import org.litepal.crud.LitePalSupport;

public class Book extends LitePalSupport {
    private String name;
    private String author;
    private String about;
    private double price;
    private int pages;

    public Book(String name, String author, String about, double price, int pages) {
        this.name = name;
        this.author = author;
        this.about = about;
        this.price = price;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
