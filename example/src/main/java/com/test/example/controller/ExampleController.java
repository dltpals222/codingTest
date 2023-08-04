package com.test.example.controller;

import com.test.example.repository.UsersRepository;
import com.test.example.repository.entity.MultipleUsersDTO;
import com.test.example.repository.entity.UserDTO;
import com.test.example.repository.entity.UsersScore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExampleController {

    private final UsersRepository usersRepository;

    public ExampleController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
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
            if (key.startsWith("rowIndex")) {
                return;
            }
            String[] parts = key.split("\\]\\[");
            int index = Integer.parseInt(parts[0].substring(5));
            String field = parts[1].substring(0, parts[1].length() - 1);

            if (!userDataMap.containsKey(index)) {
                userDataMap.put(index, new HashMap<>());
            }

            userDataMap.get(index).put(field, value[0]);
        });

        List<Map<String, String>> userDataList = new ArrayList<>(userDataMap.values());
        MultipleUsersDTO multipleUsersDTO = new MultipleUsersDTO(userDataList);

        try {
            for (UserDTO userDTO : multipleUsersDTO.getUsers()) {
                if (isNotEmptyUser(userDTO)) {
                    UsersScore newUserScore = UsersScore.builder()
                            .name(userDTO.getUserName())
                            .number(userDTO.getUserNumber())
                            .userId(userDTO.getUserID())
                            .deposit(userDTO.getUserDeposit())
                            .score(userDTO.getUserScore())
                            .build();

                    usersRepository.save(newUserScore);
                }
            }
            return "redirect:/";
        } catch (Exception e) {
            System.err.println("유저정보값을 입력하는데 에러가 발생했습니다. : " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("원인 : " + e.getCause().getMessage());
            }
            e.printStackTrace();
            return "error";
        }
    }

    private boolean isNotEmptyUser(UserDTO user) {
        return user.getUserName() != null && !user.getUserName().trim().isEmpty() &&
                user.getUserNumber() != null &&
                user.getUserID() != null && !user.getUserID().trim().isEmpty() &&
                user.getUserDeposit() != null;
    }
}
