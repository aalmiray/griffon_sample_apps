package bomb

optionPane(
    id: 'pane',
    messageType: JOptionPane.INFORMATION_MESSAGE,
    optionType: JOptionPane.DEFAULT_OPTION,
    icon: nuvolaIcon('core', category: 'apps', size: 64),
    message: bind {model.message})