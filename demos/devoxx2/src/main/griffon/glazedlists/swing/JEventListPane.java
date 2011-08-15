/* Glazed Lists                                                 (c) 2003-2006 */
/* http://publicobject.com/glazedlists/                      publicobject.com,*/
/*                                                     O'Dell Engineering Ltd.*/
package griffon.glazedlists.swing;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.TransformedList;
import ca.odell.glazedlists.event.ListEvent;
import ca.odell.glazedlists.event.ListEventListener;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A panel that shows the contents of an EventList containing JComponents.
 *
 * <p><table border="1" width="100%" cellpadding="3" cellspacing="0">
 * <tr class="TableHeadingColor"><td colspan="2"><font size="+2"><b>Extension: MigLayout</b></font></td></tr>
 * <tr><td  colspan="2">This Glazed Lists <i>extension</i> requires the third party library <b>MigLayout</b>.</td></tr>
 * <tr><td class="TableSubHeadingColor"><b>Tested Version:</b></td><td>3.7.3.1</td></tr>
 * <tr><td class="TableSubHeadingColor"><b>Home page:</b></td><td><a href="http://www.miglayout.com/">http://www.miglayout.com/</a></td></tr>
 * <tr><td class="TableSubHeadingColor"><b>License:</b></td><td><a href="http://www.opensource.org/licenses/bsd-license.html">BSD</a></td></tr>
 * </td></tr>
 * </table>
 *
 * <p>To use {@link JEventListPane}:
 * <ol>
 *   <li>Create an {@link EventList} of {@link JComponent}s, or any
 *       objects that reference a set of {@link JComponent}s.
 *   <li>Implement {@link JEventListPane.MigFormat} for the object's in your
 *       {@link EventList}. This interface defines how a single cell is layed out.
 *       Once the layout for a single cell is known, all cells can be tiled to
 *       show all of the {@link JComponent}s in your {@link EventList}.
 *   <li>Create an {@link JEventListPane} and add it in your application somewhere.
 *       If the number of elements in the {@link EventList} may grow unbounded,
 *       wrap your {@link JEventListPane} in a {@link JScrollPane}.
 * </ol>
 *
 * This is a carbon copy of {@code ca.odell.glazedlists.swing.JEventListPanel}<p>
 *
 * @author Andres Almiray
 * @author <a href="mailto:jesse@odell.ca">Jesse Wilson</a>
 */
public final class JEventListPane<E> extends JPanel {
    /** the source contains all the JComponents */
    private TransformedList<E,E> swingSource;

    /** the components of the panel */
    private List<JComponent[]> components = new ArrayList<JComponent[]>();

    /** the layout supports a migLayout under the hood */
    private final MigListLayout migListLayout;

    /** the format specifies what an element cell looks like */
    private final MigFormat<E> format;

    /** handle changes to the source {@link EventList} */
    private final SourceChangeHandler sourceChangeHandler = new SourceChangeHandler();

    /**
     * Creates a new {@link JEventListPane} hosting the
     * {@link JComponent}s from the specified source {@link EventList}.
     */
    public JEventListPane(EventList<E> source, MigFormat<E> format) {
        this.swingSource = GlazedListsSwing.swingThreadProxyList(source);
        this.migListLayout = new MigListLayout(this, format);
        this.format = format;
        this.setLayout(migListLayout);

        // populate the initial elements
        for(int i = 0; i < swingSource.size(); i++) {
            sourceChangeHandler.insert(i);
        }

        // listen for changes to the source
        swingSource.addListEventListener(sourceChangeHandler);
    }

    /**
     * Limit the number of list elements will be layed out along the X axis.
     * This is the number of logical columns, which may differ from the layout
     * columns used within each cell.
     *
     * <p>Note that when the columns are limited, rows are automatically unlimited.
     *
     * @param elementColumns the number of logical columns, between 1 and
     *      {@link Integer#MAX_VALUE}.
     */
    public void setElementColumns(int elementColumns) {
        if(elementColumns < 1) throw new IllegalArgumentException("elementColumns must be in the range [1, " + Integer.MAX_VALUE + "]");
        migListLayout.setElementColumns(elementColumns);
    }

    /**
     * Limit the number of list elements will be layed out along the Y axis.
     * This is the number of logical rows, which may differ from the layout
     * rows used within each cell.
     *
     * <p>Note that when the rows are limited, columns are automatically unlimited.
     *
     * @param elementRows the number of logical rows, between 1 and
     *      {@link Integer#MAX_VALUE}.
     */
    public void setElementRows(int elementRows) {
        if(elementRows < 1) throw new IllegalArgumentException("elementRows must be in the range [1, " + Integer.MAX_VALUE + "]");
        migListLayout.setElementRows(elementRows);
    }

