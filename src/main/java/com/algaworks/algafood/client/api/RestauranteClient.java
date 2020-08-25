package com.algaworks.algafood.client.api;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.model.RestauranteModel;
import com.algaworks.algafood.client.model.RestauranteResumoModel;
import com.algaworks.algafood.client.model.input.RestauranteInput;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestauranteClient {
	
	private static final String RESOURCE_PATH = "/restaurantes";
	
	private RestTemplate restTemplate;
	private String url;
	
	public List<RestauranteResumoModel> listar(){
		try {
			
		URI resourceUri = URI.create(url.concat(RESOURCE_PATH));
		RestauranteResumoModel[] restaurantes = restTemplate.getForObject(resourceUri, RestauranteResumoModel[].class);
		return Arrays.asList(restaurantes);
		
		} catch (RestClientResponseException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}
	
	public RestauranteModel adicionar(RestauranteInput restauranteInput) {
		try {
			URI resourceUri = URI.create(url.concat(RESOURCE_PATH));
			return restTemplate.postForObject(resourceUri, restauranteInput, RestauranteModel.class);
	} catch (RestClientResponseException e) {
		throw new ClientApiException(e.getMessage(), e);
	}
	}

}
