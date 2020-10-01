package com.example.demo.Controller;


import com.example.demo.Models.MadspildFact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MadspildController {

//    MadspildFact fact = new MadspildFact(1000,100000,500);
    MadspildFact fact;


    @GetMapping("/")
    public String index(Model MadSpildController){


        String test ="test";
        if(fact != null){
            int foodKg          = fact.getFoodKg();
            int foodPrice       = fact.getPrice();
            int wasterPerWeek   = fact.getWastePerWeek();

            int pricePerKg          = foodPrice / foodKg;
            int totalWastePerWeek   = wasterPerWeek / 100 * 30;
            int total               = totalWastePerWeek * pricePerKg;

            String text01           = "Spare du ";
            String text02           = "kr om ugen";

            MadSpildController.addAttribute("elm" , total);
            MadSpildController.addAttribute("text01" , text01);
            MadSpildController.addAttribute("text02" , text02);
        }

        return "index";
    }

    @GetMapping("/omos")
    public String omOs(Model madspildFactModel){
        return "omOs";
    }

    @PostMapping("/postMadspildFact")
    public String postMadspildFact(WebRequest dataFromForm){
        String foodKG          = (dataFromForm.getParameter("foodKg"));
        String price           = (dataFromForm.getParameter("price"));
        String wastePerWeek    = (dataFromForm.getParameter("wastePerWeek"));

        int parseFoodKg         = Integer.parseInt(foodKG);
        int parsePrice          = Integer.parseInt(price);
        int parseWasterPerWeek  = Integer.parseInt(wastePerWeek);

        MadspildFact greatFact = new MadspildFact(parseFoodKg,parsePrice,parseWasterPerWeek);

        fact = greatFact;

        return "redirect:/#udregnMain";
    }
}