    /**
     * Provide the binding between this panel and the source {@link EventList}.
     */
    private class SourceChangeHandler implements ListEventListener {
        /**
         * Handle an inserted element.
         */
        private void insert(int index) {
            // save the components
            E element = swingSource.get(index);
            JComponent[] elementComponents = new JComponent[format.getComponentsPerElement()];
            for(int c = 0; c < elementComponents.length; c++) {
                elementComponents[c] = format.getComponent(element, c);
            }

            // remember these components
            components.add(index, elementComponents);

            migListLayout.insertIndex(index);

            // insert the components
            for(int c = 0; c < elementComponents.length; c++) {
                if(elementComponents[c] == null) continue;
                add(elementComponents[c], new MigListLayout.Constraints(c, index));
            }
        }

        /**
         * Handle a deleted element.
         */
        private void delete(int index) {
            // remove the components
            JComponent[] elementComponents = components.get(index);
            for(int c = 0; c < elementComponents.length; c++) {
                if(elementComponents[c] == null) continue;
                remove(elementComponents[c]);
            }

            // forget the components
            components.remove(index);

            // collapse the row from the layout
            migListLayout.removeIndex(index);
        }

        /**
         * Handle an updated element.
         */
        private void update(int index) {
            // get the old components
            JComponent[] oldElementComponents = components.get(index);

            // get the new components
            E element = swingSource.get(index);
            JComponent[] newElementComponents = new JComponent[format.getComponentsPerElement()];
            for(int c = 0; c < newElementComponents.length; c++) {
                newElementComponents[c] = format.getComponent(element, c);
            }

            // swap as necessary
            for(int c = 0; c < oldElementComponents.length; c++) {
                if(oldElementComponents[c] == newElementComponents[c]) continue;
                if(oldElementComponents[c] != null) {
                    remove(oldElementComponents[c]);
                }
                if(newElementComponents[c] != null) {
                    add(newElementComponents[c], new MigListLayout.Constraints(c, index));
                }
            }

            // save the latest components
            components.set(index, newElementComponents);

            // update the row in the layout
            migListLayout.updateIndex(index);
        }

        /**
         * When the components list changes, this updates the panel.
         */
        public void listChanged(ListEvent listChanges) {
            while(listChanges.next()) {
                int type = listChanges.getType();
                int index = listChanges.getIndex();
                if(type == ListEvent.INSERT) {
                    insert(index);
                } else if(type == ListEvent.DELETE) {
                    delete(index);
                } else if(type == ListEvent.UPDATE) {
                    update(index);
                }
            }

            // repaint the panel
            revalidate();
            repaint();
        }
    }

    /**
     * Releases the resources consumed by this {@link JEventListPane} so that it
     * may eventually be garbage collected.
     * 
     * <p><strong><font color="#FF0000">Warning:</font></strong> It is an error
     * to call any method on a {@link JEventListPane} after it has been disposed.
     */
    public void dispose() {
        swingSource.dispose();
    }

    /**
     * Specify how the JComponents of an Object are layed out in a row.
     */
    public interface MigFormat<E> {
        /**
         * Get the number of components for each row element.
         */
        int getComponentsPerElement();

        /**
         * Get the component from the specified list element.
         */
        JComponent getComponent(E element, int component);

        /**
         * Get the constraints to lay out the specified component.
         *
         * @param component the component to fetch constraints for.
         * @return constraints that specify how to lay out the component.
         */
        String getConstraints(int component);

        /**
         *
         */
        String getLayoutConstraints();

        /**
         *
         */
        String getColumnConstraints();

        /**
         *
         */
        String getRowConstraints();
    }

    /**
     * A default implementation of the {@link MigFormat} interface.
     */
    public static abstract class AbstractMigFormat<E> implements MigFormat<E> {
        protected String layoutConstraints = "";
        protected String columnConstraints = "";
        protected String rowConstraints = "";
        protected String[] constraints;

        /**
         * Construct a format using the specifications and constraints specified.
         */
        protected AbstractMigFormat(String layoutConstraints, String columnConstraints, String rowConstraints, String[] constraints) {
            this.layoutConstraints = layoutConstraints;
            this.columnConstraints = columnConstraints;
            this.rowConstraints = rowConstraints;
            this.constraints = cConstraints;
        }

        /**
         * Construct a bare format. Extending classes must populate all specs
         * or override the corresponding getters so that all appropriate
         * specifications are available.
         */
        protected AbstractMigFormat() {
            // do nothing
        }

        /** {@inheritDoc} */
        public int getComponentsPerElement() {
            return constraints.length;
        }

        /** {@inheritDoc} */
        public String getConstraints(int component) {
            return constraints[component];
        }

        /** {@inheritDoc} */
        public String getLayoutConstraints() {
            return layoutConstraints;
        }

        /** {@inheritDoc} */
        public String getColumnConstraints() {
            return columnConstraints;
        }

        /** {@inheritDoc} */
        public String getRowConstraints() {
            return rowConstraints;
        }
    }
}
