package com.algaworks.algafood.client.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class Problem {

	private Integer status;
	private String userMessage;
	private OffsetDateTime timestamp;
	private List<Object> objects = new ArrayList<>();
	
	@Getter
	@Builder
	public static class Object{

		private String name;
		private String userMessage;
	}

}
