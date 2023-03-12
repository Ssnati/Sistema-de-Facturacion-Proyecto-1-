package co.edu.uptc.presenter;

import co.edu.uptc.pojo.*;
import co.edu.uptc.view.View;

public class Presenter {
    private final String MANUFACTURER_NUMBER = "102689356";
    private final String DEFAULT_CIU = "0000000000000";
    private final View view;
    private final CashRegister cashRegister;

    public Presenter() {
        view = new View();
        cashRegister = new CashRegister();
    }

    private void loadDefaultData() {
        {
            cashRegister.addPerson(new Person("C.C.", "123456789", "Juan", "Perez"));
            cashRegister.addPerson(new Person("C.C.", "123456789", "Juan", "Perez"));
            cashRegister.addPerson(new Person("C.E.", "987654321", "Luisa", "Gomez"));
            cashRegister.addPerson(new Person("T.I.", "456789123", "Pedro", "Ramirez"));
            cashRegister.addPerson(new Person("Pasaporte", "1122334455", "Maria", "Lopez"));
            cashRegister.addPerson(new Person("C.C.", "987654321", "Carlos", "Gonzalez"));
            cashRegister.addPerson(new Person("C.E.", "123456789", "Ana", "Jimenez"));
            cashRegister.addPerson(new Person("T.I.", "789456123", "David", "Santos"));
            cashRegister.addPerson(new Person("Pasaporte", "2233445566", "Mariana", "Castro"));
            cashRegister.addPerson(new Person("C.C.", "147258369", "Andres", "Rodriguez"));
            cashRegister.addPerson(new Person("C.E.", "369258147", "Isabella", "Fernandez"));
            cashRegister.addPerson(new Person("T.I.", "258369147", "Diego", "Hernandez"));
            cashRegister.addPerson(new Person("Pasaporte", "3344556677", "Camila", "Suarez"));
            cashRegister.addPerson(new Person("C.C.", "963852741", "Sofia", "Morales"));
            cashRegister.addPerson(new Person("C.E.", "741852963", "Felipe", "Rojas"));
            cashRegister.addPerson(new Person("T.I.", "123789456", "Laura", "Alvarez"));
            cashRegister.addPerson(new Person("C.C.", "753159684", "Juan", "Garcia"));
            cashRegister.addPerson(new Person("C.E.", "951753684", "Luisa", "Ramirez"));
            cashRegister.addPerson(new Person("T.I.", "753159684", "Pedro", "Gutierrez"));
            cashRegister.addPerson(new Person("Pasaporte", "3692581478", "Maria", "Martinez"));
            cashRegister.addPerson(new Person("C.C.", "753951684", "Carlos", "Sanchez"));
            cashRegister.addPerson(new Person("C.E.", "159357486", "Ana", "Perez"));
            cashRegister.addPerson(new Person("T.I.", "753951684", "David", "Gomez"));
            cashRegister.addPerson(new Person("Pasaporte", "2583691478", "Mariana", "Castro"));
            cashRegister.addPerson(new Person("C.C.", "951753684", "Andres", "Fernandez"));
            cashRegister.addPerson(new Person("C.E.", "753159684", "Isabella", "Gonzalez"));
            cashRegister.addPerson(new Person("T.I.", "159357684", "Diego", "Rojas"));
            cashRegister.addPerson(new Person("Pasaporte", "3692581478", "Camila", "Suarez"));
            cashRegister.addPerson(new Person("C.C.", "753951684", "Sofia", "Morales"));
            cashRegister.addPerson(new Person("C.E.", "159357486", "Felipe", "Alvarez"));
            cashRegister.addPerson(new Person("T.I.", "753951684", "Laura", "Hernandez"));
            cashRegister.addPerson(new Person("C.C.", "753159684", "Juan", "Gomez"));
            cashRegister.addPerson(new Person("C.E.", "951753684", "Luisa", "Garcia"));
            cashRegister.addPerson(new Person("T.I.", "753159684", "Pedro", "Ramirez"));
            cashRegister.addPerson(new Person("Pasaporte", "3692581478", "Maria", "Martinez"));
        }
        {
            String ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Coca Cola 1.5L", EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Coca Cola 2L",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1200));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Pepsi 1.5L",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Pepsi 2L",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1200));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Fanta 1.5L",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Agua 1.5L",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Pan 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Leche 1L",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Queso 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Huevos 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Carne 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Pollo 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Pescado 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Arroz 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Frijoles 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Papas 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Yuca 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Platanos 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Manzanas 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Peras 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Naranjas 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Cebollas 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
            ciu = CIUGenerator.generateCIU();
            cashRegister.addProduct(new Product("Tomates 1Kg",EAN13Generator.generateBarcode(MANUFACTURER_NUMBER, ciu),ciu,
                    1000));
        }
        {
            cashRegister.addProductToBill("Coca Cola", 1, "Juan");
            cashRegister.addProductToBill("Pepsi", 1, "Juan");
            cashRegister.addProductToBill("Sprite", 1, "Juan");
            cashRegister.addProductToBill("Fanta", 1, "Juan");
            cashRegister.addProductToBill("Agua", 1, "Juan");
            cashRegister.addProductToBill("Pan", 1, "Juan");
        }
    }

    public void start() {
        loadDefaultData();
        view.setPresenter(this);
        view.start();
    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        /*presenter.start();
        presenter.view.showPersonPanel();
        Esto prueba el panel de personas*/
        presenter.loadDefaultData();
        presenter.cashRegister.addPerson(new Person("C.E.", "159357486", "Felipe", "Alvarez"));
        presenter.cashRegister.addPerson(new Person("C.E.", "159357486", "Felipe", "Alvarez"));
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }

}
