package com.ua.op.elibrary.controller.actions.implementation.admin;

import com.ua.op.elibrary.controller.actions.Action;
import com.ua.op.elibrary.model.dao.implementation.OrderDAOImpl;
import com.ua.op.elibrary.model.entities.Order;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.List;

import static com.ua.op.elibrary.controller.actions.constants.Pages.ORDERS_LIST_PAGE;

public class OrdersListAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Order> orderList = new OrderDAOImpl().getAll();
        request.setAttribute("orders", orderList);
        return ORDERS_LIST_PAGE;
    }
}
