package sample

import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList

class SampleModel {
   EventList<Person> people = new SortedList<Person>(new BasicEventList<Person>(),
     {a, b -> a.id <=> b.id} as Comparator<Person>)
}