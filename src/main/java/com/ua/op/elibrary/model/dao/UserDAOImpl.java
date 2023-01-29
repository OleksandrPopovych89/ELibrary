package com.ua.op.elibrary.model.dao;

import com.ua.op.elibrary.model.connection.HikariCPDataSource;
import com.ua.op.elibrary.model.entities.Role;
import com.ua.op.elibrary.model.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.ua.op.elibrary.model.dao.constants.SQL.ADD_USER;
import static com.ua.op.elibrary.model.dao.constants.SQL.SELECT_ALL_USERS;
import static com.ua.op.elibrary.model.dao.constants.TableFields.*;

public class UserDAOImpl implements UserDAO {
    @Override
    public void add(User user) throws SQLException {
        try (Connection con = HikariCPDataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(ADD_USER)) {
            setFieldsToPS(user, ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        try (Connection con = HikariCPDataSource.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery(SELECT_ALL_USERS)) {
            while (rs.next()) {
                userList.add(createUser(userList, rs));
            }
        }
        return userList;
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public void delete(long id) throws SQLException {

    }


    private static void setFieldsToPS(User user, PreparedStatement ps) throws SQLException {
        int k = 0;
        ps.setString(++k, user.getUserEmail());
        ps.setString(++k, user.getUserPassword());
        ps.setString(++k, user.getUserPhoneNumber());
        ps.setString(++k, user.getUserFirstname());
        ps.setString(++k, user.getUserLastname());
        ps.setInt(++k, 1);
        ps.setBoolean(++k, user.isBlocked());
    }

    /**
     * The utility method that creates the user populates all the fields from the result set and returns it.
     */
    private static User createUser(List<User> userList, ResultSet rs) throws SQLException {

        return User.builder().
                userId(rs.getInt(USER_ID)).
                userEmail(rs.getString(USER_EMAIL)).
                userPassword(rs.getString(USER_PASSWORD)).
                userPhoneNumber(rs.getString(USER_PHONE_NUMBER)).
                userFirstname(rs.getString(USER_FIRSTNAME)).
                userLastname(rs.getString(USER_LASTNAME)).
                userRole(Role.getRole(rs.getInt(USER_ROLE_ID))).
                isBlocked(rs.getBoolean(USER_IS_BLOCKED)).
                build();

    }

    public static void main(String[] args) throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();
        System.out.println(userDAO.getAll());
    }
}
