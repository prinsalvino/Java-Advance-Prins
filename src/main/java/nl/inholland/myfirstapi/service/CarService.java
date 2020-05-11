package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Car;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
@Service
public class CarService {
    List<Car> cars;

    public CarService() {
        cars = Arrays.asList(
                new Car(1l, "BMW", "i8", 164000),
                new Car(2l, "BMW", "320i", 48000),
                new Car(3l, "Mercedes", "CLA200", 40000)
        );
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getSortedCars(){
        List<Car> sortedCars = cars.stream().collect(Collectors.toList());
        Collections.sort(sortedCars,(c1,c2)-> (int) (c1.getPrice() - c2.getPrice()));
        return sortedCars;
    }

    public List<Car> filterBrandBMW(){
        Predicate<Car> p = c -> c.getBrand().equals("BMW");
        List<Car> listBMW = cars.stream().filter(p).collect(Collectors.toList());
        return  listBMW;
    }

    public List<Car> filterBrandMercedes(){
        Predicate<Car> p = c -> c.getBrand().equals("Mercedes");
        List<Car> listMercedes = cars.stream().filter(p).collect(Collectors.toList());
        return  listMercedes;
    }
}
