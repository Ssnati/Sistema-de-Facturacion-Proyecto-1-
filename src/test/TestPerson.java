package test;

import co.edu.uptc.pojo.Bill;
import co.edu.uptc.pojo.CashRegister;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.presenter.Presenter;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPerson {
    @Test
    public void TestAddPerson() {
        Presenter presenter = new Presenter();
        addPersons(presenter);
    }

    private void addPersons(Presenter presenter) {
        CashRegister cashRegister = presenter.getCashRegister();

        assertTrue(cashRegister.addPerson(new Person("C.C.", "1234567890", "Juan", "Perez"))); // first person added
        assertFalse(cashRegister.addPerson(new Person("C.C.", "1234567890", "Juan", "Perez"))); // repeated person
        assertTrue(cashRegister.addPerson(new Person("C.E.", "1234567890", "Laura", "Gomez"))); // new document type
        assertTrue(cashRegister.addPerson(new Person("T.I.", "9876543210", "Carlos", "Gomez"))); // new document type
        assertTrue(cashRegister.addPerson(new Person("Pasaporte", "1122334455", "Laura", "Gomez"))); // new document type
        assertEquals(4, cashRegister.getPersons().size());

        System.out.println("TestAddPerson: ");
        printPersons(cashRegister);
    }

    @Test
    public void removePersons(){
        Presenter presenter = new Presenter();

        addPersons(presenter);

        assertTrue(presenter.getCashRegister().removePerson("C.C.", "1234567890"));

        assertFalse(presenter.getCashRegister().removePerson("C.C.", "1234567890"));
        assertEquals(3, presenter.getCashRegister().getPersons().size());

        addBill(presenter);
        assertThrows(RuntimeException.class, ()->presenter.getCashRegister().removePerson("C.E.", "1234567890"));

        System.out.println("TestRemovePerson: ");
        printPersons(presenter.getCashRegister());
    }

    private void addBill(Presenter presenter) {
        presenter.getCashRegister().addBill(new Bill(1, presenter.getCashRegister().getPersons().get(0)));
    }

    @Test
    public void editPersons(){
        Presenter presenter = new Presenter();

        addPersons(presenter);

        Person person = presenter.getCashRegister().getPersons().get(0);
        addBill(presenter);
        presenter.getCashRegister().editPerson("C.C.", "1234567890", new Person("C.C.", "123567890", "Laura", "Gomez"));
        assertEquals(person, presenter.getCashRegister().getPersons().get(0));
        presenter.getCashRegister().editPerson("C.E.", "1234567890", new Person("C.E.", "123467890", "Laura", "Gomez"));
        assertNotEquals(person, presenter.getCashRegister().getPersons().get(1));
        presenter.getCashRegister().editPerson("T.I.", "9876543210", new Person("T.I.", "9876543210", "Laura", "Gomez"));
        presenter.getCashRegister().editPerson("Pasaporte", "1122334455", new Person("Pasaporte", "1122334455", "Laura", "Gomez"));


        System.out.println("TestEditPerson: ");
        printPersons(presenter.getCashRegister());
    }

    private void printPersons(CashRegister cashRegister) {
        System.out.println("Persons:");
        for (Person person : cashRegister.getPersons()) {
            System.out.println("[" + person.toString() + "]->");
        }
        System.out.println();
    }

}
