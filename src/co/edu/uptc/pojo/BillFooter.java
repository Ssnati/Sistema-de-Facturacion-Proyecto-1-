package co.edu.uptc.pojo;

public class BillFooter {
    private final double IVA = 0.19;
    private double total;
    private double totalWithIva;

    public BillFooter() {
        total = 0;
        totalWithIva = 0;
    }

    public void addProduct(Product product, int quantity) {
        total = product.getPrice() * quantity;
        double iva = total * IVA;
        totalWithIva = total + iva;
    }

    public double getTotalWithIva() {
        return totalWithIva;
    }

    @Override
    public String toString() {
        return "BillFooter{" +
                "IVA=" + IVA +
                ", total=" + total +
                ", totalWithIva=" + totalWithIva +
                '}';
    }
}
