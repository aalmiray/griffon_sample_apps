import org.apache.pivot.wtk.Orientation

application(title: "Pivot on Griffon", maximized: true) {
    tabPane {
        ['Hello Pivot': HelloPivotDemo,
         'Label & Image': LabelAndImageDemo,
         'Buttons': ButtonsDemo,
         'Lists': ListsDemo,
         'ListButton': ListButtonDemo,
         'Text': TextDemo,
         'Separator': SeparatorDemo,
         'Layout Containers': PanesDemo,
         'Navigation Containers': Panes2Demo].each { demoLabel, demoScript ->
            demo = null
            noparent { demo = build(demoScript) }
            widget(demo, label: demoLabel)
        }
    }
}
