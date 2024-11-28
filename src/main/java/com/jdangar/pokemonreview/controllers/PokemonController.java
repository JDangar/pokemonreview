package com.jdangar.pokemonreview.controllers;

import com.jdangar.pokemonreview.dto.PokemonDto;
import com.jdangar.pokemonreview.dto.PokemonResponse;
import com.jdangar.pokemonreview.models.Pokemon;
import com.jdangar.pokemonreview.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("pokemon")
    public ResponseEntity<PokemonResponse> getAllPokemon(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return ResponseEntity.ok(pokemonService.getAllPokemon(pageNo, pageSize));
    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<PokemonDto> getPokemon(@PathVariable int id) {
        return ResponseEntity.ok(pokemonService.getPokemonById(id));
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto) {
        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<PokemonDto> updatePokemon(@RequestBody PokemonDto pokemonDto, @PathVariable int id) {
        return ResponseEntity.ok(pokemonService.updatePokemon(pokemonDto,id));
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable int id) {
        pokemonService.deletePokemon(id);
        return ResponseEntity.ok("Pokemon Deleted successfully.");
    }
}
