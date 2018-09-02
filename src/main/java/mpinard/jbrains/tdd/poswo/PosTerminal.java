package mpinard.jbrains.tdd.poswo;

import java.util.Optional;

public class PosTerminal {
    
    private Catalog catalog;
    private Display display;

    public PosTerminal(final Catalog catalog, final Display display) {
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(final Barcode barcode) {
        if (barcode == Barcode.EMPTY) {
            display.emptyBarcodeRead();
            return;
        }
        
        final Optional<Price> price = catalog.getPrice(barcode);
        
        if (price.isPresent()) {
            display.setPrice(barcode, price.get());
        } else {
            display.setProductNotFound(barcode);
        }
    }
}
