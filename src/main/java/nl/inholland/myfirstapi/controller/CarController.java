package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Car;
import nl.inholland.myfirstapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
@RequestMapping("cars")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.status(200).body(carService.getCars());
    }
    @RequestMapping(value = "sortedcars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<List<Car>> getSortedCarPrice(){
        return ResponseEntity.status(200).body(carService.getSortedCars());
    }
    @RequestMapping(value = "filterbrandbmw", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> filterCarBMW(){
        return  ResponseEntity.status(200).body(carService.filterBrandBMW());
    }

    @RequestMapping(value = "filterbrandmercedes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> filterCarMercedes(){
        return  ResponseEntity.status(200).body(carService.filterBrandMercedes());
    }
}
