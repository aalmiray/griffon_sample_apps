package devoxx

import ca.odell.glazedlists.*
import ca.odell.glazedlists.gui.*
import ca.odell.glazedlists.swing.*

def type = Constants.TYPES.speakers

speakersMatcherEditor = new TextComponentMatcherEditor(
   searchField(id: 'speakerSearch'),
   {List baseList, info ->
      baseList << info.firstName
      baseList << info.lastName
      baseList << info.company
   } as TextFilterator
)

filteredSpeakers = new FilterList(model.speakers, speakersMatcherEditor)
speakersTrackingSelectionModel = bean(new EventSelectionModel(filteredSpeakers),
   selectionMode: EventSelectionModel.SINGLE_SELECTION)

def createSpeakersTableModel() {
   def columnNames = ['firstName', 'lastName']
   new EventTableModel(filteredSpeakers, [
          getColumnCount: {columnNames.size()},
          getColumnName: {index -> columnNames[index].capitalize()},
          getColumnValue: {object, index ->
             object."${columnNames[index]}"
          }] as TableFormat)
}

panel(id: 'box', opaque: false) {
    migLayout(layoutConstraints: 'fill')
    label(icon: crystalIcon(size: 32, category: type.icon.category, icon: type.icon.name),
          text: type.description, constraints: 'left, grow')
    widget(speakerSearch, columns: 20, constraints: 'right, wrap')
    scrollPane(opaque: false, constraints: 'span 2, grow') {
         table(id: 'speakersTable', model: createSpeakersTableModel(),
              selectionModel: speakersTrackingSelectionModel) {
             installTableComparatorChooser(source: model.speakers)
        }
    }
}
