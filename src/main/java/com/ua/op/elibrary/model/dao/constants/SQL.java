package com.ua.op.elibrary.model.dao.constants;

public interface SQL {

    /**
     * Book queries
     */
    String SELECT_ALL_BOOKS = "SELECT * FROM books";
    String ADD_BOOK = "INSERT INTO books " + "(book_name, author_name, publisher_name, date_of_publication, quantity)"
            + " VALUES(?,?,?,?,?)";
    String UPDATE_BOOK = "UPDATE books\n" + "SET book_title=?, author_name=?, publisher_name=?, " +
            "isbn=?,date_of_publication=?, quantity=?\n"
            + "WHERE book_id = ?;";
    String DELETE_BOOK = "DELETE FROM books WHERE book_id=?";
    String GET_BY_TITLE_AUTHOR_NAME = "SELECT * FROM books WHERE book_name=? OR author_name=? ";

    /**
     * User queries
     */
    String SELECT_ALL_USERS = "SELECT * FROM users";
    String ADD_USER = "INSERT INTO users " + "(user_email, user_password, user_pone_number, user_firstname," +
            " user_lastname, user_role_id, user_is_blocked)"
            + " VALUES(?,?,?,?,?,?,?)";

    String UPDATE_USER = "UPDATE users\n"
            + "SET user_email=?, user_pone_number=?, user_firstname=?, user_lastname=?"
            + "WHERE user_id = ?;";
    String DELETE_USER = "DELETE FROM users WHERE user_id=?";

    /**
     * Order queries
     */
    String SELECT_ALL_ORDERS = "SELECT * FROM orders\n"
            + "JOIN books b on b.book_id = orders.book_id\n"
            + "JOIN users u on u.user_id = orders.user_id";
    String ADD_ORDER = "INSERT INTO order " + "(user_id, user_email, user_password, user_pone_number, user_firstname," +
            " user_lastname, user_role, user_is_blocked)"
            + " VALUES(?,?,?,?,?,?,?,?)";
}