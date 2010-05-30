import griffon.effects.*

class EffectsController {
    def model
    def view

    void mvcGroupInit(Map args) {
        [Move, Resize, Bounds, Scale].each { effectClass ->
            String name = effectClass.simpleName
            def (m, v, c) = createMVCGroup(name, parentModel: model,
                                           effectClass: effectClass, target: view.window)
            view.panes.add(v.box, name)
        }

        def map = buildMVCGroup('Misc', parentModel: model, target: view.window)
        view.panes.add(map.view.box, 'Miscellaneous')
        model.currentPage = view.panes.layout.cardNameAt(0i)
    }

    def previousPage = { evt = null ->
        setPageName(-1)
        view.panes.layout.previous(view.panes)
    }

    def nextPage = { evt = null ->
        setPageName(1)
        view.panes.layout.next(view.panes)
    }

    def setPageName = { int dx ->
        def layout = view.panes.layout
        int currentIndex = layout.getCurrentCardIndex(view.panes)
        int cardCount = layout.cardCount
        int index = currentIndex + dx
        index = index < 0 ? cardCount - 1 : index
        index = index >= cardCount ? 0i : index
        model.currentPage = layout.cardNameAt(index as int)
    }

    def onReadyEnd = { app ->
        model.reset()
    }
}
