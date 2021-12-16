package com.example.books.controller;

import com.example.books.model.BookModel;
import com.example.books.service.BooksService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(BooksController.PATH)

public class BooksController {

    public static final String PATH = "/title";
    public static final String GET_BOOK = "/getBook";

    @Autowired
    private BooksService booksService;

    @PostMapping(value = GET_BOOK, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get book", response = BookModel.class, httpMethod = "POST")

    public BookModel getBook(@RequestBody BookRequest request) throws SQLException, ClassNotFoundException {
        return booksService.getBook(request);
    }
}