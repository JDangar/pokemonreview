package com.jdangar.pokemonreview.service;

import com.jdangar.pokemonreview.dto.PokemonDto;
import com.jdangar.pokemonreview.dto.PokemonResponse;

import java.util.List;

public interface PokemonService {

    PokemonDto createPokemon(PokemonDto pokemonDto);

    PokemonResponse getAllPokemon(int pageNo, int pageSize);

    PokemonDto getPokemonById(int pokemonId);

    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);

    void deletePokemon(int pokemonId);

}
