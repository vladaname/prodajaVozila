package com.example.demo.controllers;


import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Test {
    @Autowired
    TestService testService;

    @GetMapping("/test")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        System.out.println("U controlleru");
        return "test";
    }

    @GetMapping("/slanjeMejla")
    public String slanjeMejla(Model model){
        testService.SlanjeMejla();
        return "test";
    }

}
