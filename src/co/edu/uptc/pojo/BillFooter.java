package co.edu.uptc.pojo;

public class BillFooter {
    private double totalWithIva;

    public BillFooter() {
        totalWithIva = 0;
    }

    public void addProduct(Product product, int quantity) {
        double total = product.getPrice() * quantity;
        double iva = total * 0.19;
        totalWithIva = total + iva;
    }

    public double getTotalWithIva() {
        return totalWithIva;
    }
}
