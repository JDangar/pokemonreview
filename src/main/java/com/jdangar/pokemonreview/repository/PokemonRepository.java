package com.jdangar.pokemonreview.repository;

import com.jdangar.pokemonreview.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {
}
