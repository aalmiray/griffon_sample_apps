package groovyedit

import groovy.beans.Bindable
import griffon.beans.Listener
import java.beans.PropertyChangeListener

class DocumentProxy extends Document {
    @Bindable @Listener(documentUpdater)
    Document document = new Document()

    // copies properties from document to itself
    private proxyUpdater = { e ->
        owner[e.propertyName] = e.newValue
    } as PropertyChangeListener

    // listens to changes on the document property
    private documentUpdater = { e ->
        e.oldValue?.removePropertyChangeListener(proxyUpdater)
        e.newValue?.addPropertyChangeListener(proxyUpdater)
        e.newValue?.copyTo(owner)
    }
}
