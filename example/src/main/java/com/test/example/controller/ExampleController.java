package com.test.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.example.repository.UserDAORepository;
import com.test.example.repository.entity.UserDTO;

import jakarta.servlet.http.HttpServletRequest;



@Controller
@RequestMapping(value="/")
public class ExampleController {

  private final UserDAORepository userRepository;

  public ExampleController(UserDAORepository userRepository) {
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

    @PostMapping("/create")
    public String createUsers(HttpServletRequest request) {
        List<UserDTO> users = new ArrayList<>();

        Map<String, String[]> paramMap = request.getParameterMap();
        int userCount = paramMap.size() / 6;

        for (int i = 0; i < userCount; i++) {
          Long userNo = Long.parseLong(paramMap.get("data[" + i + "][no]")[0]);
          String userName = paramMap.get("data[" + i + "][name]")[0];
          String userId = paramMap.get("data[" + i + "][id]")[0];
          Long userNumber = Long.parseLong(paramMap.get("data[" + i + "][number]")[0]);
          Long userDeposit = Long.parseLong(paramMap.get("data[" + i + "][deposit]")[0]);
          Integer userScore = Integer.parseInt(paramMap.get("data[" + i + "][score]")[0]);
  
          UserDTO userDTO = new UserDTO();
          userDTO.setUserNo(userNo);
          userDTO.setUserName(userName);
          userDTO.setUserID(userId);
          userDTO.setUserNumber(userNumber);
          userDTO.setUserDeposit(userDeposit);
          userDTO.setUserScore(userScore);
  
          users.add(userDTO);
      }
  
      for (UserDTO userDTO : users) {
          userRepository.join(userDTO.getUserNo(), userDTO.getUserName(), userDTO.getUserID(), userDTO.getUserNumber(), userDTO.getUserDeposit(), userDTO.getUserScore());
      }


        return "redirect:/"; 
    }
  }
