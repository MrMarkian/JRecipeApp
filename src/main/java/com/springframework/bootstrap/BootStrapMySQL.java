package com.springframework.bootstrap;

import com.springframework.domain.Catagory;
import com.springframework.domain.Mesurements;
import com.springframework.repositories.CatagoryRepository;
import com.springframework.repositories.MeasurementsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev","prod"})
public class BootStrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

    private final CatagoryRepository catagoryRepository;
    private final MeasurementsRepository measurementsRepository;

    public BootStrapMySQL(CatagoryRepository catagoryRepository, MeasurementsRepository measurementsRepository) {
        this.catagoryRepository = catagoryRepository;
        this.measurementsRepository = measurementsRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (catagoryRepository.count() == 0L){

            log.debug("No Catagories Found - Loading Defaults");
            loadCatagories();
           }

        if(measurementsRepository.count() == 0L){
            log.debug("No Measurments Found - Loading Defaults");
            loadMeasurements();
        }

    }

    private void loadMeasurements() {
        Mesurements mesurements1 = new Mesurements();
        mesurements1.setDescription("Tea Spoon");
        measurementsRepository.save(mesurements1);

        Mesurements mesurements2 = new Mesurements();
        mesurements2.setDescription("Table Spoon");
        measurementsRepository.save(mesurements2);

        Mesurements mesurements3 = new Mesurements();
        mesurements3.setDescription("Pint");
        measurementsRepository.save(mesurements3);

        Mesurements mesurements4 = new Mesurements();
        mesurements4.setDescription("ml");
        measurementsRepository.save(mesurements4);

        Mesurements mesurements5 = new Mesurements();
        mesurements5.setDescription("Grams");
        measurementsRepository.save(mesurements5);

        Mesurements mesurements6 = new Mesurements();
        mesurements6.setDescription("Kilograms");
        measurementsRepository.save(mesurements6);

        Mesurements mesurements7 = new Mesurements();
        mesurements7.setDescription("Pinch");
        measurementsRepository.save(mesurements7);

        Mesurements mesurements8 = new Mesurements();
        mesurements8.setDescription("Each");
        measurementsRepository.save(mesurements8);

        Mesurements measurements9 = new Mesurements();
        measurements9.setDescription("Dash");
        measurementsRepository.save(measurements9);
    }

    private void loadCatagories() {
        Catagory catagory1 = new Catagory();
        catagory1.setDescription("American");
        catagoryRepository.save(catagory1);

        Catagory catagory2 = new Catagory();
        catagory2.setDescription("Mexican");
        catagoryRepository.save(catagory2);

        Catagory catagory3 = new Catagory();
        catagory3.setDescription("Brittish");
        catagoryRepository.save(catagory3);

        Catagory catagory4 = new Catagory();
        catagory4.setDescription("Ukrainian");
        catagoryRepository.save(catagory4);

        Catagory catagory5 = new Catagory();
        catagory5.setDescription("Brazilian");
        catagoryRepository.save(catagory5);

        Catagory catagory6 = new Catagory();
        catagory6.setDescription("Indian");
        catagoryRepository.save(catagory6);

        Catagory catagory7 = new Catagory();
        catagory7.setDescription("Chinese");
        catagoryRepository.save(catagory7);
    }
}
