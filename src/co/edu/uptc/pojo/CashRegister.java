package co.edu.uptc.pojo;

import co.edu.uptc.model.dinamic.UptcList;

import java.util.List;

public class CashRegister {
    private UptcList<Person> persons;
    private UptcList<Product> products;
    private UptcList<Bill> bills;

    public CashRegister() {
        persons = new UptcList<>();
        products = new UptcList<>();
        bills = new UptcList<>();
    }

    public boolean addPerson(Person person) {
        if (searchPerson(person.getDocumentType(), person.getDocumentNumber()) == null) return persons.add(person);
        return false;
    }

    public boolean removePerson(String documentType, String document) throws RuntimeException {
        Person person = searchPerson(documentType, document);
        if (person != null) {
            checkPersonInBills(person);
            return persons.remove(searchPerson(documentType, document));
        } else {
            return false;
        }
    }

    private void checkPersonInBills(Person person) {
        for (Bill bill : bills) {
            if (bill.getBillHeader().getPerson().getDocumentNumber().equals(person.getDocumentNumber()) &&
                    bill.getBillHeader().getPerson().getDocumentType().equals(person.getDocumentType())) {
                throw new RuntimeException("The person is in a bill");
            }
        }
    }

    public void editPerson(String documentType, String document, Person newPerson) {
        boolean flag = false;
        try {
            checkPersonInBills(searchPerson(documentType, document));
            flag = true;
            checkNewPersonNotExists(documentType, document, newPerson);
            persons.set(persons.indexOf(searchPerson(documentType, document)), newPerson);
        } catch (RuntimeException e) {
            if (flag) {
                throw e;
            } else {
                searchPerson(documentType, document).setName(newPerson.getName());
                searchPerson(documentType, document).setLastName(newPerson.getLastName());
                searchPerson(documentType, document).setAddress(newPerson.getAddress());
                searchPerson(documentType, document).setCity(newPerson.getCity());
            }
        }
    }

    private void checkNewPersonNotExists(String documentType, String document, Person newPerson) {
        UptcList<Person> list = new UptcList<>();
        list.addAll(persons);
        persons.remove(searchPerson(documentType, document));
        if (searchPerson(newPerson.getDocumentType(), newPerson.getDocumentNumber()) != null) {
            persons = list;
            throw new RuntimeException("The person is in the list");
        } else {
            persons = list;
        }
    }

    private Person searchPerson(String documentType, String document) {
        for (Person person : persons) {
            if (person.getDocumentType().equals(documentType) && person.getDocumentNumber().equals(document))
                return person;
        }
        return null;
    }

    public List<Person> searchAllPersons(String character) {
        UptcList<Person> list = new UptcList<>();
        for (Person person : persons) {
            if (person.getDocumentType().equals(character) ||
                    person.getName().equals(character) ||
                    person.getAddress().equals(character) ||
                    person.getCity().equals(character) ||
                    person.getLastName().equals(character) ||
                    person.getDocumentNumber().equals(character)) list.add(person);
        }
        return list;
    }

    public boolean addProduct(Product product) {
        if (searchProduct(product.getBarCode(), product.getCIU()) == null) {
            return products.add(product);
        }
        return false;
    }

    public boolean removeProduct(String barCode, String ciu) throws RuntimeException {
        if (searchProduct(barCode, ciu) != null) {
            checkProductInBills(searchProduct(barCode, ciu));
            return products.remove(searchProduct(barCode, ciu));
        } else {
            return false;
        }
    }

    private void checkProductInBills(Product searchProduct) {
        for (Bill bill : bills) {
            for (Product product : bill.getBillBody().getProductList()) {
                if (product.getBarCode().equals(searchProduct.getBarCode()) && product.getCIU().equals(searchProduct.getCIU())) {
                    throw new RuntimeException("The product is in a bill");
                }
            }
        }
    }

