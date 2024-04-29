package com.bookmanagement.application.usecase.iodata;

public class BookOutputDataImpl implements BookOutputData {
    private Long id;
    private String title;
    private String author;
    private String internationalStandardBookNumber;
    private Integer quantity;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getInternationalStandardBookNumber() {
        return internationalStandardBookNumber;
    }

    public void setInternationalStandardBookNumber(String internationalStandardBookNumber) {
        this.internationalStandardBookNumber = internationalStandardBookNumber;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookOutputData{" +
                "\"id\": " + id +
                ", \"title\": \"" + title + '\"' +
                ", \"author\": \"" + author + '\"' +
                ", \"internationalStandardBookNumber\": \"" + internationalStandardBookNumber + '\"' +
                ", \"quantity\": " + quantity +
                '}';
    }
}
