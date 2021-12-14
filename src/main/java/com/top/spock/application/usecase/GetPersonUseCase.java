package com.top.spock.application.usecase;

import com.top.spock.application.exception.InvalidUserIdException;
import com.top.spock.application.port.in.PersonCommand;
import com.top.spock.application.port.out.PersonRepository;
import com.top.spock.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GetPersonUseCase implements PersonCommand {

	private final PersonRepository personRepository;

	public GetPersonUseCase (PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Person execute(Data data) {
		if (data.getUserId()==1)
			throw new InvalidUserIdException();

		return personRepository.getUserById(data.getUserId());
	}
}
