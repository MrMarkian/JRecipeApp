package com.springframework.commands;

import com.springframework.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Size(min = 5, max = 255)
    private String description;

    @NotNull
    @Min(1)
    @Max(999)
    private Integer preptime;
    @NotNull
    @Min(1)
    @Max(999)
    private Integer cooktime;
    @NotNull
    @Min(1)
    @Max(99)
    private Integer servings;
    private String source;
    @URL
    private String url;
    @NotBlank
    private String directions;
    private Set<IngredientsCommand> ingredientsCommandSet = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CatagoryCommand> catagoryCommands = new HashSet<>();

}
