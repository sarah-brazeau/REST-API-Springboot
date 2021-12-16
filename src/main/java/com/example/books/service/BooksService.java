package com.example.books.service;

import com.example.books.controller.BookRequest;
import com.example.books.exception.ExceptionDataNotFound;
import com.example.books.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class BooksService {
    private String url = "jdbc:mysql://localhost:3306/book_project";
    private final String username = "root";
    private final String password = "mysqlpassword19!";

    @Autowired
    TransformBookInfo transformBookInfo;

    String sql = "Select * from book_info where Title = ";

    Statement statement;
    Connection connection;
    ResultSet resultSet;

    public BookModel getBook(BookRequest request) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();

        String bookTitle = request.title;
        try {
            resultSet = statement.executeQuery(sql + "\"" + bookTitle + "\"");
            BookModel bookinfo = transformBookInfo.transformResponse(resultSet);
            statement.close();
            connection.close();
            return bookinfo;

        } catch (SQLException e) {
            throw new ExceptionDataNotFound("This book does not exist. Please try again with a valid book title");
      }
    }
}
