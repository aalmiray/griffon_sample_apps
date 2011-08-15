border(styles: "{padding:0}") {
    tablePane(id: "tablePane1", styles: "{verticalSpacing:1, showHorizontalGridLines:true, horizontalSpacing:1, showVerticalGridLines:true}") {
        tablePaneColumn(width: "-1")
        tablePaneColumn(width: "50")
        tablePaneColumn(width: "-1")
        tablePaneColumn(width: "1*")
        tablePaneColumn(width: "2*")

        tablePaneRow(height: "-1") {
            tablePaneFiller()
            label("50", styles: "{horizontalAlignment:'center'}")
            label("-1", styles: "{horizontalAlignment:'center'}")
            label("1*", styles: "{horizontalAlignment:'center'}")
            label("2*", styles: "{horizontalAlignment:'center'}")
        }
        tablePaneRow(height: "50") {
            label("50", styles: "{verticalAlignment:'center'}")
        }
        tablePaneRow(height: "-1") {
            label("-1", styles: "{verticalAlignment:'center'}")
        }
        tablePaneRow(height: "1*") {
            label("1*", styles: "{verticalAlignment:'center'}")
        }
        tablePaneRow(height: "2*") {
            label("2*", styles: "{verticalAlignment:'center'}")
        }

        componentMouseButtonListener {
            onMouseClick { component, mouseButton, x, y, count ->
                int rowIndex = tablePane1.getRowAt(y)
                int columnIndex = tablePane1.getColumnAt(x)

                if(rowIndex >= 0 && columnIndex >= 0) {
                    def row = tablePane1.rows[rowIndex]
                    def column = tablePane1.columns[columnIndex]

                    int rowHeight = row.height
                    int columnWidth = column.width

                    String message = "Registered Click At (${rowIndex},${columnIndex})"

                    def body = vbox {
                        label(String.format("The row's height is %d (%s)", rowHeight,
                                        rowHeight == -1 ? "default" : (row.relative ? "relative" : "absolute")))
                        label(String.format("The column's width is %d (%s)", columnWidth,
                                        columnWidth == -1 ? "default" : (column.isRelative() ? "relative" : "absolute")))
                    }

                    app.prompt(message: message, body: body)
                    return false
                }
            }
        }
    }
}
