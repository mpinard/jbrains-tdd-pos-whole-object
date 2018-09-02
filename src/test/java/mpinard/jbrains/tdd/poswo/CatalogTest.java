package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest {

    private static final Barcode BARCODE1 = new Barcode("12345");
    private static final Barcode BARCODE2 = new Barcode("23456");

    @Test
    public void productNotFoundForEmptyCatalog() {
        final Catalog catalog = new Catalog(new HashMap<>());

        assertThat(catalog.getPrice(BARCODE1).isPresent()).isFalse();
    }

    @Test
    public void productFoundAfterAddedToCatalog() {
        final Price price = new Price();

        final Catalog catalog = new Catalog(new HashMap<Barcode, Price>() {{
            put(BARCODE1, price);
        }});
        
        assertThat(catalog.getPrice(BARCODE1)).isEqualTo(Optional.of(price));
    }
    
    @Test
    public void catalogHasDifferentProductsWithDifferentPrices() {
        final Price price1 = new Price();
        final Price price2 = new Price();
        
        final Catalog catalog = new Catalog(new HashMap<Barcode, Price>() {{
            put(BARCODE1, price1);
            put(BARCODE2, price2);
        }});
        
        assertThat(catalog.getPrice(BARCODE1)).isEqualTo(Optional.of(price1));
        assertThat(catalog.getPrice(BARCODE2)).isEqualTo(Optional.of(price2));
    }

    @Test
    public void changeMapAfterCatalogCreationDoesNotAffectCatalog() {
        final Price price = new Price();

        final Map<Barcode, Price> barCodeToPrice = new HashMap<Barcode, Price>() {{
            put(BARCODE1, price);
        }};
        
        final Catalog catalog = new Catalog(barCodeToPrice);

        assertThat(catalog.getPrice(BARCODE1)).isEqualTo(Optional.of(price));
        
        barCodeToPrice.clear();
        
        assertThat(catalog.getPrice(BARCODE1)).isEqualTo(Optional.of(price));
    }
}
