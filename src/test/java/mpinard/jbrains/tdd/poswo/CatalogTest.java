package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest {

    @Test
    public void productNotFoundForEmptyCatalog() {
        final Catalog catalog = new Catalog(new HashMap<>());
        
        final Barcode barcode = new Barcode();
        
        assertThat(catalog.getPrice(barcode).isPresent()).isFalse();
    }

    @Test
    public void productFoundAfterAddedToCatalog() {
        final Barcode barcode = new Barcode();
        final Price price = new Price();

        final Catalog catalog = new Catalog(new HashMap<Barcode, Price>() {{
            put(barcode, price);
        }});
        
        assertThat(catalog.getPrice(barcode)).isEqualTo(Optional.of(price));
    }
    
    @Test
    public void catalogHasDifferentProductsWithDifferentPrices() {
        final Barcode barcode1 = new Barcode();
        final Price price1 = new Price();
        
        final Barcode barcode2 = new Barcode();
        final Price price2 = new Price();
        
        final Catalog catalog = new Catalog(new HashMap<Barcode, Price>() {{
            put(barcode1, price1);
            put(barcode2, price2);
        }});
        
        assertThat(catalog.getPrice(barcode1)).isEqualTo(Optional.of(price1));
        assertThat(catalog.getPrice(barcode2)).isEqualTo(Optional.of(price2));
    }

    @Test
    public void changeMapAfterCatalogCreationDoesNotAffectCatalog() {
        final Barcode barcode = new Barcode();
        final Price price = new Price();

        final Map<Barcode, Price> barCodeToPrice = new HashMap<Barcode, Price>() {{
            put(barcode, price);
        }};
        
        final Catalog catalog = new Catalog(barCodeToPrice);

        assertThat(catalog.getPrice(barcode)).isEqualTo(Optional.of(price));
        
        barCodeToPrice.clear();
        
        assertThat(catalog.getPrice(barcode)).isEqualTo(Optional.of(price));
    }
}
