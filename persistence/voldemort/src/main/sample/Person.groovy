package sample

class Person {
    String id
    String name
    String lastname
    
    static Map toMap(Person person) {
        [
            id: person.id,
            name: person.name,
            lastname: person.lastname
        ]
    }
}
