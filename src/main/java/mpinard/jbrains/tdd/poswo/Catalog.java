package mpinard.jbrains.tdd.poswo;

public class Catalog {

    private final Barcode barcode;
    private final Price price;

    public Catalog(final Barcode barcode, final Price price) {
        this.barcode = barcode;
        this.price = price;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public Price getPrice() {
        return price;
    }
}
