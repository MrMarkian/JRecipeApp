package com.springframework.commands;

import com.springframework.domain.Difficulty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class RecipeCommand {

    private Long id;
    private String description;
    private Integer preptime;
    private Integer cooktime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientsCommand> ingredientsCommandSet = new HashSet<>();
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CatagoryCommand> catagoryCommands = new HashSet<>();

}
