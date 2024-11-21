package com.jdangar.pokemonreview.controllers;

import com.jdangar.pokemonreview.models.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PokemonController {

    @GetMapping("pokemon")
    public ResponseEntity<List<Pokemon>> getPokemons(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1, "Squirtle","Water"));
        pokemons.add(new Pokemon(2, "Pikachu","Electric"));
        pokemons.add(new Pokemon(3, "Charmender","Fire"));

        return ResponseEntity.ok(pokemons);
    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable int id){
        return ResponseEntity.ok(new Pokemon(id,"Pikachu", "Fire"));
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon){
        System.out.println(pokemon.getName());
        System.out.println(pokemon.getType());
        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon, @PathVariable int id){
        System.out.println(pokemon.getName());
        System.out.println(pokemon.getType());
        return ResponseEntity.ok(pokemon);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable int id){
        System.out.println(id);
        return ResponseEntity.ok("Pokemon Deleted successfully.");
    }
}
