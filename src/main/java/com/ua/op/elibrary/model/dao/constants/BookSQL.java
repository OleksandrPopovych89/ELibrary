package com.ua.op.elibrary.model.dao.constants;

public interface BookSQL {
    String SELECT = "SELECT * FROM books";
    String ADD_BOOK = "INSERT INTO books " +
            "(book_name, author_name, publisher_name, date_of_publication, quantity)" +
            " VALUES(?,?,?,?,?)";

    String GET_BY_TITLE_AUTHOR_NAME = "SELECT * FROM books WHERE book_name=? OR author_name=? ";
}
