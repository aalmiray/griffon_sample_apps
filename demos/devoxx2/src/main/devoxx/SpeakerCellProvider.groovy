package devoxx

import org.hybird.list.Cell
import org.hybird.list.CellProvider
import org.hybird.list.ListView

class SpeakerCellProvider extends CellProvider {
    final FactoryBuilderSupport builder

    SpeakerCellProvider(FactoryBuilderSupport builder) {
        this.builder = builder
    }

        @Override
    public Cell createCell(ListView list) {
        return new SpeakerCell(builder)
    }
}
