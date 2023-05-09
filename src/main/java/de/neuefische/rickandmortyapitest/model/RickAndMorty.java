package de.neuefische.rickandmortyapitest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RickAndMorty {

    private int id;
    private String name;
    private String status;
    private String species;


}
