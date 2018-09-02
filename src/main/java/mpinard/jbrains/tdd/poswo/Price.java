package mpinard.jbrains.tdd.poswo;

import java.math.BigDecimal;

public final class Price {
    
    private final BigDecimal value;
    
    public Price() {
        this(BigDecimal.ZERO);
    }

    public Price(final BigDecimal value) {
        this.value = value;
    }
}
