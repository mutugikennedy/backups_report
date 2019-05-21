package com.backup.reports.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    public static Connection getConnection(){


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql:localhost:3360/backup_records","root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }
}
