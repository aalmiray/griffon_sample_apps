package sample

import groovy.beans.Bindable
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Person {
    int id
    @Bindable String name
    @Bindable String lastName
    @Bindable String address
    
    String toString() { "$name $lastName" }

    void copyTo(Person p) {
         p.id = id
         p.name = name
         p.lastName = lastName
         p.address = address
    }
}