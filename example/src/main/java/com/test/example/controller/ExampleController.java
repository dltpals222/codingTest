package com.test.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ExampleController {

  @GetMapping(value = "/")
  public String showIndex(Model model){
    model.addAttribute("message", "Hello World!");
    return "index";
  }

}
