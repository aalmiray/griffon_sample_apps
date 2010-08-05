package devoxx

import groovy.beans.Bindable
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList

class SpeakersModel {
    EventList speakers = new SortedList(new BasicEventList(),
        {a, b -> a.firstName <=> b.firstName} as Comparator)

    @Bindable int size = 0

    DevoxxService devoxxService

    void update() {
        execAsync {
            // update the size first so that the label can be updated too 
            size = devoxxService.speakers.size()
        }
        execAsync {
            // change the table
            speakers.addAll(devoxxService.speakers.values())
        }
    }
}
