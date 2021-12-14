package com.top.spock.adapter.rest;

import com.top.spock.adapter.rest.model.PersonMicroserviceResponse;
import com.top.spock.application.port.out.PersonRepository;
import com.top.spock.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
public class PersonRestAdapter implements PersonRepository {

    private final RestTemplate restTemplate;


    public PersonRestAdapter (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Person getUserById (Integer userId) {
        PersonMicroserviceResponse response = restTemplate.getForObject(buildUri(userId), PersonMicroserviceResponse.class);
        return response.toDomain();
    }

    public String buildUri (Integer userId){
        return UriComponentsBuilder.fromHttpUrl("http://localhost:8500/mock/person?id={userId}").buildAndExpand(userId).toUriString();

    }
}
