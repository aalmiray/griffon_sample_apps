package devoxx

import groovy.beans.Bindable
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList

class PresentationsModel {
    EventList presentations = new SortedList(new BasicEventList(),
        {a, b -> a.title <=> b.title} as Comparator)

    DevoxxService devoxxService

    void update() {
        execSync {
            presentations.addAll(devoxxService.presentations.values())
        }
    }
}
