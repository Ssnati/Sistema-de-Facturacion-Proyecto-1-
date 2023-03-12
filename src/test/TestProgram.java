package test;

import co.edu.uptc.pojo.*;
import co.edu.uptc.presenter.Presenter;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestProgram {
    private static final String MANUFACTURER_NUMBER = "123456789";

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
    public void TestRemovePersons() {
        Presenter presenter = new Presenter();

        addPersons(presenter);
        addProducts(presenter);

        assertTrue(presenter.getCashRegister().removePerson("C.C.", "1234567890"));

        assertFalse(presenter.getCashRegister().removePerson("C.C.", "1234567890"));
        assertEquals(3, presenter.getCashRegister().getPersons().size());

        addBill(presenter);
        assertThrows(RuntimeException.class, () -> presenter.getCashRegister().removePerson("C.E.", "1234567890"));

        System.out.println("TestRemovePerson: ");
        printPersons(presenter.getCashRegister());
    }

    private void addBill(Presenter presenter) {
        Bill bill = new Bill(1, presenter.getCashRegister().getPersons().get(0));
        bill.addProduct(presenter.getCashRegister().getProducts().get(0), 7);
        presenter.getCashRegister().addBill(bill);
    }

    @Test
    public void TestEditPersons() throws Exception {
        Presenter presenter = new Presenter();

        addPersons(presenter);
        addProducts(presenter);

        Person person = presenter.getCashRegister().getPersons().get(0);
        addBill(presenter);
        presenter.getCashRegister().editPerson("C.C.", "1234567890", new Person("C.C.", "123567890", "Laura", "Gomez"));
        assertEquals(person, presenter.getCashRegister().getPersons().get(0));
        presenter.getCashRegister().editPerson("C.E.", "1234567890", new Person("C.E.", "123467890", "Laura", "Gomez"));
        assertNotEquals(person, presenter.getCashRegister().getPersons().get(1));
        presenter.getCashRegister().editPerson("T.I.", "9876543210", new Person("T.I.", "9876543210", "Laura", "Gomez"));
        presenter.getCashRegister().editPerson("Pasaporte", "1122334455", new Person("Pasaporte", "1122334455", "Laura", "Gomez"));
        assertThrows(RuntimeException.class,()->presenter.getCashRegister().editPerson("Pasaporte", "1122334455", new Person("T.I.", "9876543210", "Laura", "Gomez")));


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

    @Test
    public void TestAddProduct() {
        Presenter presenter = new Presenter();
        addProducts(presenter);
    }

    private void addProducts(Presenter presenter) {
        String ciu = CIUGenerator.generateCIU();
        assertTrue(presenter.getCashRegister().addProduct(new Product("Coca Cola 1.5L", EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu), ciu,
                1000)));
        assertFalse(presenter.getCashRegister().addProduct(new Product("Coca Cola 5L", EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu), ciu,
                5000)));
        ciu = CIUGenerator.generateCIU();
        assertTrue(presenter.getCashRegister().addProduct(new Product("Coca Cola 7L", EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu), ciu,
                5000)));
        ciu = CIUGenerator.generateCIU();
        assertTrue(presenter.getCashRegister().addProduct(new Product("Pepsi 1.5L", EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu), ciu,
                1000)));
        ciu = CIUGenerator.generateCIU();
        assertTrue(presenter.getCashRegister().addProduct(new Product("Pepsi 5L", EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu), ciu,
                1000)));
        ciu = CIUGenerator.generateCIU();
        assertTrue(presenter.getCashRegister().addProduct(new Product("Pepsi 7L", EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu), ciu,
                1000)));

        assertEquals(5, presenter.getCashRegister().getProducts().size());

        System.out.println("TestAddProduct: ");
        printProducts(presenter.getCashRegister());

    }

    private void printProducts(CashRegister cashRegister) {
        System.out.println("Products:");
        for (Product product : cashRegister.getProducts()) {
            System.out.println("[" + product.toString() + "]->");
        }
        System.out.println();
    }

    @Test
    public void TestRemoveProduct() {
        Presenter presenter = new Presenter();
        addPersons(presenter);
        addProducts(presenter);

        Product product = presenter.getCashRegister().getProducts().get(0);
        assertTrue(presenter.getCashRegister().removeProduct(product.getBarCode(), product.getCIU()));
        assertFalse(presenter.getCashRegister().removeProduct(product.getBarCode(), product.getCIU()));

        Product product1 = presenter.getCashRegister().getProducts().get(0);
        assertEquals(4, presenter.getCashRegister().getProducts().size());

        addBill(presenter);
        assertThrows(RuntimeException.class, () -> presenter.getCashRegister().removeProduct(product1.getBarCode(), product1.getCIU()));

        System.out.println("TestRemoveProduct: ");
        printProducts(presenter.getCashRegister());
    }

    @Test
    public void TestEditProduct() throws Exception {
        Presenter presenter = new Presenter();

        addPersons(presenter);
        addProducts(presenter);

        Product product = presenter.getCashRegister().getProducts().get(0);
        Product product1 = presenter.getCashRegister().getProducts().get(1);

        addBill(presenter);
        presenter.getCashRegister().editProduct(product.getBarCode(), product.getCIU(), new Product("Coca Cola 15L", EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, product.getCIU()), product.getCIU(),
                9000));
        assertEquals(product, presenter.getCashRegister().getProducts().get(0));

        presenter.getCashRegister().editProduct(product1.getBarCode(), product1.getCIU(), new Product("Coca Cola 70L", EAN13Generator.generateBarcode(MANUFACTURER_NUMBER+1, product1.getCIU()), product1.getCIU(),
                19000));
        assertNotEquals(product1, presenter.getCashRegister().getProducts().get(1));

        System.out.println("TestEditProduct: ");
        printProducts(presenter.getCashRegister());
    }
}
