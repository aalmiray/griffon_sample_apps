package sample

import groovy.beans.Bindable
import griffon.transform.PropertyListener

@PropertyListener(propertyUpdater)
class PersonPM {
    // attributes
    @Bindable String name
    @Bindable String lastName
    @Bindable String address
    
    // model reference
    @Bindable Person person = new Person()
    
    static final List<String> PROPERTIES = ['name', 'lastName', 'address']
    
    private propertyUpdater = { e ->
        if(e.propertyName == 'person') {
            for(property in PROPERTIES) {
                delegate[property] = e.newValue != null ? e.newValue[property] : null
            }
        } else if(person) {
            person[e.propertyName] = e.newValue
        }
    }

    String toString() { "$name $lastName" }
}