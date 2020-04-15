package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Guitar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GuitarService {
    List<Guitar> guitars;

    public GuitarService() {
        guitars = Arrays.asList(
                new Guitar(1l, "Fender", "TelCasters", 899),
                new Guitar(2l, "Fender", "Stratocaster", 1299),
                new Guitar(3l, "Gibson", "Thunderbird", 2999)
        );
    }

    public List<Guitar> getGuitars() {
        return guitars;
    }
}
