package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class SellOneProductTest {

    @Test
    public void productFoundForBarcode() {
        final Barcode barcode = new Barcode();
        final Price price = new Price();

        final Catalog catalog = new Catalog(new HashMap<Barcode, Price>() {{
            put(barcode, price);
        }});
        
        final Display display = new Display();
        final PosTerminal pos = new PosTerminal(catalog, display);

        pos.onBarcode(barcode);
        
        assertThat(display.getText()).isEqualTo(String.format("The price is %s for barcode %s", price, barcode));
    }
    
    @Test
    public void productNotFoundForBarcode() {
        final Display display = new Display();
        final Catalog catalog = new Catalog(new HashMap<>());
        final PosTerminal pos = new PosTerminal(catalog, display);
        final Barcode barcode = new Barcode();
        
        pos.onBarcode(barcode);
        
        assertThat(display.getText()).isEqualTo(String.format("Product not found for barcode %s", barcode));
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
