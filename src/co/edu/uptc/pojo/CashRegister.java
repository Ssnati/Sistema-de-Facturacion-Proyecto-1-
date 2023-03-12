package co.edu.uptc.pojo;

import co.edu.uptc.model.dinamic.UptcList;

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
        try {
            checkPersonInBills(searchPerson(documentType, document));
            persons.set(persons.indexOf(searchPerson(documentType, document)), newPerson);
        } catch (RuntimeException e) {
            searchPerson(documentType,document).setName(newPerson.getName());
            searchPerson(documentType,document).setLastName(newPerson.getLastName());
            searchPerson(documentType,document).setAddress(newPerson.getAddress());
            searchPerson(documentType, document).setCity(newPerson.getCity());
        }
    }

    private Person searchPerson(String documentType, String document) {
        for (Person person : persons) {
            if (person.getDocumentType().equals(documentType) && person.getDocumentNumber().equals(document)) return person;
        }
        return null;
    }
    public Person findPerson(String character) {
        for (Person person : persons) {
            if (person.getDocumentType().equals(character) ||
                    person.getName().equals(character) ||
                    person.getAddress().equals(character) ||
                    person.getCity().equals(character) ||
                    person.getLastName().equals(character) ||
                    person.getDocumentNumber().equals(character)) return person;
        }
        return null;
    }

    public void addProduct(String tomates, int i) {

    }

    public void addProductToBill(String cocaCola, int i, String juan) {

    }

    public void addBill(Bill bill) {
        bills.add(bill);
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
