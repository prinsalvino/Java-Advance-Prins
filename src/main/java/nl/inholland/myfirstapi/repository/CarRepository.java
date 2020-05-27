package nl.inholland.myfirstapi.repository;

import nl.inholland.myfirstapi.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

}
