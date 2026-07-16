package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseManager {
    private static final String JDBC = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/course_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        Connection conn = null;

        try {
            Class.forName(JDBC);

            conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC tidak ditemukan!");
            System.out.println(e.getMessage());

        } catch (SQLException e) {
            System.out.println("Gagal terhubung ke database!");
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
