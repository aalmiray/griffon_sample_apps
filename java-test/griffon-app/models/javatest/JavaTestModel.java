package javatest;

import org.codehaus.griffon.runtime.core.AbstractGriffonModel;

/**
 * Equivalent Groovy code:
 * <pre>
 * package javatest
 * 
 * class JavaTestModel {
 *     @Bindable String input
 *     @Bindable String output
 * }
 * </pre>
 */
public class JavaTestModel extends AbstractGriffonModel {
    private String input;
    private String output;

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public void setInput(String input) {
        firePropertyChange("input", this.input, this.input = input);
    }

    public void setOutput(String output) {
        firePropertyChange("output", this.output, this.output = output);
    }
}
