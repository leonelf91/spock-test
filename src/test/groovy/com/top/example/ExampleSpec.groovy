package com.top.example

import spock.lang.Specification

class ExampleSpec extends Specification{

    def "Sum 2 numbers"(){
        given:
        int a = 4
        int b = 7

        when:
        int c = a+b

        then:
        c == 11
    }
}
