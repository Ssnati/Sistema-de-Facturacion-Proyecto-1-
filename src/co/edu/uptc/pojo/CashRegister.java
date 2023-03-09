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
    public boolean addPerson(String documentType, String document, String name, String lastName) {
        return persons.add(new Person(documentType, document, name, lastName));
    }

    public void removePerson(String read) {

    }

    public String listPersons() {
        return null;
    }
    public Person findPerson(String character) {
        for (Person person : persons) {
            if (person.getName().equals(character)) return person;
        }
        return null;
    }

    public void addProduct(String tomates, int i) {

    }

    public void addProductToBill(String cocaCola, int i, String juan) {

    }
}
