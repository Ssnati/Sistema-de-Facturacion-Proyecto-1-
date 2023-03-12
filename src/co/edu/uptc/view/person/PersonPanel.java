package co.edu.uptc.view.person;

import co.edu.uptc.model.dinamic.UptcList;
import co.edu.uptc.view.SearchPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class PersonPanel extends JPanel {
    private static final int TABLE_COLUMN_WIDTH = 33;
    private final Color TABLE_BACKGROUND_COLOR = new Color(200, 200, 200);
    private final Font TABLE_FONT = new Font("Arial", Font.PLAIN, 20);
    private final ActionListener actionListener;
    private JTable table;
    private SearchPanel searchPanel;
    private JButton addButton;
    private List<String> personsLoaded;

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
        tableListener();

        searchPanel = new SearchPanel(actionListener);
        addButton = new JButton("Agregar");

        addTable();
        addSearchPanel();
        addAddButton();
    }

    private void tableListener() {
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Fila: " + table.rowAtPoint(e.getPoint()) + " Columna: " + table.columnAtPoint(e.getPoint()));
                System.out.println(personsLoaded.get(table.rowAtPoint(e.getPoint())*4)+" "+personsLoaded.get(table.rowAtPoint(e.getPoint())*4+1));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private void tableModelFeatures() {
        loadDefaultData();

        table.setEnabled(false);
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
        List<String> cashRegister = new UptcList<>();
        {
            cashRegister.add("C.C.");
            cashRegister.add("123456789");
            cashRegister.add("Juan");
            cashRegister.add("Perez");
            cashRegister.add("C.E.");
            cashRegister.add("987654321");
            cashRegister.add("Luisa");
            cashRegister.add("Gomez");

            cashRegister.add("T.I.");
            cashRegister.add("456789123");
            cashRegister.add("Pedro");
            cashRegister.add("Ramirez");

            cashRegister.add("Pasaporte");
            cashRegister.add("1122334455");
            cashRegister.add("Maria");
            cashRegister.add("Lopez");

            cashRegister.add("C.C.");
            cashRegister.add("987654321");
            cashRegister.add("Carlos");
            cashRegister.add("Gonzalez");

            cashRegister.add("C.E.");
            cashRegister.add("123456789");
            cashRegister.add("Ana");
            cashRegister.add("Jimenez");

            cashRegister.add("T.I.");
            cashRegister.add("789456123");
            cashRegister.add("David");
            cashRegister.add("Santos");

            cashRegister.add("Pasaporte");
            cashRegister.add("2233445566");
            cashRegister.add("Mariana");
            cashRegister.add("Castro");

            cashRegister.add("C.C.");
            cashRegister.add("147258369");
            cashRegister.add("Andres");
            cashRegister.add("Rodriguez");

            cashRegister.add("C.E.");
            cashRegister.add("369258147");
            cashRegister.add("Isabella");
            cashRegister.add("Fernandez");

            cashRegister.add("T.I.");
            cashRegister.add("258369147");
            cashRegister.add("Diego");
            cashRegister.add("Hernandez");

            cashRegister.add("Pasaporte");
            cashRegister.add("3344556677");
            cashRegister.add("Camila");
            cashRegister.add("Suarez");

            cashRegister.add("C.C.");
            cashRegister.add("963852741");
            cashRegister.add("Sofia");
            cashRegister.add("Morales");

            cashRegister.add("C.E.");
            cashRegister.add("741852963");
            cashRegister.add("Felipe");
            cashRegister.add("Rojas");

            cashRegister.add("T.I.");
            cashRegister.add("123789456");
            cashRegister.add("Laura");
            cashRegister.add("Alvarez");
        }
        loadPersonList(cashRegister);
    }

    private void loadPersonList(List<String> data) {
        this.personsLoaded = data;
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        for (int i = 0; i < data.size(); i += 4) {
            tableModel.addRow(new Object[]{i / 4 + 1, data.get(i + 2), data.get(i + 3), data.get(i)});
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
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
                0, 0));
    }
}
