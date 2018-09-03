package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BarcodeTest {

    @Test
    public void toStringDisplaysBarcode() {
        final Barcode barcode = new Barcode("12345");
        assertThat(barcode.toString()).isEqualTo("12345");
    }
    
    @Test
    public void toStringOnAnotherBarcode() {
        final Barcode barcode = new Barcode("23456");
        assertThat(barcode.toString()).isEqualTo("23456");
    }

    @Test
    public void isEqualTrueForEqualBarcodeValues() {
        final Barcode barcode1 = new Barcode("12345");
        final Barcode barcode2 = new Barcode("12345");
        
        assertThat(barcode1).isEqualTo(barcode2);
    }
    
    @Test
    public void isEqualFalseForDifferentBarcodeValues() {
        final Barcode barcode1 = new Barcode("12345");
        final Barcode barcode2 = new Barcode("23456");

        assertThat(barcode1).isNotEqualTo(barcode2);
    }

    @Test
    public void hashCodesSameForEqualBarcodeValues() {
        final Barcode barcode1 = new Barcode("12345");
        final Barcode barcode2 = new Barcode("12345");

        assertThat(barcode1.hashCode()).isEqualTo(barcode2.hashCode());
    }

}
