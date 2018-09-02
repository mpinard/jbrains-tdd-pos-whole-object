package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class SellOneProductTest {
    private static final Barcode BARCODE = new Barcode("12345");

    @Test
    public void productFoundForBarcode() {
        final Price price = new Price();

        final Catalog catalog = new Catalog(new HashMap<Barcode, Price>() {{
            put(BARCODE, price);
        }});
        
        final Display display = new Display();
        final PosTerminal pos = new PosTerminal(catalog, display);

        pos.onBarcode(BARCODE);
        
        assertThat(display.getText()).isEqualTo(String.format("The price is %s for barcode %s", price, BARCODE));
        assertThat(display.getText()).isEqualTo(String.format("The price is %s for barcode %s", price, "12345"));
    }
    
    @Test
    public void productNotFoundForBarcode() {
        final Display display = new Display();
        final Catalog catalog = new Catalog(new HashMap<>());
        final PosTerminal pos = new PosTerminal(catalog, display);
        
        pos.onBarcode(BARCODE);
        
        assertThat(display.getText()).isEqualTo(String.format("Product not found for barcode %s", BARCODE));
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
