package mpinard.jbrains.tdd.poswo;

import java.util.Objects;

public final class Barcode {
    public static final Barcode EMPTY = new Barcode("");

    private final String value;

    public Barcode(final String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Barcode barcode = (Barcode) o;

        return Objects.equals(value, barcode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
