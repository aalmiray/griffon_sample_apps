selectionUpdated = { listView ->
    String selectionText = ''
    listView.selectedRanges.each { span ->
        span.asRange().each { j ->
            selectionText += selectionText.size() ? ', ': ''
            selectionText += listView.listData[j]
        }
    }
    selectionLabel.text = selectionText
}

hbox(styles: "{padding: 4, spacing: 4}") {
    border(styles: "{padding: 0, color: 0}") {
        scrollPane(preferredWidth: 80, preferredHeight: 110,
                   horizontalScrollBarPolicy: 'fill', verticalScrollBarPolicy: 'fill_to_capacity') {
            listView(selectMode: 'multi', id: 'lw',
                     listData: "['One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten']") {
                listViewSelectionListener {
                    onSelectedRangeAdded{ lv, s, e -> selectionUpdated(lv) }
                    onSelectedRangeRemoved{ lv, s, e -> selectionUpdated(lv) }
                    onSelectedRangesChanged{ lv, span -> selectionUpdated(lv) }
                }
            }
        }
    }
    vbox(preferredWidth: 120, styles: "{fill: true}") {
        label('You selected')
        label(id: 'selectionLabel', styles: '{wrapText: true}')
    }
}
