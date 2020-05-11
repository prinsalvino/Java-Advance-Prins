package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Car;
import nl.inholland.myfirstapi.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    CarService carService;

    Car car;


    @BeforeEach
    void setup(){
        car = new Car(1L,"BMW","M3",90000);
    }

    @Test
    void callingAllCarsShouldReturnJSONArray() throws Exception {
        List<Car> allCars = Arrays.asList(car);
        given(carService.getCars()).willReturn((List<Car>) allCars);

        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].brand").value(car.getBrand()));
    }
}