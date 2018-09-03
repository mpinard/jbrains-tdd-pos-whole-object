package mpinard.jbrains.tdd.poswo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PriceTest {
    
    @Test
    public void priceCreatedWithBigDecimalSameAsPriceCreatedWithString() {
        final String value1 = "14.12";
        final String value2 = "123.45";
        
        assertThat(new Price(value1)).isNotEqualTo(new Price(value2));
        assertThat(new Price(value1)).isEqualTo(new Price(new BigDecimal(value1)));
        assertThat(new Price(new BigDecimal(value2))).isEqualTo(new Price(value2));
    }
    
    @Test
    public void zeroPriceToStringDisplaysProperly() {
        final Price price = new Price(BigDecimal.ZERO);
        assertThat(price.toString()).isEqualTo("$0.00");
    }

    @Test
    public void wholeNumberPriceDisplaysProperly() {
        final Price price = new Price(BigDecimal.TEN);
        assertThat(price.toString()).isEqualTo("$10.00");
    }

    @Test
    public void priceWithOneDecimalDisplaysProperly() {
        final Price price = new Price("0.1");
        assertThat(price.toString()).isEqualTo("$0.10");
    }

    @Test
    public void toStringDisplaysPriceWithTwoDecimalPlaces() {
        final Price price = new Price("3.50");
        assertThat(price.toString()).isEqualTo("$3.50");
    }

    @Test
    public void constructPriceWithScaleMoreThanTwoCausesException() {
        constructPriceWithScaleMoreThanTwoCausesExceptionFor("3.999");
        constructPriceWithScaleMoreThanTwoCausesExceptionFor("4.001");
        constructPriceWithScaleMoreThanTwoCausesExceptionFor("5.0000001");
    }

    private void constructPriceWithScaleMoreThanTwoCausesExceptionFor(final String value) {
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() ->
            new Price(value)
        ).withMessage("Rounding necessary");
    }
    
    @Test
    public void isEqualTrueForEqualPriceValues() {
        final Price price1 = new Price("9.99");
        final Price price2 = new Price("9.99");

        assertThat(price1).isEqualTo(price2);
    }

    @Test
    public void isEqualFalseForDifferentPriceValues() {
        final Price price1 = new Price("9.99");
        final Price price2 = new Price("3.50");

        assertThat(price1).isNotEqualTo(price2);
    }

    @Test
    public void hashCodesSameForEqualPriceValues() {
        final Price price1 = new Price("9.99");
        final Price price2 = new Price("9.99");

        assertThat(price1.hashCode()).isEqualTo(price2.hashCode());
    }

}
