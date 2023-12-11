package data.monitor.dataBase.connector;

import data.monitor.dataBase.connector.Database;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySqlConnector extends Database {

    public MySqlConnector() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dataMonitor");
        dataSource.setUsername("adm_1");
        dataSource.setPassword("urubu100");

        this.setConnection(new JdbcTemplate(dataSource));
    }
}
