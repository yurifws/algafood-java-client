package com.algaworks.algafood.client;

import java.math.BigDecimal;

import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.model.Problem;
import com.algaworks.algafood.client.model.RestauranteModel;
import com.algaworks.algafood.client.model.input.CidadeIdInput;
import com.algaworks.algafood.client.model.input.CozinhaIdInput;
import com.algaworks.algafood.client.model.input.EnderecoInput;
import com.algaworks.algafood.client.model.input.RestauranteInput;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			RestauranteClient restauranteClient = new RestauranteClient(restTemplate, "http://localhost:8080");
			
			
			var cidade =new CidadeIdInput();
			cidade.setId(1L);
			var cozinha = new CozinhaIdInput();
			cozinha.setId(1L);
			
			var endereco = new EnderecoInput();
			endereco.setNumero("555");
			endereco.setLogradouro("Tekek Silva");
			endereco.setBairro("Boa Vista");
			endereco.setCep("55599-558");
			endereco.setComplemento("ap 225");
			endereco.setCidade(cidade);
			
			var restauranteInput = new RestauranteInput();
			restauranteInput.setNome("Xisquito");
			restauranteInput.setTaxaFrete(new BigDecimal("477.8"));
			restauranteInput.setEndereco(endereco);
			restauranteInput.setCozinha(cozinha);
			
			RestauranteModel restauranteModel = restauranteClient.adicionar(restauranteInput);
			
			System.out.println(restauranteModel);
		} catch (ClientApiException e) {
			Problem problem = e.getProblem();
			if(problem != null) {
				System.out.println(problem.getUserMessage());	
					problem.getObjects().stream()
							.forEach(restaurante -> System.out.println(restaurante.getUserMessage()));
			}else {
				System.out.println("Erro desconhecido.");
				e.printStackTrace();
			}
		}
		
	}
}
