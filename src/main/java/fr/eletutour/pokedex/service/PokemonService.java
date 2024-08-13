package fr.eletutour.pokedex.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.eletutour.pokedex.model.Name;
import fr.eletutour.pokedex.model.Pokemon;
import fr.eletutour.pokedex.model.Type;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private List<Pokemon> allPokemon = new ArrayList<>();

    private Map<Integer, List<Pokemon>> pokemonByGen = new HashMap<>();

    @PostConstruct
    private void init(){
        allPokemon = loadPokemonFromJson();
    }


    public List<Pokemon> findAllPokemon(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return allPokemon;
        } else {
            return allPokemon.stream()
                    .filter(p -> StringUtils.containsIgnoreCase(p.getName().getFr(), stringFilter))
                    .toList();
        }
    }

    public Map<Integer, List<Pokemon>> getGenerations(){
        return pokemonByGen;
    }

    public Set<Type> findAllTypes() {
        return allPokemon.stream()
                .flatMap(pokemon -> pokemon.getTypes().stream())
                .sorted(new TypeComparator())
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public List<Pokemon> loadPokemonFromJson() {
        List<Pokemon> allPokemons = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            for(int i = 1; i<10; i++){
                File file = new ClassPathResource("static/gen/gen"+i+".json").getFile();
                Pokemon[] pokemonsArray = objectMapper.readValue(file, Pokemon[].class);
                var pokemonFromGen = Arrays.asList(pokemonsArray);
                pokemonByGen.put(i, pokemonFromGen);
                allPokemons.addAll(pokemonFromGen);
            }
            return allPokemons;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Pokemon findById(int pokedexId) {
        List<Pokemon> pokemons = loadPokemonFromJson();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getPokedexId() == pokedexId )
                .toList().getFirst();
    }

    public Pokemon findByName(Name name) {
        return allPokemon.stream()
                .filter(pokemon -> pokemon.getName().getFr().equals(name.getFr()))
                .toList().getFirst();
    }
}
