package de.neuefische.rickandmortyapitest.controller;

import de.neuefische.rickandmortyapitest.model.RickAndMorty;
import de.neuefische.rickandmortyapitest.model.RickAndMortyCollection;
import de.neuefische.rickandmortyapitest.service.RickAndMortyService;
import jdk.internal.access.JavaIOFileDescriptorAccess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor

public class RickAndMortyController {

    private final RickAndMortyService service;

    @GetMapping("/characters")
    public List<RickAndMorty> getAllCharacters(){
    return service.getAllCharacters();
    }


    @GetMapping("/characters/alive")
    public List<RickAndMorty> getAlllivingCharacters(){
        return service.getAllLivingCharacters();
    }

}
