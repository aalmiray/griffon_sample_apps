package org.hybird.list;

public interface CellRenderer {
    Cell renderCell(ListView list, Cell cell, Object value, int row);
}
