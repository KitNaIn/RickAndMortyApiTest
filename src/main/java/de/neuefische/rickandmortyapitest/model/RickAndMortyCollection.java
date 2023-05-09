package de.neuefische.rickandmortyapitest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RickAndMortyCollection {

    private int count;
    private int pages;

    private List<RickAndMorty> results;
}
