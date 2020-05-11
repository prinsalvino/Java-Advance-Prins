package nl.inholland.myfirstapi.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
class CarTest {
    Car car;

    @BeforeEach
    void setup(){
        car = new Car(1L,"BMW","M3",90000);
    }
    @Test
    private void CreateCarNotNull(){
        assertNotNull(car);
    }
    @Test
    void NegativePriceShouldGiveException(){
        Assertions.assertThrows(IllegalArgumentException.class,()->car.setPrice(-1));
    }
}