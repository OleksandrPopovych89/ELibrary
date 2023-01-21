package com.ua.op.model.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static com.ua.op.model.connection.PropertiesConstants.*;


public class HikariCPDataSource {

    private static final HikariDataSource dataSource;
    private static final HikariConfig config = new HikariConfig();

    static {
        Properties properties = getProperties();
        config.setJdbcUrl(properties.getProperty(PropertiesConstants.DB_URL));
        config.setUsername(properties.getProperty(DB_USERNAME));
        config.setPassword(properties.getProperty(DB_PASSWORD));
        config.setDriverClassName(properties.getProperty(DB_DRIVER_CLASS));
        config.addDataSourceProperty(CACHE_PREPARED_STATEMENT, properties.getProperty(CACHE_PREPARED_STATEMENT));
        config.addDataSourceProperty(CACHE_SIZE, properties.getProperty(CACHE_SIZE));
        config.addDataSourceProperty(CACHE_SQL_LIMIT, properties.getProperty(CACHE_SQL_LIMIT));
        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream resource = HikariCPDataSource.class.getClassLoader().getResourceAsStream(PROPERTIES_WAY)) {
            properties.load(resource);
        } catch (IOException e) {
        }
        return properties;
    }
}