package com.ua.op.elibrary.model.dao.implementation;

import com.ua.op.elibrary.model.connection.HikariCPDataSource;
import com.ua.op.elibrary.model.dao.BookDAO;
import com.ua.op.elibrary.model.entities.Book;
import com.ua.op.elibrary.model.dao.constants.TableFields;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.ua.op.elibrary.model.dao.constants.SQL.*;
import static com.ua.op.elibrary.model.dao.constants.TableFields.*;


public class BookDAOImpl implements BookDAO {
    /**
     * Added new book to database
     */
    @Override
    public void add(Book book) throws SQLException {
        try (Connection con = HikariCPDataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(ADD_BOOK)) {
            setFieldsToPS(book, ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    /**
     * Returns all books
     */
    @Override
    public List<Book> getAll() throws SQLException {
        try (Connection con = HikariCPDataSource.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery(SELECT_ALL_BOOKS)) {
            List<Book> bookList = new ArrayList<>();
            while (rs.next()) {
                bookList.add(createBook(rs));
            }
            return bookList;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void update(Book book) throws SQLException {
        try (Connection con = HikariCPDataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_BOOK)) {
            setFieldsToPS(book, ps);
            ps.setLong(7, book.getBookID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void delete(long id) throws SQLException {
        try (Connection con = HikariCPDataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE_BOOK)) {
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    /**
     * The utility method which setts all fields to prepare statement
     */
    private static void setFieldsToPS(Book book, PreparedStatement ps) throws SQLException {
        int k = 0;
        ps.setString(++k, book.getBookTitle());
        ps.setString(++k, book.getAuthorName());
        ps.setString(++k, book.getPublisherName());
        ps.setString(++k, book.getISBN());
        ps.setInt(++k, book.getDateOfPublication());
        ps.setInt(++k, book.getQuantity());
    }

    /**
     * Finds all entries where the book title or author name matches the search string
     */
    public List<Book> getByTitleAndAuthor(String titleOrAuthorName) throws SQLException {
        Book book;
        try (Connection con = HikariCPDataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(GET_BY_TITLE_AUTHOR_NAME)) {
            int k = 0;
            ps.setString(++k, titleOrAuthorName);
            ps.setString(++k, titleOrAuthorName);
            ResultSet rs = ps.executeQuery();
            List<Book> bookList = new ArrayList<>();
            while (rs.next()) {
                bookList.add(createBook(rs));
            }
            return bookList;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    /**
     * The utility method that creates the workbook populates all the fields from the result set and returns it.
     */
    protected static Book createBook(ResultSet rs) throws SQLException {
        return Book.builder().
                bookID(rs.getInt(BOOK_ID)).
                bookTitle(rs.getString(BOOK_TITLE)).
                authorName(rs.getString(AUTHOR_NAME)).
                publisherName(rs.getString(PUBLISHER_NAME)).
                ISBN(rs.getString(TableFields.ISBN)).
                dateOfPublication(rs.getInt(DATE_OF_PUBLICATION)).
                quantity(rs.getInt(QUANTITY)).
                build();
    }
}
