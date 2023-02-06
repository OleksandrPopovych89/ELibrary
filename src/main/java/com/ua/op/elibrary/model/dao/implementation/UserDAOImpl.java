package com.ua.op.elibrary.model.dao.implementation;

import com.ua.op.elibrary.model.connection.HikariCPDataSource;
import com.ua.op.elibrary.model.dao.UserDAO;
import com.ua.op.elibrary.model.entities.User;
import com.ua.op.elibrary.model.entities.enums.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.ua.op.elibrary.model.dao.constants.SQL.*;
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
                userList.add(createUser(rs));
            }
        }
        return userList;
    }

    public List<User> getAllByRoleID(int roleId) throws SQLException {
        List<User> userList = new ArrayList<>();
        try (Connection con = HikariCPDataSource.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery(SELECT_ALL_USERS + " WHERE user_role_id = " + roleId)) {
            while (rs.next()) {
                userList.add(createUser(rs));
            }
        }
        return userList;
    }

    @Override
    public void update(User user) throws SQLException {
        try (Connection con = HikariCPDataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_USER)) {
            setFieldsToPSUpdateUser(user, ps);
            ps.setLong(5, user.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }

    }

    @Override
    public void delete(long id) throws SQLException {
        try (Connection con = HikariCPDataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE_USER)) {
            ps.setLong(1, id);
            ps.execute();
        }
    }

    private static void setFieldsToPSUpdateUser(User user, PreparedStatement ps) throws SQLException {
        int k = 0;
        ps.setString(++k, user.getUserEmail());
        ps.setString(++k, user.getUserPhoneNumber());
        ps.setString(++k, user.getUserFirstname());
        ps.setString(++k, user.getUserLastname());
    }

    private static void setFieldsToPS(User user, PreparedStatement ps) throws SQLException {
        int k = 0;
        ps.setString(++k, user.getUserEmail());
        ps.setString(++k, user.getUserPassword());
        ps.setString(++k, user.getUserPhoneNumber());
        ps.setString(++k, user.getUserFirstname());
        ps.setString(++k, user.getUserLastname());
        ps.setInt(++k, user.getUserRole());
        ps.setBoolean(++k, user.isBlocked());
    }

    /**
     * The utility method that creates the user populates all the fields from the result set and returns it.
     */
    protected static User createUser(ResultSet rs) throws SQLException {

        return User.builder().
                userId(rs.getInt(USER_ID)).
                userEmail(rs.getString(USER_EMAIL)).
                userPassword(rs.getString(USER_PASSWORD)).
                userPhoneNumber(rs.getString(USER_PHONE_NUMBER)).
                userFirstname(rs.getString(USER_FIRSTNAME)).
                userLastname(rs.getString(USER_LASTNAME)).
                userRole((rs.getInt(USER_ROLE_ID))).
                isBlocked(rs.getBoolean(USER_IS_BLOCKED)).
                build();
    }
}
