package bulbash77.milkintake.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import static bulbash77.milkintake.db.Config;

public class MySqlConnection {//extends Config {
    static Connection con;
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        //строка подключения к БД MySQL jdbc:mysql://localhost:3306/milk_intake
        String connectionString = "jdbc:mysql://"+
                Config.getProperty(Config.dbHost)+":"+Config.getProperty(Config.dbPort)+"/"+Config.getProperty(Config.dbName);
        //... что-то вроди инициализации драйвера jdbs для MySQL
        Class.forName("com.mysql.jdbc.Driver");
        con =DriverManager.getConnection(connectionString, Config.getProperty(Config.dbUser), Config.getProperty(Config.dbPassw));
        return con;
    }
}
