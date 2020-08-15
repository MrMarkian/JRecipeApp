package com.springframework.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Catagory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

   // @ManyToMany(mappedBy = "catagories")
  //  private Set<Recipe> recipes;

}
