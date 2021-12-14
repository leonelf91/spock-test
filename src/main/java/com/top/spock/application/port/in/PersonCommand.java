package com.top.spock.application.port.in;

import com.top.spock.domain.Person;
import lombok.Builder;
import lombok.Value;

public interface PersonCommand {

    Person execute(Data data);

    @Value
    @Builder
    class Data {
        Integer userId;
    }
}

