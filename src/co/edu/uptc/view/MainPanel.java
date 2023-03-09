package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private ActionListener actionListener;
    private JButton personButton;
    private JButton billButton;
    private JButton productButton;
    private MainPanelContent contentPanel;

    public MainPanel(ActionListener actionListener) {
        this.actionListener = actionListener;
        setLayout(new GridBagLayout());
        setBackground(new Color(180, 180, 180));
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        personButton = new MainOptionButton("PERSONAS");
        personButton.addActionListener(actionListener);
        billButton = new MainOptionButton("FACTURAS");
        billButton.addActionListener(actionListener);
        productButton = new MainOptionButton("PRODUCTOS");
        productButton.addActionListener(actionListener);
        contentPanel = new MainPanelContent();

        addMainContentPanel();
        addPersonButton();
        addBillButton();
        addProductButton();
    }

    private void addMainContentPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        add(contentPanel, constraints);
    }

    private void addPersonButton() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(personButton, constraints);
    }

    private void addProductButton() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(productButton, constraints);
    }

    private void addBillButton() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(billButton, constraints);

    }

    public JButton getBillButton() {
        return billButton;
    }

    public JButton getPersonButton() {
        return personButton;
    }

    public JButton getProductButton() {
        return productButton;
    }

}
