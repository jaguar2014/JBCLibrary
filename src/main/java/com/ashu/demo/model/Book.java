package com.ashu.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Min(1)
    private String title;

    @NotNull
    @Min(1)
    private String author;

    private Date yearOfPublication;

    //optional
    @Null
    private String isbn;

    //optional
    @Null
    private String imageUrl;

    @NotNull
    private boolean isAvilable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Date yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isAvilable() {
        return isAvilable;
    }

    public void setAvilable(boolean avilable) {
        isAvilable = avilable;
    }
}
