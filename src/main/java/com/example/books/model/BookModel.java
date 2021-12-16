package com.example.books.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
public class BookModel {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String author;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String review;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String published;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String genre;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pages;
}
