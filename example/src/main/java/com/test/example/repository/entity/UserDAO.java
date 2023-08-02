package com.test.example.repository.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.test.example.DBConn;

public class UserDAO {
  public int join(String userName, String userID, String userNumber, String userDeposit, String userScore) {
    String QueryC = "INSERT INTO users_score VALUES (?,?,?,?,?)";
    try {
      Connection conn = DBConn.getConnection();
      PreparedStatement pstmt = conn.prepareStatement(QueryC);
      pstmt.setString(1, userName);
      pstmt.setString(2, userID);
      pstmt.setString(3, userNumber);
      pstmt.setString(4, userDeposit);
      pstmt.setString(5, userScore);
      return pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return -1;
  }
}
