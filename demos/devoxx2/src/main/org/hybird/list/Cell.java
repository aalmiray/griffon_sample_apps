package org.hybird.list;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Cell extends JPanel {
    private Dimension preferredSize;
    
    public Cell() {
        setLayout(new GridLayout());
    }
    
    @Override
    public void setPreferredSize(Dimension preferredSize) {
        this.preferredSize = preferredSize;
        super.setPreferredSize (preferredSize);
    }
    
    public Dimension getPreferredSize(Dimension preferredSize) {
        preferredSize.width = this.preferredSize.width;
        preferredSize.height = this.preferredSize.height;
        return preferredSize;
    }
}
