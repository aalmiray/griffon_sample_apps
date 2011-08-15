selectionChanged = { lb, pindex ->
    if(lb.selectedIndex == -1) return
    String item = lb.listData[lb.selectedIndex]  
    URL imageURL = getClass().classLoader.getResource(item)
    def image = app.resourceCache[imageURL]
    if(!image) {
        image = app.loadImage(imageURL)
        app.resourceCache[imageURL] = image
    }
    iv.image = image
}

tablePane(styles: "{showHorizontalGridLines: true, showVerticalGridLines: true, horizontalSpacing: 1, verticalSpacing: 1}") {
    tablePaneColumn(width: -1)
    tablePaneColumn(width: '1*')
    tablePaneRow(height: 340) {
        vbox(styles: "{verticalAlignment: 'top', padding: 4}") {
            label('Picture:')
            listButton(id: 'lb', listData: "['IMG_0725_2.jpg', 'IMG_0735_2.jpg', 'IMG_0767_2.jpg']") {
                listButtonSelectionListener {
                    onSelectedIndexChanged(selectionChanged) 
                }
            }
        }
        imageView(id: 'iv', styles: "{backgroundColor: '#404040'}")
        noparent{ lb.selectedIndex = 0 }
    }
}
