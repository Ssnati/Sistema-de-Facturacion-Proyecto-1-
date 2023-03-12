package co.edu.uptc.pojo;

public class Bill {
    private BillHeader billHeader;
    private BillBody billBody;
    private BillFooter billFooter;

    public Bill(int billId, Person person) {
        billHeader = new BillHeader(billId, person);
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
}
