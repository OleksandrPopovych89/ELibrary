package com.ua.op.elibrary.model.dao.constants;

public interface SQL {
    String SELECT_ALL_BOOKS = "SELECT * FROM books";
    String ADD_BOOK = "INSERT INTO books " +
            "(book_name, author_name, publisher_name, date_of_publication, quantity)" +
            " VALUES(?,?,?,?,?)";

    String GET_BY_TITLE_AUTHOR_NAME = "SELECT * FROM books WHERE book_name=? OR author_name=? ";

    String SELECT_ALL_USERS = "SELECT * FROM users";
    String ADD_USER = "INSERT INTO user " +
            "(user_id, user_email, user_password, user_pone_number, user_firstname, user_lastname, user_role, user_is_blocked)" +
            " VALUES(?,?,?,?,?,?,?,?)";

    String SELECT_ALL_ORDERS = "SELECT * FROM orders";
    String ADD_ORDER = "INSERT INTO order " +
            "(user_id, user_email, user_password, user_pone_number, user_firstname, user_lastname, user_role, user_is_blocked)" +
            " VALUES(?,?,?,?,?,?,?,?)";
}
