package groovyedit

// auto import by default
// import groovy.beans.Bindable
import griffon.transform.PropertyListener
import javax.swing.event.ChangeEvent
import javax.swing.event.ChangeListener

class GroovyEditModel implements ChangeListener {
    // binding proxy
    final DocumentProxy documentProxy = new DocumentProxy()

    @Bindable @PropertyListener(mvcUpdater)
    String mvcId

    // listens to changes on the mvcId property
    private mvcUpdater = { e ->
        Document document = null
        if(e.newValue) {
            document = app.models[e.newValue]?.document
        }
        if (!document) {
            document = new Document()
        }
        documentProxy.document = document
    }

    // listens to tab selection; updates the mvcId property
    void stateChanged(ChangeEvent e) {
        int selectedIndex = e.source.selectedIndex
        if(selectedIndex < 0) {
            setMvcId(null) 
        } else {
            def tab = e.source[selectedIndex]
            setMvcId(tab.getClientProperty('mvcId'))
        }
    }
}
