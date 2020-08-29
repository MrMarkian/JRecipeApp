package com.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;
    @OneToOne(fetch = FetchType.EAGER)
    private Mesurements mesurements;


    public Ingredient() {

    }

    public Ingredient(String description, BigDecimal amount, Mesurements uom) {
        this.description = description;
        this.amount = amount;
        this.mesurements = uom;
    }


    public Ingredient(String description, BigDecimal amount, Mesurements uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.mesurements = uom;
        this.recipe = recipe;

    }

}
