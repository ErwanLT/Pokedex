package fr.eletutour.pokedex.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stats {
    private int hp;
    private int atk;
    private int def;
    private int spe_atk;
    private int spe_def;
    private int vit;
}
