tabPane(styles: "{padding: 4, tabOrientation: 'vertical'}") {
    ['CardPane': CardPaneDemo/*,
     'TabPane': TabPaneDemo,
     'Accordion': AccordionDemo,
     'Expander': ExpanderDemo,
     'Rollup': RollupDemo,
     'ScrollPane': ScrollPane,
     'Panorama': PanoramaDemo*/].each { demoLabel, demoScript ->
        noparent { demo = build(demoScript) }
        widget(demo, label: demoLabel)    
    }
}
