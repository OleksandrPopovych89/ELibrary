package com.ua.op.elibrary.controller.actions.implementation.general;

import com.ua.op.elibrary.controller.actions.Action;
import com.ua.op.elibrary.model.dao.implementation.BookDAOImpl;
import com.ua.op.elibrary.model.entities.Book;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.sql.SQLException;
import java.util.List;

import static com.ua.op.elibrary.controller.actions.constants.Pages.BOOK_LIST_PAGE;

public class BooksListAction implements Action {


    @SneakyThrows
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Book> bookList = new BookDAOImpl().getAll();
        request.setAttribute("books", bookList);
        return BOOK_LIST_PAGE;
    }
}
