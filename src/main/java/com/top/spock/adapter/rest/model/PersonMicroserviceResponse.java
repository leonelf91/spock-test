package com.top.spock.adapter.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.top.spock.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
public class PersonMicroserviceResponse {
    private Integer id;
    private String firstname;
    private String lastname;

    public Person toDomain(){
        return Person.builder()
                .id(id)
                .firstname(firstname)
                .lastname(lastname)
                .build();
    }
}
