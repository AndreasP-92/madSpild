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

    @GetMapping("/omos")
    public String omOs(Model madspildFactModel){
        return "omOs";
    }

    @PostMapping("/postMadspildFact")
    public String postMadspildFact(WebRequest dataFromForm){
        String foodKG          = (dataFromForm.getParameter("test"));
        String price           = (dataFromForm.getParameter("test"));
        String wastePerWeek    = (dataFromForm.getParameter("test"));

        MadspildFact madspildFact = new MadspildFact(22,22,22);

        return "redirect:/";
    }
}
