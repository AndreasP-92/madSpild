package com.example.demo.Controller;


import com.example.demo.Models.MadspildFact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MadspildController {

    @GetMapping("/")
    public String index(Model madspildFactModel){
    return "index";
    }

    @PostMapping("/postMadspildFact")
    public String postMadspildFact(WebRequest dataFromForm){
        MadspildFact madspildFact = new MadspildFact();
        return "redirect:/";
    }
}
