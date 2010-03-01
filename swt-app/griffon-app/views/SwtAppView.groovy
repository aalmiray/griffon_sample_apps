import org.eclipse.swt.layout.GridData

gd = gridData(horizontalAlignment: GridData.FILL , grabExcessHorizontalSpace:true,
              verticalAlignment: GridData.FILL , grabExcessVerticalSpace:true)

application(text: "swt-app", location:[100,100], size:[320, 240]) {
    gridLayout(numColumns:1)
    label('Enter some text below', layoutData: gd)
    text(id: 'input', layoutData: gd)
    button('Click me!', layoutData: gd) {
        onEvent('Selection', controller.copyText)
    }
    text(id: 'output', editable: false, layoutData: gd)
}
