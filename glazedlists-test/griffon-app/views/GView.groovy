import ca.odell.glazedlists.BasicEventList

application(title: 'GlazedLists',
  size:[300,300],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    borderLayout()
    panel(constraints: NORTH) {
        gridLayout(cols: 1, rows: 2)
        comboBox {
            installComboBoxAutoCompleteSupport(items: new BasicEventList(model.persons*.name))
        }
        comboBox {
            installComboBoxAutoCompleteSupport(items: new BasicEventList(model.persons*.lastName))
        }
    }
    scrollPane(constraints: CENTER) {
        table(id: 'personsTable') {
            tableFormat = defaultTableFormat(columnNames: ['Name', 'LastName'])
            eventTableModel(source: model.persons, format: tableFormat)
            installTableComparatorChooser(source: model.persons)
        }
    }
}
