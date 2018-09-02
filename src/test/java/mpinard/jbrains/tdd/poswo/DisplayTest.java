package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayTest {

    @Test
    public void displayBeforeAnyBarcodeReceived() {
        final Display display = new Display();
        assertThat(display.getText()).isEqualTo("");
    }

    @Test
    public void productNotFound() {
        final Display display = new Display();
        final Barcode barcode = new Barcode();
        
        display.setProductNotFound(barcode);

        assertThat(display.getText()).isEqualTo(String.format("Product not found for barcode %s", barcode));
    }

    @Test
    public void emptyBarcodeRead() {
        final Display display = new Display();

        display.emptyBarcodeRead();

        assertThat(display.getText()).isEqualTo("An empty barcode was read");
    }
}
