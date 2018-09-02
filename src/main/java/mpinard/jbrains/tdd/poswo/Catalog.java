package mpinard.jbrains.tdd.poswo;

import java.util.Optional;

public class Catalog {

    private final Barcode barcode;
    private final Price price;

    public Catalog(final Barcode barcode, final Price price) {
        this.barcode = barcode;
        this.price = price;
    }

    public Catalog() {
        this.barcode = new Barcode();
        this.price = new Price();
        
    }
    public Barcode getBarcode() {
        return barcode;
    }

    public Optional<Price> getPrice(final Barcode barcode) {
        if (this.barcode == barcode) {
            return Optional.of(price);
        } else {
            return Optional.empty();
        }
    }
}
