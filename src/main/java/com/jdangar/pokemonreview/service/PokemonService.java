package com.jdangar.pokemonreview.service;

import com.jdangar.pokemonreview.dto.PokemonDto;

import java.util.List;

public interface PokemonService {

    PokemonDto createPokemon(PokemonDto pokemonDto);

    List<PokemonDto> getAllPokemon();

}
