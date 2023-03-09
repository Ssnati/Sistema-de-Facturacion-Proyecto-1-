package co.edu.uptc.view.person;

import co.edu.uptc.view.SearchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PersonPanel extends JPanel {
    private final ActionListener actionListener;
    private JTable table;
    private SearchPanel searchPanel;
    private JButton addButton;

    public PersonPanel(ActionListener actionListener) {
        this.actionListener = actionListener;
        initComponents();
        setBackground(Color.WHITE);
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(750, 381));
        setBackground(new Color(0,0,0,0));
//        initContentPanel();
//        initButtonsPanel();
    }

//    private void initContentPanel() {
//        contentPanel = new JPanel();
//        contentPanel.setPreferredSize(new Dimension(440, 316));
//        contentPanel.setMaximumSize(new Dimension(440, 316));
//        contentPanel.setMinimumSize(new Dimension(440, 316));
//        contentPanel.setBackground(new Color(150, 150, 150));
//    }

//    private void initButtonsPanel() {
//        buttonsPanel = new JPanel();
//        buttonsPanel.setPreferredSize(new Dimension(310, 60));
//        buttonsPanel.setBackground(Color.WHITE);
//
//        searchButton = new JButton("Buscar");
//        addButton = new JButton("Agregar");
//
//        buttonsPanel.add(searchButton);
//        buttonsPanel.add(addButton);
//    }
}
