package devoxx

def type = Constants.TYPES.presentations

panel(id: 'box', opaque: false) {
    migLayout(layoutConstraints: 'fill')
    label(icon: tangoIcon(size: 32, category: type.icon.category, icon: type.icon.name),
          text: type.description, constraints: 'left, grow')
    searchField(id: 'presentationSearch', columns: 20, constraints: 'right, wrap')
    scrollPane(constraints: 'span 2, grow') {
        table(id: 'presentationsTable') {
            tableFormat = defaultTableFormat(columnNames: ['Title'])
            eventTableModel(source: model.presentations, format: tableFormat)
            installTableComparatorChooser(source: model.presentations)
        }
    }
}
