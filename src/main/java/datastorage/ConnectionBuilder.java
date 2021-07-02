package datastorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {
    private static Connection conn;

    private ConnectionBuilder() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            String working_dir = System.getProperty("user.dir");
            System.out.println("Working Directory = " + working_dir);

            conn = DriverManager.getConnection("jdbc:hsqldb:" + working_dir + "/db/nursingHomeDB;user=SA;password=SA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Treiberklasse konnte nicht gefunden werden!");
        } catch (SQLException e) {
            System.out.println("Verbindung zur Datenbank konnte nicht aufgebaut werden!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (conn == null) {
            new ConnectionBuilder();
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
