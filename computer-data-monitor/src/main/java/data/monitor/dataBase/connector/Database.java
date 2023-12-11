package data.monitor.dataBase.connector;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class Database {
    private JdbcTemplate connection;

    public JdbcTemplate getConnection() {
        return connection;
    }

    public void setConnection(JdbcTemplate connection) {
        this.connection = connection;
    }
}
