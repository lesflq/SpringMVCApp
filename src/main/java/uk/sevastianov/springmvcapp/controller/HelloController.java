package uk.sevastianov.springmvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello-world")
    @ResponseBody
    public String sayHello() {
        System.out.println("\n----------------");
        return "hello_world";
    }
}
