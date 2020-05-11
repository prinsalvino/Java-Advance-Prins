package nl.inholland.myfirstapi.model;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Car {
    private long id;
    private String brand;
    private String model;
    private double price;


    public void setPrice(double price) {
        if (price < 0){
            throw new IllegalArgumentException();
        }
        this.price = price;
    }
}
