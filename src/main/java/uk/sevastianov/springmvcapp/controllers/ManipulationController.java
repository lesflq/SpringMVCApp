package uk.sevastianov.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/greet")
@Controller
public class ManipulationController {
    @GetMapping("/exit")
    public String exit() {
        return "manipulation/exit";
    }
}
