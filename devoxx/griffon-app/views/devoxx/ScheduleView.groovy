package devoxx

def type = Constants.TYPES.schedule

panel(id: 'box', opaque: false) {
    migLayout(layoutConstraints: 'insets 0 0 0 0, fill')
    label(icon: crystalIcon(size: 22, category: type.icon.category, icon: type.icon.name),
          text: type.description, constraints: 'left, grow')
}

