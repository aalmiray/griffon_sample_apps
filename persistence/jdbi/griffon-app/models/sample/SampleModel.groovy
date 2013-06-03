package sample

import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList

class SampleModel {
   EventList peopleList = new SortedList(new BasicEventList(),
     {a, b -> a.id <=> b.id} as Comparator)
}