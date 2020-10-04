package com.example.demo.Controller;

import com.example.demo.Models.MadspildFact;
import com.example.demo.Models.PersonFact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MadspildController {

//    Madspild Udregner Object
    MadspildFact fact;


//    ******************************** Persons in Array ********************************
    public static List<PersonFact> data () {

        List<PersonFact> personArray = new ArrayList<>();


//    ================================= ANDREAS
        String nameAnd             = "Andreas Pedersen";
        String imgAnd              = "/image/Andreas.jpg";
        String textAnd             = " Andreas's Primære fokus er softwareudvikling og systemintegrationer.\n" +
                "                   Med mine kompetencer og erfaringer, kan jeg hjælpe dig med at finde den helt rigtige softwareløsning.\n" +
                "\n" +
                "                   Udgangspunkts i dine krav, analyserer,designer og programmerer jeg din unikke softwareløsning.\n" +
                "\n" +
                "                   <br><br><h11 class=\"titel\">Software</h11>\n" +
                "                   <br>UI/UX - Design, Prototying, Usability testing, System design, Software arkiteturer, API og Servicedesign, Agil projektstyring med Scrum\n" +
                "\n" +
                "                   <br><br><h12 class=\"titel\">Programmering</h12>\n" +
                "                   <br>Jeg har de rette kompetencer, og er ekspert når det drejer sig om programmering.\n" +
                "\n" +
                "                   <br><br>Windows brugerflader, Webbrugerflader, Mobile apps, Server applikationer, Windows og Web Services, Databaser og DBMS, Microsoft Office udvidelser, System integrationer.";

        PersonFact andreasObj   = new PersonFact(nameAnd, textAnd, imgAnd);


        //    ================================= JEFFREY
        String nameJef              ="Jeffrey Oechsner";
        String imgJef               ="/image/Jeffrey.jpg";
        String textJef              = "Jeffrey's Primære fokus er softwareudvikling og systemintegrationer.\n" +
                "                   Med mine kompetencer og erfaringer, kan jeg hjælpe dig med at finde den helt rigtige softwareløsning.\n" +
                "\n" +
                "                   Udgangspunkts i dine krav, analyserer,designer og programmerer jeg din unikke softwareløsning.\n" +
                "\n" +
                "                   <br><br><h11 class=\"titel\">Software</h11>\n" +
                "                   <br>UI/UX - Design, Prototying, Usability testing, System design, Software arkiteturer, API og Servicedesign, Agil projektstyring med Scrum\n" +
                "\n" +
                "                   <br><br><h12 class=\"titel\">Programmering</h12>\n" +
                "                   <br>Jeg har de rette kompetencer, og er ekspert når det drejer sig om programmering.\n" +
                "\n" +
                "                   <br><br>Windows brugerflader, Webbrugerflader, Mobile apps, Server applikationer, Windows og Web Services, Databaser og DBMS, Microsoft Office udvidelser, System integrationer.";

        PersonFact jeffreyObj   = new PersonFact(nameJef, textJef, imgJef);
//    ================================= TOBIAS
        String nameTob              ="Tobias Cho";
        String imgTob               ="/image/Tobias.jpg";
        String textTob              = "Tobias's Primære fokus er softwareudvikling og systemintegrationer.\n" +
                "                   Med mine kompetencer og erfaringer, kan jeg hjælpe dig med at finde den helt rigtige softwareløsning.\n" +
                "\n" +
                "                   Udgangspunkts i dine krav, analyserer,designer og programmerer jeg din unikke softwareløsning.\n" +
                "\n" +
                "                   <br><br><h11 class=\"titel\">Software</h11>\n" +
                "                   <br>UI/UX - Design, Prototying, Usability testing, System design, Software arkiteturer, API og Servicedesign, Agil projektstyring med Scrum\n" +
                "\n" +
                "                   <br><br><h12 class=\"titel\">Programmering</h12>\n" +
                "                   <br>Jeg har de rette kompetencer, og er ekspert når det drejer sig om programmering.\n" +
                "\n" +
                "                   <br><br>Windows brugerflader, Webbrugerflader, Mobile apps, Server applikationer, Windows og Web Services, Databaser og DBMS, Microsoft Office udvidelser, System integrationer.";


        PersonFact tobiasObj    = new PersonFact(nameTob, textTob, imgTob);

        personArray.add(andreasObj);
        personArray.add(jeffreyObj);
        personArray.add(tobiasObj);



        return personArray;
    }




// ========================================== GET INDEX =====================================
    @GetMapping("/")
    public String index(Model MadSpildController){
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

    // ========================================== GET OMOS =====================================

    @GetMapping("/omos")
    public String omOs(Model PersonFact){

//        data();



        PersonFact.addAttribute("person", data());

        return "omOs";
    }
// ========================================== POST INDEX =====================================

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
