package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayTest {
    private static final Barcode BARCODE = new Barcode("12345");

    @Test
    public void displayBeforeAnyBarcodeReceived() {
        final Display display = new Display();
        assertThat(display.getText()).isEqualTo("");
    }

    @Test
    public void productNotFound() {
        final Display display = new Display();
        
        display.setProductNotFound(BARCODE);

        assertThat(display.getText()).isEqualTo(String.format("Product not found for barcode %s", BARCODE));
    }

    @Test
    public void emptyBarcodeRead() {
        final Display display = new Display();

        display.emptyBarcodeRead();

        assertThat(display.getText()).isEqualTo("An empty barcode was read");
    }
}
