package sample

import ca.odell.glazedlists.*
import griffon.transform.PropertyListener
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener

class SampleModel {
    final EventList<PersonPM> people = new ObservableElementList<PersonPM>(
        GlazedLists.threadSafeList(new BasicEventList<PersonPM>([
            new PersonPM(name: 'Adam',   lastName: 'Savage',  address: 'M5'),
            new PersonPM(name: 'Jamie',  lastName: 'Hyneman', address: 'M5'),
            new PersonPM(name: 'Kari',   lastName: 'Byron',   address: 'M7'),
            new PersonPM(name: 'Grant',  lastName: 'Imahara', address: 'M7'),
            new PersonPM(name: 'Tori',   lastName: 'Belleci', address: 'M7'),
            new PersonPM(name: 'Buster', lastName: '',        address: 'Junkyard')
        ])),
        GlazedLists.beanConnector(PersonPM)
    )
    
    final PersonPM currentPerson = new PersonPM()
    
    @PropertyListener(selectionUpdater)
    @Bindable int selectedIndex = -1
    
    private selectionUpdater = { e ->
        currentPerson.person = people[selectedIndex].person
    }
    
    SampleModel() {
        currentPerson.addPropertyChangeListener(new ModelUpdater())
    }
    
    private class ModelUpdater implements PropertyChangeListener {
        void propertyChange(PropertyChangeEvent e) {
            if(e.propertyName == 'person' || selectedIndex < 0) return
            people[selectedIndex][e.propertyName] = e.newValue
        }
    }
}