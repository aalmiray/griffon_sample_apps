package sample

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Person {
    String name
    String lastName
    String address
    
    String toString() { "$name $lastName : $address" }
}