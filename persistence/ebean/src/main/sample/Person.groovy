package sample

import javax.persistence.*

@Entity
class Person {
    @Id int id
    String name
    String lastname
}
