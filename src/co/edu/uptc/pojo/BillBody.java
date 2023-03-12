package co.edu.uptc.pojo;

import co.edu.uptc.model.dinamic.UptcList;

public class BillBody {
    private int itemNumber;
    private UptcList<Product> productList;

    public BillBody() {
        productList = new UptcList<>();
        itemNumber = 0;
    }

    public UptcList<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product, int quantity) {
        itemNumber++;
        for (int i = 0; i < quantity; i++)
            productList.add(product);
    }
}
