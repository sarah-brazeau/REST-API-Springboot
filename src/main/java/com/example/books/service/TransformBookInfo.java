package com.example.books.service;

import com.example.books.model.BookModel;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TransformBookInfo {
    public BookModel transformResponse(ResultSet result) throws SQLException {
        BookModel bookModel = new BookModel();
        result.next();

        bookModel.setTitle(result.getString("title"));
        bookModel.setAuthor(result.getString("author"));
        bookModel.setGenre(result.getString("genre"));
        bookModel.setPages(result.getString("pages"));
        bookModel.setPublished(result.getString("published"));
        bookModel.setReview(result.getString("review"));

        return bookModel;
    }

}
