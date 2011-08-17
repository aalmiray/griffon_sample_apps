package sample

class SampleController {
    def model
    def view
    def builder

    void mvcGroupInit(Map args) {
        (1..7).each { index ->
            def (m, v, c) = createMVCGroup('viewer', 'viewer' + index, [index: index])
            builder.tabbedPane(view.tabs) {
                widget(v.viewer, title: 'Example ' + index)
            }
        }
    }
}
