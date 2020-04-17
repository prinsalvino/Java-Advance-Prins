package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Car;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;

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
        Collections.sort(cars,(c1,c2)-> (int) (c1.getPrice() - c2.getPrice()));
        return cars;
    }

    public Car filterBrand(){
        Predicate<Car> c = s -> s.getBrand() == "BMW";
        boolean bmw = c.test(cars.get(0));
        Car car;
        if (bmw){
             car = cars.get(0);
        }
        else{
             car = cars.get(2);
        }
        return  car;
    }
}
