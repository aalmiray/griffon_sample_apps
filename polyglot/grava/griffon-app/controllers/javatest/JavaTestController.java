package javatest;

import java.awt.event.ActionEvent;
import org.codehaus.griffon.runtime.core.AbstractGriffonController;

/**
 * Equivalent Groovy code<p>
 * <pre>
 * package javatest
 *
 * class JavaTestController {
 *     JavaTestModel model
 *
 *     def copy = { evt = null -&gt;
 *        model.output = model.input
 *     }
 * }
 * </pre>
 */
public class JavaTestController extends AbstractGriffonController {
    private JavaTestModel model;

    public void setModel(JavaTestModel model) {
        this.model = model;
    }

    public void copy(ActionEvent e) {
        model.setOutput(model.getInput());
    }
}
