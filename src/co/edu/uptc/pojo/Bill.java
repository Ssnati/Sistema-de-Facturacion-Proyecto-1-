package co.edu.uptc.pojo;

public class Bill {
    private BillHeader billHeader;
    private BillBody billBody;
    private BillFooter billFooter;

    public Bill(String billId, Person person) {
        billHeader = new BillHeader(billId, person);
        billBody = new BillBody();
        billFooter = new BillFooter();
    }

    public Bill(String idBill) {
        billHeader = new BillHeader(idBill,null);
        billBody = new BillBody();
        billFooter = new BillFooter();
    }

    public BillHeader getBillHeader() {
        return billHeader;
    }

    public BillBody getBillBody() {
        return billBody;
    }

    public BillFooter getBillFooter() {
        return billFooter;
    }

    public void addProduct(Product product, int quantity) {
        billBody.addProduct(product, quantity);
        billFooter.addProduct(product, quantity);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billHeader=" + billHeader.toString() +
                ", billBody=" + billBody.toString() +
                ", billFooter=" + billFooter.toString() +
                '}';
    }
}
