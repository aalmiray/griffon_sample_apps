tabPane(styles: "{padding: 4, tabOrientation: 'vertical'}") {
    ['Flow': FlowPaneDemo,
     'Box': BoxPaneDemo,
     'Table': TablePaneDemo,
     'Border': BorderDemo,
     'Stack': StackPaneDemo,
     'Split': SplitPaneDemo].each { demoLabel, demoScript ->
        noparent { demo = build(demoScript) }
        widget(demo, label: demoLabel)    
    }
}
