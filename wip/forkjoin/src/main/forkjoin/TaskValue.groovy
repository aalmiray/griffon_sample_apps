package forkjoin

import groovy.beans.Bindable
import net.sf.jtreemap.swing.Value

class TaskValue extends DefaultValue {
    public enum State {
        NORMAL,
        WAIT,
        SCHEDULED,
        FINISHED
    }

    @Bindable State state = NORMAL
}
