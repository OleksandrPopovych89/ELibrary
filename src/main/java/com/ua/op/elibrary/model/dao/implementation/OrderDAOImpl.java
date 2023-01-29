package com.ua.op.elibrary.model.dao.implementation;

import com.ua.op.elibrary.model.connection.HikariCPDataSource;
import com.ua.op.elibrary.model.dao.OrderDAO;
import com.ua.op.elibrary.model.entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.ua.op.elibrary.model.dao.constants.SQL.*;
import static com.ua.op.elibrary.model.dao.constants.TableFields.*;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public void add(Order order) throws SQLException {
        try (Connection con = HikariCPDataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(ADD_ORDER)) {
            setFieldsToPS(order, ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public List<Order> getAll() throws SQLException {
        List<Order> orderList = new ArrayList<>();
        try (Connection con = HikariCPDataSource.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery(SELECT_ALL_ORDERS)) {
            while (rs.next()) {
                orderList.add(createOrder(rs));
            }
        }
        return orderList;
    }

    @Override
    public void update(Order order) throws SQLException {

    }

    @Override
    public void delete(long id) throws SQLException {

    }

    private static void setFieldsToPS(Order order, PreparedStatement ps) throws SQLException {
        int k = 0;
        ps.setInt(++k, order.getOrderId());
        ps.setInt(++k, order.getBookId());
        ps.setInt(++k, order.getUserId());
        ps.setInt(++k, order.getSubscriptionType());
        ps.setInt(++k, order.getOrderStatusId());
        ps.setDate(++k, Date.valueOf(order.getOrderCreateTime()));
        ps.setDate(++k, Date.valueOf(order.getReturnDeadline()));
    }

    /**
     * The utility method that creates the user populates all the fields from the result set and returns it.
     */
    private static Order createOrder(ResultSet rs) throws SQLException {
        return Order.builder().
                orderId(rs.getInt(ORDER_ID)).
                orderId(rs.getInt(BOOK_ID)).
                bookId(rs.getInt(USER_ID)).
                subscriptionType(rs.getInt(SUBSCRIPTION_TYPE_ID)).
                orderStatusId(rs.getInt(ORDER_STATUS_ID)).
                orderCreateTime(rs.getDate(ORDER_CREATE_TIME).toLocalDate()).
                returnDeadline(rs.getDate(RETURN_DEADLINE).toLocalDate()).
                build();
    }

    public static void main(String[] args) throws SQLException {
        new OrderDAOImpl().getAll().forEach(System.out::println);
    }
}