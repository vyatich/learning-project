package com.topacademy.springexample.dao;

import com.topacademy.springexample.config.DatabaseConnectionProperties;
import com.topacademy.springexample.entity.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.topacademy.springexample.config.DatabaseConnectionProperties.url;

@Repository
public class CurrencyDaoImpl implements CurrencyDao {

    private static final Logger log = LoggerFactory.getLogger(CurrencyDaoImpl.class);

    private static Connection connection;

    @Autowired
    private DatabaseConnectionProperties databaseConnectionProperties;

    @PostConstruct
    public void initialize() {
        try {
            connection = DriverManager.getConnection(url, databaseConnectionProperties.getConnectionProps());
        } catch (SQLException e) {
            log.debug("Incorrect database URL '{}' or connection props '{}'", url, databaseConnectionProperties.getConnectionProps());
        }
    }

    @PreDestroy
    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Currency> getAll() {
        return getCurrencyListByColumnNameAndValue("dt", LocalDate.of(2019, 10, 31));
    }

    private static List<Currency> getCurrencyListByColumnNameAndValue(String columnName, Object value) {
        String getQuery = "SELECT * FROM currency_dynamics WHERE " + columnName + " = ?";
        List<Currency> currencies = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(getQuery)) {
            preparedStatement.setObject(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Currency currency = new Currency(resultSet.getString(1), resultSet.getDate(2).toLocalDate(), resultSet.getDouble(3));
                currencies.add(currency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currencies;
    }
}
