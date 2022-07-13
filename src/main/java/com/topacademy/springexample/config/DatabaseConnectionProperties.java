package com.topacademy.springexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class DatabaseConnectionProperties {

    public static String url;
    private static String userName;
    private static String password;

    @Autowired
    public DatabaseConnectionProperties(@Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String userName,
                                        @Value("${spring.datasource.password}") String password) {
        DatabaseConnectionProperties.url = url;
        DatabaseConnectionProperties.userName = userName;
        DatabaseConnectionProperties.password = password;
    }

    public static Properties getConnectionProps() {
        Properties props = new Properties();
        props.setProperty("user", userName);
        props.setProperty("password", password);
        return props;
    }
}
