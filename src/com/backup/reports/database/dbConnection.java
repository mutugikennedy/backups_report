package com.backup.reports.database;

import com.backup.reports.util.ReadConfigFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class dbConnection {

    Connection connection;
    private String url;
    private Map<String, String> dbConfigInfo;
    private String user = "root";
    private String password;




    public dbConnection() {
        this.dbConfigInfo = new ReadConfigFile().readDbConfigFile();
        this.url = "jdbc:mysql://" +dbConfigInfo.get("host") +"/" + dbConfigInfo.get("dbname");
        this.password = dbConfigInfo.get("password");

        this.connection =  getConnection();
        //System.out.println(this.url +""+ password);

    }

    private  Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(this.url, this.user, this.password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isDatabaseConnected(){
        return  this.connection != null;
    }
}
