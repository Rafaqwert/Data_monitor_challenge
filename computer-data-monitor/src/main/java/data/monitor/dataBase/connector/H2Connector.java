package data.monitor.dataBase.connector;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class H2Connector extends Database {

    public H2Connector() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:h2:file:./dataMonitor");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        this.setConnection(new JdbcTemplate(dataSource));
    }
}


