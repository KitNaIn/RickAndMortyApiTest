package de.neuefische.rickandmortyapitest.service;

import de.neuefische.rickandmortyapitest.model.RickAndMorty;
import de.neuefische.rickandmortyapitest.model.RickAndMortyCollection;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service

public class RickAndMortyService {

    WebClient webClient = WebClient.create("https://rickandmortyapi.com/api");

    /*public List<RickAndMorty> AllCharacters(int page, int pageSize) {
        RickAndMortyCollection response =
                Objects.requireNonNull(webClient.get())
                        .uri("/character")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .toEntity(RickAndMortyCollection.class)
                        .block()
                    .getBody();
                return response.getResults();

    }*/

    public List<RickAndMorty> getAllCharacters() {
        List<RickAndMorty> allCharacters = new ArrayList<>();
        int page = 1;
        int pageSize = 20;
        RickAndMortyCollection response;
        do {
            response = Objects.requireNonNull(webClient.get())
                    .uri("/character?page={page}&pageSize={pageSize}", page, pageSize)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .retrieve()
                    .toEntity(RickAndMortyCollection.class)
                    .block()
                    .getBody();
            allCharacters.addAll(response.getResults());
            page++;
        }while (response.getResults().size() == pageSize);
        return allCharacters;
    }

    public List<RickAndMorty> getAllLivingCharacters() {
        List<RickAndMorty> allCharacters = new ArrayList<>();
        int page = 1;
        int pageSize = 20;
        RickAndMortyCollection response;
        do {
            response = Objects.requireNonNull(webClient.get())
                    .uri("/character/?page={page}&pageSize={pageSize}&status=alive", page, pageSize)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .retrieve()
                    .toEntity(RickAndMortyCollection.class)
                    .block()
                    .getBody();
            allCharacters.addAll(response.getResults());
            page++;
        }while (response.getResults().size() == pageSize);
        return allCharacters;
    }



}
