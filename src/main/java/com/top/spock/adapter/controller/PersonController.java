package com.top.spock.adapter.controller;

import com.top.spock.adapter.controller.model.PersonResponse;
import com.top.spock.application.port.in.PersonCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonCommand personCommand;

    public PersonController (PersonCommand personCommand) {
        this.personCommand = personCommand;
    }

    @GetMapping
    public ResponseEntity<PersonResponse> getPerson (@RequestParam Integer userId) {

        PersonCommand.Data data = PersonCommand.Data.builder()
                .userId(userId)
                .build();

        PersonResponse personResponse = PersonResponse.fromDomain(personCommand.execute(data));

        return ResponseEntity.ok(personResponse);
    }

}
