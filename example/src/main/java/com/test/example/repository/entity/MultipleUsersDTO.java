package com.test.example.repository.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MultipleUsersDTO {
    private List<UserDTO> users;

    public MultipleUsersDTO(List<Map<String, String>> rawData) {
        this.users = new ArrayList<>();
        rawData.forEach(data -> {
            UserDTO user = new UserDTO();
            user.setUserNo (convertToLong(data.get("userNo")));
            user.setUserName(data.get("name"));
            user.setUserID(data.get("userId")); 
            user.setUserNumber(convertToLong(data.get("number")));
            user.setUserDeposit(convertToLong(data.get("deposit")));
            user.setUserScore(convertToInteger(data.get("score")));
            users.add(user);
        });
    }

    private Long convertToLong(String value) {
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Integer convertToInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public List<UserDTO> getUsers() {
        return users;
    }
}
