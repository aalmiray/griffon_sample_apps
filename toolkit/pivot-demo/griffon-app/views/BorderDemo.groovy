tablePane(styles: "{horizontalSpacing: 10}") {
    tablePaneColumn(width: "1*")
    tablePaneColumn(width: "1*")
    tablePaneRow(height: "1*") {
        border(title: "Border 1") {
            label('Default border with title',
                  styles: "{horizontalAlignment:'center', verticalAlignment:'center', wrapText:true}")
        }
        border(styles: "{color:'#ff0000', titleColor:'#000000', thickness:10, cornerRadii:20}") {
            label('Custom border with 10-pixel thick red border, rounded corrners, and no title',
                  styles: "{horizontalAlignment:'center', verticalAlignment:'center', wrapText:true}")
        }
    }
}
