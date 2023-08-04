package com.test.example.repository;

public interface UserDAORepository {
  int join(Long userNo,String userName, String userID, Long userNumber,
  Long userDeposit, Integer userScore);
}
