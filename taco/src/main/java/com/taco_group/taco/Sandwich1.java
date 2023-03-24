package com.taco_group.taco;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import java.util.ArrayList;
import java.util.List;
@Data
public class Sandwich1 {
    @NotBlank
    private String deliveryStreet;

    @NotBlank
    private String deliveryName;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Формат MM/YY")
    private String ccExpiration;

    @NotBlank
    private String deliveryCity;

    @CreditCardNumber
    private String ccNumber;

    @Digits(integer=3, fraction=0)
    private String ccCVV;
    private List<Sandwich> sandwiches = new ArrayList<>();

    public void addSandwich(Sandwich sandwich){
        this.sandwiches.add(sandwich);
    }
}