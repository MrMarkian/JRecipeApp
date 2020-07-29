package com.springframework.Controllers;

import com.springframework.domain.Catagory;
import com.springframework.domain.Mesurements;
import com.springframework.domain.repositories.CatagoryRepository;
import com.springframework.domain.repositories.MeasurementsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class IndexController {

    private final CatagoryRepository catagoryRepository;
    private final MeasurementsRepository measurementsRepository;

    public IndexController(CatagoryRepository catagoryRepository, MeasurementsRepository measurementsRepository) {
        this.catagoryRepository = catagoryRepository;
        this.measurementsRepository = measurementsRepository;
    }




    @RequestMapping ({"","/","/index"})
    public String getIndexPage(){

        Optional<Catagory> catagoryOptional = catagoryRepository.findByDescription("American");
        Optional<Mesurements> mesurementsOptional = measurementsRepository.findByUnitOfMeasure("Kg");

        if(catagoryOptional.isPresent()){
        System.out.println("Cat Id is:" + catagoryOptional.get().getId());}


        System.out.println("Measurements ID is:" + mesurementsOptional.get().getId());

        return "index";
    }
}
