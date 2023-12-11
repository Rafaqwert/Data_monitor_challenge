package data.monitor.dataBase.enviroment;

import data.monitor.CategoryEnum;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySqlEnviroment extends DataEnviroment{

    @Override
    public void createEnviroment(JdbcTemplate con) {

        con.execute("""
                CREATE TABLE IF NOT EXISTS tb_category (
                	category_id INT PRIMARY KEY NOT NULL,
                    category_type VARCHAR(50),
                    measure_unit VARCHAR(10)
                );
                """
        );

        con.execute("""
                CREATE TABLE IF NOT EXISTS tb_register (
                    register_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                    register_value DECIMAL(10,2),
                    date_time DATETIME NOT NULL DEFAULT(NOW()),
                    fk_category INT NOT NULL,
                    FOREIGN KEY (fk_category) REFERENCES tb_category(category_id)
                );
                """
        );

        con.update("""
                INSERT IGNORE INTO tb_category VALUES
                  (?, ?, ?),
                  (?, ?, ?),
                  (?, ?, ?),
                  (?, ?, ?);
                """,

                    CategoryEnum.CPU_USAGE.getCategoryId(),
                        CategoryEnum.CPU_USAGE.name(),
                        CategoryEnum.CPU_USAGE.getMeasureUnit(),

                    CategoryEnum.RAM_USAGE.getCategoryId(),
                        CategoryEnum.RAM_USAGE.name(),
                        CategoryEnum.RAM_USAGE.getMeasureUnit(),

                    CategoryEnum.DISK_USAGE.getCategoryId(),
                        CategoryEnum.DISK_USAGE.name(),
                        CategoryEnum.DISK_USAGE.getMeasureUnit(),

                    CategoryEnum.DISK_STORAGE.getCategoryId(),
                        CategoryEnum.DISK_STORAGE.name(),
                        CategoryEnum.DISK_STORAGE.getMeasureUnit()

        );
    }
}
