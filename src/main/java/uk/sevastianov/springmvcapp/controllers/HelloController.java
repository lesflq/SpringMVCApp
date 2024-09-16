package uk.sevastianov.springmvcapp.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/greet")
@Controller
public class HelloController {

    @GetMapping("/hello-world")
    public String sayHello(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname,
                           Model model) {
        System.out.println("Hello " + name + " " + surname);
        model.addAttribute("firstMesage", "Hello " + name + " " + surname);
        return "greetings/hello_world";
    }

    @GetMapping("/goodbye")
    public String sayBye(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("Bye " + name);
        return "greetings/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model) {
        double result = 0;
        switch (action) {
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / b;
                break;
            default: result = 0;
        }
        model.addAttribute("result", "Result of "+action+" is "+result);

        return "greetings/calculator";
    }
}
