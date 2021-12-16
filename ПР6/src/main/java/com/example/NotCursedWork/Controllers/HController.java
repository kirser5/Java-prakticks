package com.example.NotCursedWork.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HController {
    @GetMapping("/")
    public String HomeCon(Model model){
        return "home";
    }

    @GetMapping("/index")
    public String HomeController(Model model){
        return "home";
    }
}