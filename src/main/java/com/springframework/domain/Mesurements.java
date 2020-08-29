package com.springframework.domain;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
public class Mesurements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;


}
