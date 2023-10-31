package com.scaler.reviewratingservice.healthcheckup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomHealthIndicator implements HealthIndicator {

    @Value("{$spring.datasource.url}")
    private String url;

    @Value("{$spring.datasource.username}")
    private String username;

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        if (databaseIsUp())
            return Health.up().withDetail("message","Database is up").build();

        return Health.down().withDetail("message", "Database is down").build();
    }

    private boolean databaseIsUp() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, null);
            return true;

        } catch (SQLException e) {
            return false;

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
