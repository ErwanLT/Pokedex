package fr.eletutour.pokedex.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class Evolution {
    private List<EvolutionStep> pre;
    private List<EvolutionStep> next;
    private List<MegaEvolution> mega;
}
