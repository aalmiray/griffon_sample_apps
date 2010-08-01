package devoxx

import ca.odell.glazedlists.*
import ca.odell.glazedlists.gui.*
import ca.odell.glazedlists.swing.*

def type = Constants.TYPES.presentations

presentationsMatcherEditor = new TextComponentMatcherEditor(
   searchField(id: 'presentationSearch'),
   {List baseList, info ->
      baseList << info.title
      baseList << info.summary
   } as TextFilterator
)

filteredPresentations = new FilterList(model.presentations, presentationsMatcherEditor)
presentationsTrackingSelectionModel = bean(new EventSelectionModel(filteredPresentations),
   selectionMode: EventSelectionModel.SINGLE_SELECTION)

def createPresentationsTableModel() {
   def columnNames = ['title']
   new EventTableModel(filteredPresentations, [
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
    widget(presentationSearch, columns: 20, constraints: 'right, wrap')
    scrollPane(opaque: false, constraints: 'span 2, grow') {
         table(id: 'presentationsTable', model: createPresentationsTableModel(),
              selectionModel: presentationsTrackingSelectionModel) {
             installTableComparatorChooser(source: model.presentations)
        }
    }
}
