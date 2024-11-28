package com.jdangar.pokemonreview.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonResponse {
    List<PokemonDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
