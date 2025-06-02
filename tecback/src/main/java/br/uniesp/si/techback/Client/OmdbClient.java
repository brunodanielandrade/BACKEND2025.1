package br.uniesp.si.techback.Client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONObject;

@Component
public class OmdbClient {
    private final String API_KEY = "d30a5b3a";
    private final String BASE_URL = "http://www.omdbapi.com/";

    public JSONObject buscarFilmePorTitulo(String titulo) {
        RestTemplate restTemplate = new RestTemplate();

        String uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("t", titulo)
                .queryParam("apikey", API_KEY)
                .toUriString();

        String response = restTemplate.getForObject(uri, String.class);
        return new JSONObject(response);
    }
}
