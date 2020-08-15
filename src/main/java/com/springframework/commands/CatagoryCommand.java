package com.springframework.commands;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@NoArgsConstructor
public class CatagoryCommand {
    private Long id;
    private String description;
}
