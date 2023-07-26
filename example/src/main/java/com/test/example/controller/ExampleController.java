package com.test.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
  @GetMapping(value = "/index")
  public String home(Model model){
    model.addAttribute("test", "테스트입니다.");
    return "home";
  }

}
