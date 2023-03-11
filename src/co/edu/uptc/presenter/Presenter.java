package co.edu.uptc.presenter;

import co.edu.uptc.pojo.CashRegister;
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
            cashRegister.addPerson("C.C.", "123456789", "Juan", "Perez");
            cashRegister.addPerson("C.E.", "987654321", "Luisa", "Gomez");
            cashRegister.addPerson("T.I.", "456789123", "Pedro", "Ramirez");
            cashRegister.addPerson("Pasaporte", "1122334455", "Maria", "Lopez");
            cashRegister.addPerson("C.C.", "987654321", "Carlos", "Gonzalez");
            cashRegister.addPerson("C.E.", "123456789", "Ana", "Jimenez");
            cashRegister.addPerson("T.I.", "789456123", "David", "Santos");
            cashRegister.addPerson("Pasaporte", "2233445566", "Mariana", "Castro");
            cashRegister.addPerson("C.C.", "147258369", "Andres", "Rodriguez");
            cashRegister.addPerson("C.E.", "369258147", "Isabella", "Fernandez");
            cashRegister.addPerson("T.I.", "258369147", "Diego", "Hernandez");
            cashRegister.addPerson("Pasaporte", "3344556677", "Camila", "Suarez");
            cashRegister.addPerson("C.C.", "963852741", "Sofia", "Morales");
            cashRegister.addPerson("C.E.", "741852963", "Felipe", "Rojas");
            cashRegister.addPerson("T.I.", "123789456", "Laura", "Alvarez");
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

    public void start(){
        loadDefaultData();
        view.setPresenter(this);
        view.start();
    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.start();
    }

}
