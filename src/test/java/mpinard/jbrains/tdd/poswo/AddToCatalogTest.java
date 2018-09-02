package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddToCatalogTest {

    @Test
    public void productNotFoundForEmptyCatalog() {
        final Barcode barcode = new Barcode();
        
        final Catalog catalog = new Catalog();
        
        assertThat(catalog.getPrice(barcode).isPresent()).isFalse();
        
    }
}
