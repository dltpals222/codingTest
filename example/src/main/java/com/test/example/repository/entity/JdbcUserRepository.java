package com.test.example.repository.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.test.example.DBConn;
import com.test.example.repository.UserDAORepository;


@Repository
public class JdbcUserRepository implements UserDAORepository {
  @Override
  public int join(String userName, String userID, Long userNumber,Long userDeposit, Integer userScore) {
  String QueryC = "INSERT INTO users_score (  name, user_id, number,deposit, score) VALUES (?,?,?,?,?)";
  try (Connection conn = DBConn.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(QueryC)) {
    pstmt.setString(1, userName);
    pstmt.setString(2, userID);
    pstmt.setLong(3, userNumber);
    pstmt.setLong(4, userDeposit);
    pstmt.setInt(5, userScore);
    return pstmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1;
  }
}
