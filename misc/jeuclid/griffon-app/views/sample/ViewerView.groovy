package sample

tabbedPane(id: 'viewer', tabPlacement: JTabbedPane.BOTTOM) {
    mathMLViewer(title: 'View', content: bind{ model.content })
    scrollPane(title: 'Source') {
        textArea(editable: false, text: bind{ model.content },
            caretPosition: bind(source: model, 'content', converter: {0i}))
    }
}