import groovy.beans.Bindable
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList

class GModel {
    EventList persons = new SortedList( new BasicEventList(),
        {a, b -> a.name <=> b.name} as Comparator)
    
    GModel() {
        persons.addAll([
            [name: 'Adam',  lastName: 'Savage'],
            [name: 'Jamie', lastName: 'Hyneman'],
            [name: 'Kari',  lastName: 'Byron'],
            [name: 'Grant', lastName: 'Imahara'],
            [name: 'Tori',  lastName: 'Belleci'],
            [name: 'Buster',  lastName: ''],
        ])
    }
}
