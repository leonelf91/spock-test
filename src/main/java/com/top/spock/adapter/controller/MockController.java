package com.top.spock.adapter.controller;

import com.top.spock.adapter.rest.model.PersonMicroserviceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

	@GetMapping("/mock/person")
	public ResponseEntity<PersonMicroserviceResponse> getPerson(@RequestParam Integer id){
		PersonMicroserviceResponse persona =
				PersonMicroserviceResponse.builder()
						.id(id)
						.firstname("Prueba")
						.lastname("Test Unitario")
						.build();
		return ResponseEntity.ok(persona);
	}

}
