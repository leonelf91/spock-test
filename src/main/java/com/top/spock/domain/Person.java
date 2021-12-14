package com.top.spock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Person {
    Integer id;
    String firstname;
    String lastname;
}
