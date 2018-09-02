package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class SellOneObjectTest {

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
}
