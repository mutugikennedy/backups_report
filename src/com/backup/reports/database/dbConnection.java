package com.backup.reports.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    Connection connection;


    public dbConnection() {
        this.connection = dbConnection.getConnection();

        if (this.connection == null) {
            System.out.println("Not connected");
        }
    }

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/backup_records","root", "");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }

    public boolean isDatabaseConnected(){
        return  this.connection != null;
    }
}
