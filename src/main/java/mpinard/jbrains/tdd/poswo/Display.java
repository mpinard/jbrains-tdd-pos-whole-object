package mpinard.jbrains.tdd.poswo;

public class Display {

    private String text = "";

    public String getText() {
        return text;
    }

    public void setPrice(final Barcode barcode, final Price price) {
        this.text = String.format("The price is %s for barcode %s", price, barcode);
    }

    public void setProductNotFound(final Barcode barcode) {
        this.text = String.format("Product not found for barcode %s", barcode);
    }

    public void emptyBarcodeRead() {
        this.text = "An empty barcode was read";
    }
}
