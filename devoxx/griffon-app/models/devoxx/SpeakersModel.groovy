package devoxx

import groovy.beans.Bindable
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList

class SpeakersModel {
    EventList speakers = new SortedList(new BasicEventList(),
        {a, b -> a.firstName <=> b.firstName} as Comparator)

    DevoxxService devoxxService

    void update() {
        execSync {
            speakers.addAll(devoxxService.speakers.values())
        }
    }
}
