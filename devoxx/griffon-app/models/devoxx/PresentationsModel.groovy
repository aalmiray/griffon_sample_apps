package devoxx

import groovy.beans.Bindable
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList

class PresentationsModel {
    EventList presentations = new SortedList(new BasicEventList(),
        {a, b -> a.title <=> b.title} as Comparator)

    @Bindable int size = 0

    DevoxxService devoxxService

    void update() {
        execAsync {
            // update the size first so that the label can be updated too 
            size = devoxxService.presentations.size()
        }
        execAsync {
            // change the table
            presentations.addAll(devoxxService.presentations.values())
        }
    }
}
