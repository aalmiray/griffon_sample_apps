package devoxx

def type = Constants.TYPES.schedule

panel(id: 'box', opaque: false) {
    migLayout(layoutConstraints: 'fill')
    label(icon: tangoIcon(size: 32, category: type.icon.category, icon: type.icon.name),
          text: type.description, constraints: 'left, grow')
}

