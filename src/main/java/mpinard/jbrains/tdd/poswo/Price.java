package mpinard.jbrains.tdd.poswo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Price {

    private final BigDecimal value;

    public Price(final String stringValue) {
        this(new BigDecimal(stringValue));
    }

    public Price(final BigDecimal value) {
        this.value = value.setScale(2, RoundingMode.UNNECESSARY);
    }

    @Override
    public String toString() {
        return String.format("$%s", value);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        final Price price = (Price) other;

        return Objects.equals(value, price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
