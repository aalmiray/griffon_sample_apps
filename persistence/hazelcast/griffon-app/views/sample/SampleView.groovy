package sample

application(title: 'Hazelcast',
  preferredSize: [320, 240],
  pack: true,
  locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    scrollPane {
        table(id: 'peopleTable') {
            tableFormat = defaultTableFormat(columnNames: ['Id', 'Name', 'Lastname'])
            eventTableModel(source: model.people, format: tableFormat)
            installTableComparatorChooser(source: model.people)
        }
    }
}