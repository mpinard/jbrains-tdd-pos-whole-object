package mpinard.jbrains.tdd.poswo;

public class PosTerminal {
    
    private Catalog catalog;
    private Display display;

    public PosTerminal(final Catalog catalog, final Display display) {
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(final Barcode barcode) {
        final Price price = catalog.getPrice();
        display.setPrice(barcode, price);
    }
}
