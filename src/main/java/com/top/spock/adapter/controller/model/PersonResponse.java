package com.top.spock.adapter.controller.model;

import com.top.spock.domain.Person;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {

	private Integer idUsuario;
	private String nombre;
	private String apellido;

	public static PersonResponse fromDomain(Person person){
		return PersonResponse.builder()
				.idUsuario(person.getId())
				.nombre(person.getFirstname())
				.apellido(person.getLastname())
				.build();
	}

}
