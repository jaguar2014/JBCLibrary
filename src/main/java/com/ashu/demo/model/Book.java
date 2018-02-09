package com.ashu.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Book {

    public Book(){
        isAvilable=true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 3, max = 30)
    private String title;

    @NotNull
    @Size(min = 3, max = 30)
    private String author;

    @NotNull
    @Size(min = 3, max = 30)
    private String yearOfPublication;

    //optional
    @Column(nullable = true)
    private String isbn;

    //optional
    @Column(nullable = true)
    private String imageUrl;



    @Column(nullable = true)
    private Date timeStamp;

    @NotNull
    private Boolean isAvilable;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Boolean getAvilable() {
        return isAvilable;
    }

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

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
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

    public Boolean getIsAvilable() {
        return isAvilable;
    }

    public void setAvilable(Boolean avilable) {
        isAvilable = avilable;
    }
}
