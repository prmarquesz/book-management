package com.bookmanagement.infra.http.controller.form;

import com.bookmanagement.application.usecase.iodata.BookInputData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class BookForm implements BookInputData {
    @NotNull
    @NotEmpty
    @NotBlank
    @Length(min = 1, max = 200)
    private String title;
    @NotNull
    @NotEmpty
    @NotBlank
    @Length(min = 3, max = 100)
    private String author;
    @NotNull
    @NotEmpty
    @NotBlank
    @Length(min = 13, max = 14)
    private String internationalStandardBookNumber;
    @NotNull
    private Integer quantity;

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
        return "BookForm{" +
                "\"title\": \"" + title + '\"' +
                ", \"author\": \"" + author + '\"' +
                ", \"internationalStandardBookNumber\": \"" + internationalStandardBookNumber+ '\"' +
                ", \"quantity\": " + getQuantity() +
                '}';
    }
}
