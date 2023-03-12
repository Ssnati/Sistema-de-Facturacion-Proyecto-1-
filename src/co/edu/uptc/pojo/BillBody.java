package co.edu.uptc.pojo;

import co.edu.uptc.model.dinamic.UptcList;

import java.util.List;

public class BillBody {
    private List<Product> productList;

    public BillBody() {
        productList = new UptcList<>();
    }

    public UptcList<Product> getProductList() {
        return (UptcList<Product>) productList;
    }

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++)
            productList.add(product);
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "BillBody{" +
                "productList=" + productList.toString() +
                '}';
    }
}
