package sample

import groovy.beans.Bindable
import griffon.transform.PropertyListener
import java.beans.PropertyChangeListener

@PropertyListener(downstreamUpdater)
class PersonPM extends Person {
    @Bindable @PropertyListener(upstreamUdater)
    Person person = new Person()
    
    private upstreamUdater = { e ->
        e.oldValue?.removePropertyChangeListener(propertyUpdater)
        e.newValue?.removePropertyChangeListener(propertyUpdater)
        e.newValue?.copyTo(owner)
    }
    
    private downstreamUpdater = { e ->
        if(e.propertyName == 'person') return
        if(person) person[e.propertyName] = e.newValue
    }
    
    private propertyUpdater = { e ->
        owner[e.propertyName] = e.newValue
    } as PropertyChangeListener
}