package sample.mappers

import sample.Person

interface PersonMapper {
    Person findPersonById(int id)

    int insert(Person person)

    int update(Person person)

    int delete(Person person)

    List<Person> list()
}
