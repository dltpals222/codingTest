package com.test.example.repository;

public interface UserDAORepository {
  int join(String userName, String userID, Long userNumber,
  Long userDeposit, Integer userScore);
}
