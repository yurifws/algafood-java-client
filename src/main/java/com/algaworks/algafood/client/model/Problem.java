package com.algaworks.algafood.client.model;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class Problem {

	private Integer status;
	private String userMessage;
	private OffsetDateTime timestamp;

}
