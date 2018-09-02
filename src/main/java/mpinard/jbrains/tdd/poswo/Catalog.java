package mpinard.jbrains.tdd.poswo;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Optional;

public class Catalog {

    private final ImmutableMap<Barcode, Price> barcodeToPrice;

    public Catalog(final Map<Barcode, Price> barCodeToPrice) {
       this.barcodeToPrice = ImmutableMap.copyOf(barCodeToPrice);
    }
    
    public Optional<Price> getPrice(final Barcode barcode) {
        if (barcodeToPrice.containsKey(barcode)) {
            return Optional.of(barcodeToPrice.get(barcode));
        } else {
            return Optional.empty();
        }
    }

}
