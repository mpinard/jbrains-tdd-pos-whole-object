package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest {

    private static final Barcode BARCODE1 = new Barcode("12345");
    private static final Barcode BARCODE2 = new Barcode("23456");
    private static final Price PRICE1 = new Price("3.50");
    private static final Price PRICE2 = new Price("29.99");

    @Test
    public void productNotFoundForEmptyCatalog() {
        final Catalog catalog = new Catalog(new HashMap<>());

        assertThat(catalog.getPrice(BARCODE1).isPresent()).isFalse();
    }

    @Test
    public void productFoundAfterAddedToCatalog() {
        final Catalog catalog = new Catalog(new HashMap<Barcode, Price>() {{
            put(BARCODE1, PRICE1);
        }});
        
        assertThat(catalog.getPrice(BARCODE1)).isEqualTo(Optional.of(PRICE1));
    }
    
    @Test
    public void catalogHasDifferentProductsWithDifferentPrices() {
        final Catalog catalog = new Catalog(new HashMap<Barcode, Price>() {{
            put(BARCODE1, PRICE1);
            put(BARCODE2, PRICE2);
        }});
        
        assertThat(catalog.getPrice(BARCODE1)).isEqualTo(Optional.of(PRICE1));
        assertThat(catalog.getPrice(BARCODE2)).isEqualTo(Optional.of(PRICE2));
    }

    @Test
    public void changeMapAfterCatalogCreationDoesNotAffectCatalog() {
        final Map<Barcode, Price> barCodeToPrice = new HashMap<Barcode, Price>() {{
            put(BARCODE1, PRICE1);
        }};
        
        final Catalog catalog = new Catalog(barCodeToPrice);

        assertThat(catalog.getPrice(BARCODE1)).isEqualTo(Optional.of(PRICE1));
        
        barCodeToPrice.clear();
        
        assertThat(catalog.getPrice(BARCODE1)).isEqualTo(Optional.of(PRICE1));
    }
}
