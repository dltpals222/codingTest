package com.test.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBReadTest {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      // 데이터베이스 연결
      conn = DBConn.getConnection();

      // 간단한 조회 쿼리 실행
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT * FROM users_score");

      // 결과 출력
      while (rs.next()) {
        System.out.println("id: " + rs.getString("id"));
        System.out.println("name: " + rs.getString("name"));
        System.out.println("number: " + rs.getString("number"));
        System.out.println("deposit: " + rs.getString("deposit"));
        System.out.println("score: " + rs.getString("score"));
        System.out.println("userId: " + rs.getString("user_id"));
        System.out.println();
      }
    } catch (SQLException e) {
      System.out.println("데이터베이스 연결 실패: " + e.getMessage());
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException ignore) {
        }
      }
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException ignore) {
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ignore) {
        }
      }
    }
  }
}
