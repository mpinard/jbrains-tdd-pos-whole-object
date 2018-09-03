package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class SellOneProductTest {
    private static final Barcode BARCODE1 = new Barcode("12345");
    private static final Price PRICE1 = new Price("7.89");
    private static final Barcode BARCODE2 = new Barcode("23456");
    private static final Price PRICE2 = new Price("3.50");

    @Test
    public void productFoundForBarcode() {
        final Catalog catalog = new Catalog(new HashMap<Barcode, Price>() {{
            put(BARCODE1, PRICE1);
            put(BARCODE2, PRICE2);
        }});
        
        final Display display = new Display();
        final PosTerminal pos = new PosTerminal(catalog, display);

        pos.onBarcode(BARCODE1);

        assertThat(display.getText()).isEqualTo("The price is $7.89 for barcode 12345");
        assertThat(display.getText()).isEqualTo(String.format("The price is %s for barcode %s", PRICE1, BARCODE1));
        
        pos.onBarcode(BARCODE2);
        
        assertThat(display.getText()).isEqualTo(String.format("The price is %s for barcode %s", PRICE2, BARCODE2));
    }
    
    @Test
    public void productNotFoundForBarcode() {
        final Display display = new Display();
        final Catalog catalog = new Catalog(new HashMap<>());
        final PosTerminal pos = new PosTerminal(catalog, display);
        
        pos.onBarcode(BARCODE1);
        
        assertThat(display.getText()).isEqualTo(String.format("Product not found for barcode %s", BARCODE1));
    }
    
    @Test
    public void emptyBarcodeRead() {
        final Catalog catalog = new Catalog(new HashMap<>());
        final Display display = new Display();
        final PosTerminal pos = new PosTerminal(catalog, display);

        pos.onBarcode(Barcode.EMPTY);
        
        assertThat(display.getText()).isEqualTo("An empty barcode was read");
    }

}
