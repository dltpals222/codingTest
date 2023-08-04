package com.test.example.repository.entity;

public class UserDTO {
  private Long userNo;
  private String userName;
  private String userID;
  private Long userNumber;
  private Long userDeposit;
  private Integer userScore;
  
  // user정보 userNo의 getter setter
  public Long getUserNo() {
    return userNo;
  }
  public void setUserNo(Long userNo) {
    this.userNo = userNo;
  }

  // user정보 name의 getter setter
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  // user정보 ID의 getter setter
  public String getUserID() {
    return userID;
  }
  public void setUserID(String userID) {
    this.userID = userID;
  }
  
  // user정보 Number의 getter setter
  public Long getUserNumber() {
    return userNumber;
  }
  public void setUserNumber(Long userNumber) {
    this.userNumber = userNumber;
  }
  
  // user정보 Deposit의 getter setter
  public Long getUserDeposit() {
    return userDeposit;
  }
  public void setUserDeposit(Long userDeposit) {
    this.userDeposit = userDeposit;
  }
  
  // user정보 Score의 getter setter
  public Integer getUserScore() {
    return userScore;
  }
  public void setUserScore(Integer userScore) {
    this.userScore = userScore;
  }
}
