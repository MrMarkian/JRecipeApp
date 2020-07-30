package com.springframework.Controllers;

import com.springframework.domain.Catagory;
import com.springframework.domain.Mesurements;
import com.springframework.domain.repositories.CatagoryRepository;
import com.springframework.domain.repositories.MeasurementsRepository;
import com.springframework.services.RecipieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class IndexController {


    private final RecipieService recipieService;

    public IndexController(RecipieService recipieService) {
        this.recipieService = recipieService;
    }

    @RequestMapping ({"","/","/index"})
    public String getIndexPage(Model model){

       model.addAttribute("recipes", recipieService.getRecipes());

        return "index";
    }
}
