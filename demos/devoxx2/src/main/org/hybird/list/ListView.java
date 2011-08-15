package org.hybird.list;

import java.util.Map;
import java.util.HashMap;

import java.awt.Point;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.ListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;

public class ListView extends JScrollPane {
    private JPanel view;
    private CellProvider provider;
    private CellRenderer renderer;
    private ListViewport viewport;
    private int width, height;
    private ListModel model;
    private Map<Integer, LayoutInfo> layoutInfos;
    private Dimension tmpDimension;
    
    public ListView() {
        super(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
        view = new JPanel(null);
        setViewportView(view);
    }

    public JPanel getView() {
        return view;        
    }
    
    public void setProvider(CellProvider provider) {
        this.provider = provider;
    }
    
    @Override
    protected JViewport createViewport() {
        viewport = new ListViewport(); 
        return viewport;
    }
    
    private class ListViewport extends JViewport {
        private Point viewPosition;
        
        @Override
        public void setViewPosition(Point p) {
            super.setViewPosition(p);
            
            boolean changed = true;
            
            if(viewPosition == null) {
                viewPosition = p;
            } else {
                if(viewPosition.x != p.x || viewPosition.y != p.y) {
                    viewPosition.x = p.x;
                    viewPosition.y = p.y;
                } else {
                    changed = false;
                }
            }

            if(changed) {
                layoutComponents();
            }
        }
    }
    
    @Override
    public void setBounds(int x, int y, int width, int height) {
        boolean changed = this.width != width || this.height != height; 
        
        this.width = width;
        this.height = height;
        
        super.setBounds(x, y, width, height);
        
        if(changed) {
            layoutComponents();
        }
    }

    public void setRenderer(CellRenderer renderer) {
        this.renderer = renderer;
    }

    private static class LayoutInfo {
        public int y, height;
    }
    
    public void setModel(ListModel model) {
        this.model = model;
        layoutInfos = new HashMap<Integer, LayoutInfo>();
        layoutComponents();
    }

    public LayoutInfo setCellHeight(int row, int height) {
        LayoutInfo info = layoutInfos.get(row);
        if(info == null) {
            info = new LayoutInfo();
            layoutInfos.put(row, info);
        }
        
        info.height = height;
        return info;
    }
    
    private int knownHeight() {
    	int height = 0;
    	for(int row : layoutInfos.keySet()) {
    		height += layoutInfos.get(row).height;
        }
    	return height;
    }
    
    private void layoutComponents() {
    	if(provider == null || viewport.viewPosition == null) {
            return;
        }
        
        if(tmpDimension == null) {
            tmpDimension = new Dimension();
        }
        
        provider.markAllUsedCellsAvailable();
        
        int size = model.getSize();
        
        int y = 0;
        int row = 0;
        for( ; row < size; ++row) {
            LayoutInfo info = layoutInfos.get(row);
            if(row == 0 && info == null) {
                break;
            }

            if(info == null) {
            	System.out.println("Layout info is null for row " + row + ", pos: " 
            			+ viewport.viewPosition.y + ", fake row: " +(viewport.viewPosition.y / 16));
            	row = Math.min(viewport.viewPosition.y / 16 - 1, size);
            	y = viewport.viewPosition.y;
            	
            	// ds ce cas ci, il faudrait plutot setter le thumb au max et partir par la fin
            	
            	break;
            }
            
            if(info.y + info.height > viewport.viewPosition.y) {
                y = info.y;
                break;
            }
        }

//            row = Math.max(row - 2, 0);
//            if(layoutInfos.containsKey(row))
//            	y = layoutInfos.get(row).y;
        
        System.out.println("view pos: " + viewport.viewPosition + ", row: " + row + ", y: " + y);
        
        int i = row;
        for( ; i < size; ++i) {
            System.out.println("1Laying out row " + i);
            
            Cell cell = provider.getUnusedCell(this);
            renderer.renderCell(this, cell, model.getElementAt(i), i);
            provider.markCellUsed(this, cell);
            
            LayoutInfo info = layoutInfos.get(i);
            if(info == null) {
                cell.getPreferredSize(tmpDimension);
                info = setCellHeight(i, tmpDimension.height);
                
                info.y = y;
            }
            
            cell.setBounds(0, y, width, info.height);
            
            if(y + info.height > viewport.viewPosition.y + height) {
                if(row == 0) {
                    System.out.println("ay: " + y + ", height: " + height + ", row: " + i
                            + ", size: " + size + ", hidden: " +(size - i) + ", component count: " + view.getComponentCount());
                    tmpDimension.width = width;
                    tmpDimension.height = knownHeight() +(size - layoutInfos.size() - 1) * 32;
                    
                    System.out.println("setting view1: " + tmpDimension);
                    view.setPreferredSize(tmpDimension);
                }
                
                ++i;
                y += info.height;
                
                break;
            }
            
            y += info.height;
        }
        
        if(row != 0) {
            System.out.println("Can layout " + row + " rows from row " + i + " to the bottom: " + y + ", viewpos: " + viewport.viewPosition.y);
            
            int max = Math.min(i + row, size);
            for( ; i < max; ++i) {
                System.out.println("2Laying out row " + i);
                
                Cell cell = provider.getUnusedCell(this);
                renderer.renderCell(this, cell, model.getElementAt(i), i);
                provider.markCellUsed(this, cell);
                
                LayoutInfo info = layoutInfos.get(i);
                if(info == null) {
                    cell.getPreferredSize(tmpDimension);
                    info = setCellHeight(i, tmpDimension.height);
                    
                    info.y = y;
                }
                
                cell.setBounds(0, y, width, info.height);
                
                if(y + info.height > viewport.viewPosition.y + height) {
                    System.out.println("by: " + y + ", height: " + height + ", row: " + i
                            + ", size: " + size + ", hidden: " +(size - i) + ", component count: " + view.getComponentCount()
                            + ", max: " + max);
                    tmpDimension.width = width;
                    tmpDimension.height = y +(size - i) * 32;
                    tmpDimension.height = knownHeight() +(size - layoutInfos.size()) * 32;
                    //System.out.println("setting view2: " + tmpDimension);
                    view.setPreferredSize(tmpDimension);
                    break;
                }
                
                y += info.height;
            }
        }

        validate();
    }
}
