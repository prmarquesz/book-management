package com.bookmanagement.application.usecase.iodata;

public interface BookOutputData {
    Long getId();
    String getTitle();
    String getAuthor();
    String getInternationalStandardBookNumber();
    Integer getQuantity();
    String toString();
}
