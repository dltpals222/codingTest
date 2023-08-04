package com.test.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.example.repository.entity.JdbcUserRepository;
import com.test.example.repository.entity.MultipleUsersDTO;
import com.test.example.repository.entity.UserDTO;

import jakarta.servlet.http.HttpServletRequest;



@Controller
@RequestMapping(value="/")
public class ExampleController {

  private final JdbcUserRepository userRepository;

  public ExampleController(JdbcUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping(value = "/")
  public String showIndex(Model model){
    model.addAttribute("message", "Hello World!");
    return "index";
  }

    @GetMapping("/create")
    public String showCreateUserForm() {
        return "userCreate";
    }

    @PostMapping("/userInfo")
    public String createUsers(HttpServletRequest request) {
        Map<String, String[]> paramMap = request.getParameterMap();
    
        Map<Integer, Map<String, String>> userDataMap = new HashMap<>();
        paramMap.forEach((key, value) -> {
          if (key.startsWith("rowIndex")) { // "rowIndex"로 시작하는 키를 무시하기 위함
              return;
          }
          String[] parts = key.split("\\]\\[");
          int index = Integer.parseInt(parts[0].substring(5)); // 'data[0]' -> 0(index)
          String field = parts[1].substring(0, parts[1].length() - 1);
      
          if (!userDataMap.containsKey(index)) {
              userDataMap.put(index, new HashMap<>());
          }
      
          userDataMap.get(index).put(field, value[0]);
      });
      
    


        List<Map<String, String>> userDataList = new ArrayList<>(userDataMap.values());
        MultipleUsersDTO multipleUsersDTO = new MultipleUsersDTO(userDataList);
    
        for (UserDTO userDTO : multipleUsersDTO.getUsers()) {
          if (isNotEmptyUser(userDTO)) {
            userRepository.join(userDTO.getUserNo(), userDTO.getUserName(), userDTO.getUserID(), userDTO.getUserNumber(), userDTO.getUserDeposit(), userDTO.getUserScore());
        }
            // userRepository.join(userDTO.getUserNo(), userDTO.getUserName(), userDTO.getUserID(), userDTO.getUserNumber(), userDTO.getUserDeposit(), userDTO.getUserScore());
        }
    
        return "redirect:/";
    }
    
    private boolean isNotEmptyUser(UserDTO user) {
      Long userNo = user.getUserNo();
      String userName = user.getUserName();
      String userID = user.getUserID();
      Long userNumber = user.getUserNumber();
      Long userDeposit = user.getUserDeposit();
      Integer userScore = user.getUserScore();
      
      return (userNo != null) &&
            (userName != null && !userName.trim().isEmpty()) &&
            (userID != null && !userID.trim().isEmpty()) &&
            (userNumber != null) &&
            (userDeposit != null) &&
            (userScore != null);
  }
    

  }
