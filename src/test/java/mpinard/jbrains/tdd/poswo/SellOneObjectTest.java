package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SellOneObjectTest {

    @Test
    public void productFoundForBarcode() {
        final Barcode barcodeProduct1 = new Barcode();
        final Price priceProduct1 = new Price();

        final Catalog catalog = new Catalog(barcodeProduct1, priceProduct1);
        final Display display = new Display();
        final PosTerminal pos = new PosTerminal(catalog, display);

        pos.onBarcode(barcodeProduct1);
        
        assertThat(display.getText()).isEqualTo(String.format("The price is %s for barcode %s", priceProduct1, barcodeProduct1));
    }
}
