package fr.eletutour.pokedex.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sprites {
    private String regular;
    private String shiny;
    private GmaxSprites gmax;
}
