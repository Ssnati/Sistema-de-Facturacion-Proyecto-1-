package co.edu.uptc.view.person;

import co.edu.uptc.pojo.CashRegister;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.view.SearchPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PersonPanel extends JPanel {
    private static final int TABLE_COLUMN_WIDTH = 33;
    private final Color TABLE_BACKGROUND_COLOR = new Color(200, 200, 200);
    private final Font TABLE_FONT = new Font("Arial", Font.PLAIN, 20);
    private final ActionListener actionListener;
    private JTable table;
    private SearchPanel searchPanel;
    private JButton addButton;

    public PersonPanel(ActionListener actionListener) {
        this.actionListener = actionListener;
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(750, 381));
        setMaximumSize(new Dimension(750, 381));
        setMinimumSize(new Dimension(750, 381));
        initComponents();
        setBackground(Color.WHITE);
        setVisible(true);
    }

    private void initComponents() {
        table = new JTable(0, 4);
        tableHeaderFeatures(table.getTableHeader());
        tableModelFeatures();

        searchPanel = new SearchPanel(actionListener);
        addButton = new JButton("Agregar");

        addTable();
        addSearchPanel();
        addAddButton();
    }

    private void tableModelFeatures() {
        loadDefaultData();

        table.setBackground(TABLE_BACKGROUND_COLOR);
        table.setFont(TABLE_FONT);
        table.setShowGrid(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setRowHeight(30);
        centerTableData();
        table.getColumnModel().getColumn(0).setMaxWidth(TABLE_COLUMN_WIDTH);
    }

    private void loadDefaultData() {
        List<Person> cashRegister = new ArrayList<>();
        {
            cashRegister.add(new Person("C.C.", "123456789", "Juan", "Perez"));
            cashRegister.add(new Person("C.E.", "987654321", "Luisa", "Gomez"));
            cashRegister.add(new Person("T.I.", "456789123", "Pedro", "Ramirez"));
            cashRegister.add(new Person("Pasaporte", "1122334455", "Maria", "Lopez"));
            cashRegister.add(new Person("C.C.", "987654321", "Carlos", "Gonzalez"));
            cashRegister.add(new Person("C.E.", "123456789", "Ana", "Jimenez"));
            cashRegister.add(new Person("T.I.", "789456123", "David", "Santos"));
            cashRegister.add(new Person("Pasaporte", "2233445566", "Mariana", "Castro"));
            cashRegister.add(new Person("C.C.", "147258369", "Andres", "Rodriguez"));
            cashRegister.add(new Person("C.E.", "369258147", "Isabella", "Fernandez"));
            cashRegister.add(new Person("T.I.", "258369147", "Diego", "Hernandez"));
            cashRegister.add(new Person("Pasaporte", "3344556677", "Camila", "Suarez"));
            cashRegister.add(new Person("C.C.", "963852741", "Sofia", "Morales"));
            cashRegister.add(new Person("C.E.", "741852963", "Felipe", "Rojas"));
            cashRegister.add(new Person("T.I.", "123789456", "Laura", "Alvarez"));
        }
        loadPersonList(cashRegister);
    }

    private void loadPersonList(List<Person> data) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        for (Person person : data){
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, person.getName(), person.getLastName(), person.getDocumentType()});
        }
        table.setModel(tableModel);
    }

    private void centerTableData() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
    }


    private void tableHeaderFeatures(JTableHeader header) {
        table.getColumnModel().getColumn(0).setHeaderValue("#");
        table.getColumnModel().getColumn(1).setHeaderValue("Nombre");
        table.getColumnModel().getColumn(2).setHeaderValue("Apellido");
        table.getColumnModel().getColumn(3).setHeaderValue("Documento");
        header.setBorder(BorderFactory.createLineBorder(TABLE_BACKGROUND_COLOR));
        header.setFont(TABLE_FONT);
        header.setBackground(TABLE_BACKGROUND_COLOR);
    }

    private void addTable() {
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, new GridBagConstraints(0, 0, 1, 2, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(35, 24, 30, 0),
                0, 0));
    }

    private void addSearchPanel() {
        add(searchPanel, new GridBagConstraints(1, 0, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(35, 24, 0, 24),
                0, 0));
    }

    private void addAddButton() {
        addButton.setMinimumSize(new Dimension(233, 60));
        addButton.setBackground(Color.black);
        addButton.setForeground(Color.white);
        addButton.setFont(new Font("Arial", Font.PLAIN, 30));
        add(addButton, new GridBagConstraints(1, 1, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(110, 0, 0, 0),
                0,0));
    }
}
