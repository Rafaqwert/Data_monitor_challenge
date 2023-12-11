package data.monitor;

import data.monitor.dataBase.connector.Database;
import data.monitor.dataBase.connector.H2Connector;
import data.monitor.dataBase.connector.MySqlConnector;
import data.monitor.dataBase.enviroment.DataEnviroment;
import data.monitor.dataBase.enviroment.H2Enviroment;
import data.monitor.dataBase.enviroment.MySqlEnviroment;

import java.util.Scanner;

public class Display {

    private final static Scanner scan = new Scanner(System.in);

    public static void setEnviroment(){
        Integer option;
        DataEnviroment dataEnviroment;
        do {
            System.out.println(
                    """
                    ! Choose your enviroment:
                    | 1 - H2
                    | 2 - MySQL
                    """);
            option = Integer.parseInt(scan.nextLine());
            System.out.println(option);

        } while (option != 1 && option != 2);

        switch (option){
            case 1:
                Database h2 = new H2Connector();
                dataEnviroment = new H2Enviroment();
                dataEnviroment.createEnviroment(h2.getConnection());
                break;
            case 2:
                Database mySql = new MySqlConnector();
                dataEnviroment = new MySqlEnviroment();
                dataEnviroment.createEnviroment(mySql.getConnection());
                break;
        }
    }
}
