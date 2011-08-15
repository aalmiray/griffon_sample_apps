application(text: "SWT Demo", location:[100,100], size:[300,150]) {
    gridLayout()
    cTabFolder(style: "BOTTOM") {
        gridData(style:"fill_both")
        cTabItem("Item1", style:"none") {
            text(style:"border, multi, v_scroll, h_scroll", "Content for Item1")
        }
        cTabItem("Item2", style:"none") {
            text(style:"border, multi", "Content for Item2")
        }
        cTabItem("Item3", style:"none") {
            composite(){
                fillLayout()
                text(style:"border, multi, v_scroll", "Content for Item3")
                button("ok") {
                    onEvent('Selection', controller.doit)
                }
            }
        }
    }
 
    tabFolder(style:"NONE") {
        gridData(style:"fill_both")
        tabItem("Item4", style:"none") {
            text( style:"border, multi", "Content for Item4" )
        }
        tabItem("Item5", style:"none") {
            text(style:"border, multi", "Content for Item5")
        }
        tabItem("Item6", style:"none") {
            text( style:"border, multi", "Content for Item6" )
        }
    }
}
