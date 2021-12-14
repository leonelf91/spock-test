package com.top.spock.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Person {
    Integer id;
    String firstname;
    String lastname;
}
