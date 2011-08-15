package org.hybird.list;

import java.util.List;
import java.util.ArrayList;

public abstract class CellProvider {
    private List<Cell> availableCells, usedCells;
    	
    public CellProvider() {
        availableCells = new ArrayList<Cell>();
        usedCells = new ArrayList<Cell>();
    }
	
    public abstract Cell createCell(ListView list);
    
    public Cell getUnusedCell(ListView list) {
    	if(availableCells.isEmpty()) {
            Cell cell = createCell(list);
            list.getView().add(cell);
            markCellAvailable(list, cell);
    	}
    	
        return availableCells.get(0);
    }
    
    public void markCellUsed(ListView list, Cell cell) {
    	usedCells.add(cell);
        availableCells.remove(cell);
    }
    
    public void markCellAvailable(ListView list, Cell cell) {
    	availableCells.add(cell);
    	usedCells.remove(cell);
    }
    
    public void markAllUsedCellsAvailable() {
    	for(int i = usedCells.size(); i-- > 0; ) {
            Cell usedCell = usedCells.get(i);
            markCellAvailable(null, usedCell);
    	}
    
    	usedCells.clear();
    }
}
