package co.edu.uptc.presenter;

import co.edu.uptc.pojo.CashRegister;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.view.View;

public class Presenter {
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
            cashRegister.addProduct("Coca Cola", 1000);
            cashRegister.addProduct("Pepsi", 1000);
            cashRegister.addProduct("Sprite", 1000);
            cashRegister.addProduct("Fanta", 1000);
            cashRegister.addProduct("Agua", 1000);
            cashRegister.addProduct("Pan", 1000);
            cashRegister.addProduct("Leche", 1000);
            cashRegister.addProduct("Queso", 1000);
            cashRegister.addProduct("Huevos", 1000);
            cashRegister.addProduct("Carne", 1000);
            cashRegister.addProduct("Pollo", 1000);
            cashRegister.addProduct("Pescado", 1000);
            cashRegister.addProduct("Arroz", 1000);
            cashRegister.addProduct("Frijoles", 1000);
            cashRegister.addProduct("Papas", 1000);
            cashRegister.addProduct("Yuca", 1000);
            cashRegister.addProduct("Platanos", 1000);
            cashRegister.addProduct("Manzanas", 1000);
            cashRegister.addProduct("Peras", 1000);
            cashRegister.addProduct("Naranjas", 1000);
            cashRegister.addProduct("Cebollas", 1000);
            cashRegister.addProduct("Tomates", 1000);
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
