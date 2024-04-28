package com.bookmanagement.application.usecase.iodata;

public interface BookInputData {
    String getTitle();
    String getAuthor();
    String getInternationalStandardBookNumber();
    Integer getQuantity();
    String toString();
}
