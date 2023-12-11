package data.monitor.dataBase.enviroment;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class DataEnviroment {

    public abstract void createEnviroment(JdbcTemplate con);
}
