package sample

application(title: 'sample',
  preferredSize: [480, 200],
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    migLayout(layoutConstraints: 'fill')
    list(model: eventListModel(source: model.people), constraints: 'west',
         border: titledBorder(title: 'People'),
         selectionMode: ListSelectionModel.SINGLE_SELECTION,
         keyReleased: { e ->  // enter/return key
             if (e.keyCode != KeyEvent.VK_ENTER) return
             int index = e.source.selectedIndex
             if (index > -1) model.personSelected(index)
         },
         mouseClicked: { e -> // double click
             if (e.clickCount != 2) return
             int index = e.source.locationToIndex(e.point)
             if (index > -1) model.personSelected(index)
         })
    panel(id: 'formContainer', constraints: 'center, grow') {
        migLayout(layoutConstraints: 'fill')
        ['name', 'lastName', 'address'].each { propName ->
            label(text: GriffonNameUtils.getNaturalName(propName) + ':', constraints: 'right')
            textField(columns: 30, text: bind(propName, source: model.personPM, mutual: true), constraints: 'grow, wrap')
        }
    }
}
