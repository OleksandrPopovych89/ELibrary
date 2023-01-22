package com.ua.op.elibrary.model.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class HikariCPDataSource {

    private static final HikariDataSource dataSource;
    private static final HikariConfig config = new HikariConfig();

    static {
        Properties properties = getProperties();
        config.setJdbcUrl(properties.getProperty(PropertiesConstants.DB_URL));
        config.setUsername(properties.getProperty(PropertiesConstants.DB_USERNAME));
        config.setPassword(properties.getProperty(PropertiesConstants.DB_PASSWORD));
        config.setDriverClassName(properties.getProperty(PropertiesConstants.DB_DRIVER_CLASS));
        config.addDataSourceProperty(PropertiesConstants.CACHE_PREPARED_STATEMENT, properties.getProperty(PropertiesConstants.CACHE_PREPARED_STATEMENT));
        config.addDataSourceProperty(PropertiesConstants.CACHE_SIZE, properties.getProperty(PropertiesConstants.CACHE_SIZE));
        config.addDataSourceProperty(PropertiesConstants.CACHE_SQL_LIMIT, properties.getProperty(PropertiesConstants.CACHE_SQL_LIMIT));
        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream resource = HikariCPDataSource.class.getClassLoader().getResourceAsStream(PropertiesConstants.PROPERTIES_WAY)) {
            properties.load(resource);
        } catch (IOException e) {
        }
        return properties;
    }
}