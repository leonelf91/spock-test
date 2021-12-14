package com.top.spock.application.port.out;

import com.top.spock.domain.Person;

public interface PersonRepository {
    Person getUserById (Integer userId);

}
