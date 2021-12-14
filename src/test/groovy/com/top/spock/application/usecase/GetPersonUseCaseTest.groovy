package com.top.spock.application.usecase


import com.top.spock.application.exception.InvalidUserIdException
import com.top.spock.application.port.in.PersonCommand
import com.top.spock.application.port.out.PersonRepository
import com.top.spock.domain.Person
import spock.lang.Specification

class GetPersonUseCaseTest extends Specification {

    PersonRepository personRepository = Mock(PersonRepository)
    GetPersonUseCase target = new GetPersonUseCase(personRepository)

    def "given ... when ... then ..."() {
        given:
        PersonCommand.Data data = new PersonCommand.Data(123)
        def expected = new Person(123,"Prueba","Hello")

        when:
        def result = target.execute(data)

        then:
        1 * personRepository.getUserById(123) >> new Person(123,"Prueba","Hello")
        expected == result

    }

    def "given ... when ... then InvalidUserIdException"() {
        given:
        PersonCommand.Data data = new PersonCommand.Data(1)

        when:
        def result = target.execute(data)

        then:
        thrown(InvalidUserIdException)

    }

    def "given ... when ... then RuntimeException"() {
        given:
        PersonCommand.Data data = new PersonCommand.Data(123)
        personRepository.getUserById(_ as Integer) >> { throw new RuntimeException() }

        when:
        target.execute(data)

        then:
        thrown(RuntimeException)

    }

    def "given ... when ... then RuntimeException where ..."() {
        given:
        PersonCommand.Data data = new PersonCommand.Data(123)
        personRepository.getUserById(_ as Integer) >> { throw exception }

        when:
        target.execute(data)

        then:
        thrown(expected)

        where:
        expected                        | exception
        RuntimeException                | new RuntimeException()
        Exception                       | new Exception()



    }

}
