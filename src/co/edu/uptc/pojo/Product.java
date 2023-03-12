package co.edu.uptc.pojo;

public class Product {
    private String name;
    private String barCode;
    private String CIU;
    private int price;

    public Product(String name, String barCode, String CIU, int price) {
        this.name = name;
        this.barCode = barCode;
        this.CIU = CIU;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCIU() {
        return CIU;
    }

    public void setCIU(String CIU) {
        this.CIU = CIU;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}