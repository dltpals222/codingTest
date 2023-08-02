package com.test.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
  public static Connection getConnection() {
    try{
      String dbUrl = "jdbc:mysql://localhost:3060/users";
      String dbID = "root";
      String dbPW = "1q2w3e4r";
      Class.forName("com.mysql.cj.jdbc.Driver");
      return DriverManager.getConnection(dbUrl, dbID, dbPW);
    } catch(Exception e){
      e.printStackTrace();
    }
    return null;
  }
}