    public void editProduct(String barCode, String ciu, Product newProduct) {
        boolean check = false;
        try {
            checkProductInBills(searchProduct(barCode, ciu));
            check = true;
            checkNewProductNotExists(barCode, ciu, newProduct);
            products.set(products.indexOf(searchProduct(barCode, ciu)), newProduct);
        } catch (RuntimeException ignored) {
            if (check) throw new RuntimeException("The product already exists");
        }
    }

    private void checkNewProductNotExists(String barCode, String ciu, Product newProduct) {
        UptcList<Product> list = new UptcList<>();
        list.addAll(products);
        products.remove(searchProduct(barCode, ciu));
        if (searchProduct(newProduct.getBarCode(), newProduct.getCIU()) != null) {
            products = list;
            throw new RuntimeException("The product is in the list");
        } else {
            products = list;
        }
    }

    public Product searchProduct(String barCode, String ciu) {
        for (Product product : products) {
            if (product.getBarCode().equals(barCode) || product.getCIU().equals(ciu)) return product;
        }
        return null;
    }

    public List<Product> searchAllProducts(String character) {
        List<Product> list = new UptcList<>();
        for (Product product : products) {
            if (product.getName().equals(character) ||
                    product.getBarCode().equals(character) ||
                    product.getCIU().equals(character) ||
                    String.valueOf(product.getPrice()).equals(character)) list.add(product);
        }
        return list;
    }

    public void addProductToBill(String cocaCola, int i, String juan) {

    }

    public boolean addBill(Bill bill) {
        if (searchBill(bill.getBillHeader().getId()) == null) return bills.add(bill);
        return false;
    }

    public boolean removeBill(String id) {
        if (searchBill(id).getBillHeader().getPerson() != null && searchBill(id).getBillBody().getProductList().size() != 0)
            return bills.set(bills.indexOf(searchBill(id)), new Bill(id)) != null;
        return false;
    }

    public void editBill(String id, List<Product> products) {
        if (searchBill(id) != null) searchBill(id).getBillBody().setProductList(products);
    }

    public Bill searchBill(String id) {
        for (Bill bill : bills) {
            if (bill.getBillHeader().getId().equals(id)) {
                return bill;
            }
        }
        return null;
    }

    public List<Bill> searchAllBills(String character) {//pendiente por buscar alguna forma de hacerlo
        List<Bill> list = new UptcList<>();
        for (Bill bill : bills) {
            searchPersonForBill(list, character, bill);
            searchProductForBill(list, character, bill);
            if (bill.getBillHeader().getId().equals(character) ||
                    bill.getBillHeader().getDate().equals(character) ||
                    String.valueOf(bill.getBillFooter().getTotalWithIva()).equals(character)) list.add(bill);
        }
        return list;
    }

    private void searchProductForBill(List<Bill> list, String character, Bill bill) {
        for (Product product : bill.getBillBody().getProductList()) {
            if (product.getName().equals(character) ||
                    product.getBarCode().equals(character) ||
                    product.getCIU().equals(character) ||
                    String.valueOf(product.getPrice()).equals(character)) list.add(bill);
        }
    }

    private void searchPersonForBill(List<Bill> list, String character, Bill bill) {
        if (bill.getBillHeader().getPerson().getDocumentType().equals(character) ||
                bill.getBillHeader().getPerson().getDocumentNumber().equals(character) ||
                bill.getBillHeader().getPerson().getName().equals(character) ||
                bill.getBillHeader().getPerson().getLastName().equals(character) ||
                bill.getBillHeader().getPerson().getAddress().equals(character) ||
                bill.getBillHeader().getPerson().getCity().equals(character)) list.add(bill);
    }

    public String generateBillNumber() {
        StringBuilder builder = new StringBuilder(String.valueOf(bills.size() + 1));
        for (int i = 0; i < 5 - builder.length(); i++) {
            builder.insert(0, "0");
        }
        return builder.toString();
    }

    public UptcList<Person> getPersons() {
        return persons;
    }

    public UptcList<Product> getProducts() {
        return products;
    }

    public UptcList<Bill> getBills() {
        return bills;
    }

}
