package sample

import ca.odell.glazedlists.*

class SampleModel {
    final EventList<Person> people = new ObservableElementList<Person>(
        GlazedLists.threadSafeList(new BasicEventList<Person>([
            new Person(id: 1, name: 'Adam',   lastName: 'Savage',  address: 'M5'),
            new Person(id: 2, name: 'Jamie',  lastName: 'Hyneman', address: 'M5'),
            new Person(id: 3, name: 'Kari',   lastName: 'Byron',   address: 'M7'),
            new Person(id: 4, name: 'Grant',  lastName: 'Imahara', address: 'M7'),
            new Person(id: 5, name: 'Tori',   lastName: 'Belleci', address: 'M7'),
            new Person(id: 6, name: 'Buster', lastName: '',        address: 'Junkyard')
        ])),
        GlazedLists.beanConnector(Person)
    )
    
    final PersonPM personPM = new PersonPM()
    
    void personSelected(int index) {
        personPM.person = people[index]
    }
}