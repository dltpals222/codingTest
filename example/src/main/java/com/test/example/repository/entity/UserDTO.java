package com.test.example.repository.entity;

public class UserDTO {
  String userName;
  String userID;
  String userNumber;
  String userDeposit;
  String userScore;
  
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
  public String getUserNumber() {
    return userNumber;
  }
  public void setUserNumber(String userNumber) {
    this.userNumber = userNumber;
  }
  
  // user정보 Deposit의 getter setter
  public String getUserDeposit() {
    return userDeposit;
  }
  public void setUserDeposit(String userDeposit) {
    this.userDeposit = userDeposit;
  }
  
  // user정보 Score의 getter setter
  public String getUserScore() {
    return userScore;
  }
  public void setUserScore(String userScore) {
    this.userScore = userScore;
  }
}
