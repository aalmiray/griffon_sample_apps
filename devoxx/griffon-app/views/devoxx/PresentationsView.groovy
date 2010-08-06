package devoxx

import ca.odell.glazedlists.*
import ca.odell.glazedlists.gui.*
import ca.odell.glazedlists.swing.*
import ca.odell.glazedlists.event.*
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentListener

def type = Constants.TYPES.presentations

presentationsMatcherEditor = new TextComponentMatcherEditor(
   searchField(id: 'presentationSearch'),
   {List baseList, info ->
      baseList << info.title
      baseList << info.summary
      baseList << info.track
      baseList << info.speaker
      baseList << info.type
      baseList << info.experience.toLowerCase()
   } as TextFilterator
)

filteredPresentations = new FilterList(model.presentations, presentationsMatcherEditor)
filteredPresentations.addListEventListener({ e ->
    model.size = e.sourceList.size()
} as ListEventListener)

presentationsTrackingSelectionModel = bean(new EventSelectionModel(filteredPresentations),
   selectionMode: EventSelectionModel.SINGLE_SELECTION)

def createPresentationsTableModel() {
   new EventTableModel(filteredPresentations, [
        getColumnCount: { 1i },
        getColumnName: {index -> ''},
        getColumnValue: {object, index -> object}
    ] as TableFormat)
}

def createPresentationsTableModel_copy() {
   def columnNames = ['Title', 'Speaker', 'Track', 'Type', 'Experience']
   def propertyNames = ['title', 'speaker', 'track', 'type', 'experience']
   new EventTableModel(filteredPresentations, [
        getColumnCount: { columnNames.size() },
        getColumnName: {index -> columnNames[index]},
        getColumnValue: {object, index -> object."${propertyNames[index]}"}
    ] as TableFormat)
}

// Usage of a noparent{} block avoids inserting a Swing component
// in the current hierarchy
noparent {
    // Create a copy of the real table but with a different TableFormat
    // this will alow the usage of a multi-column JTableHeader with a
    // single column model
    table(id: 'presentationsTable_copy', model: createPresentationsTableModel_copy())
}

panel(id: 'box', opaque: false) {
    migLayout(layoutConstraints: 'insets 0 0 0 0, fill')
    label(icon: crystalIcon(size: 22, category: type.icon.category, icon: type.icon.name),
          constraints: 'left, top, grow',
          text: bind('size', source: model, converter: {v -> "${type.description} (${v})".toString()}))
    widget(presentationSearch, columns: 20, constraints: 'right, top, wrap')

    // add the multi-column header first
    widget(presentationsTable_copy.tableHeader, constraints: 'span 2, top, growx, wrap',
           resizingAllowed: false, reorderingAllowed: false)
    // then comes the real table
    scrollPane(id: 'presentationsTableContainer', opaque: false, constraints: 'span 2, top, grow') {
        table(id: 'presentationsTable', model: createPresentationsTableModel(),
              selectionModel: presentationsTrackingSelectionModel) {
            def column = presentationsTable.columnModel.getColumn(0i)
            column.cellRenderer = new PresentationTableCellRenderer(delegate)
        }
    }

    noparent {
        // further customizations to the multi-column header
        // 1st we add sorting capabilities
        TableComparatorChooser.install(presentationsTable_copy, model.presentations,
            TableComparatorChooser.SINGLE_COLUMN)
        // 2nd sincronize its size with the table container
        presentationsTableContainer.addComponentListener([
            componentResized: { e ->
                def tableHeader = presentationsTable_copy.tableHeader
                int totalWidth = e.source.size.width
                int currentHeight = tableHeader.size.height

                // update tableHeader size
                tableHeader.setSize(totalWidth as int, currentHeight as int)
                int columnWidth = totalWidth / tableHeader.columnModel.columnCount
                // update each column too
                for(column in tableHeader.columnModel.columns) {
                    column.width = columnWidth as int
                    column.preferredWidth = columnWidth as int
                }
            }] as ComponentAdapter)
    }
}
