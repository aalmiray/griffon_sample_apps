package sample

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

class Person {
    int id
    String name
    String lastname
    
    static String toJSON(Person person) {
        new JsonBuilder([
            id: person.id,
            name: person.name,
            lastname: person.lastname
        ]).toString()
    }
    
    static Person fromJSON(String json) {
        def result = new JsonSlurper().parseText(json)
        new Person(
            id: result.id,
            name: result.name,
            lastname: result.lastname
        )
    }
}
