package fr.eletutour.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EvolutionStep {
    @JsonProperty("pokedex_id")
    private int pokedexId;
    private String name;
    private String condition;
}
