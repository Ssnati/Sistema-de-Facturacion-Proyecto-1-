package co.edu.uptc.view;

import co.edu.uptc.view.bill.BillPanel;
import co.edu.uptc.view.person.PersonPanel;
import co.edu.uptc.view.product.ProductPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private final ActionListener actionListener;
    private MainOptionButton personButton, billButton, productButton;
    private MainPanelContent contentPanel;
    private PersonPanel personPanel;
    private BillPanel billPanel;
    private ProductPanel productPanel;

    public MainPanel(ActionListener actionListener) {
        this.actionListener = actionListener;
        setLayout(new GridBagLayout());
        setBackground(new Color(180, 180, 180));
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        personButton = new MainOptionButton("PERSONAS");
        billButton = new MainOptionButton("FACTURAS");
        productButton = new MainOptionButton("PRODUCTOS");

        setListeners();

        contentPanel = new MainPanelContent();
        personPanel = new PersonPanel(actionListener);
        billPanel = new BillPanel(actionListener);
        productPanel = new ProductPanel(actionListener);

        addMidPanel(contentPanel, 0, 0, 0, 0);
        addPersonButton();
        addBillButton();
        addProductButton();
    }

    private void addMidPanel(JPanel panel, int top, int left, int bottom, int right) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(top, left, bottom, right);
        add(panel, constraints);
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

    public MainPanelContent getContentPanel() {
        return contentPanel;
    }

    private void setListeners() {
        personButton.addActionListener(event->showPersonPanel());
        billButton.addActionListener(event->showBillPanel());
        productButton.addActionListener(event->showProductPanel());
    }

    public void showPersonPanel() {
        contentPanel.setVisible(false);
        productPanel.setVisible(false);
        billPanel.setVisible(false);
        personPanel.setVisible(true);

        personButton.setColorActive(true);
        productButton.setColorActive(false);
        billButton.setColorActive(false);
        addMidPanel(personPanel, 25, 0, 25, 0);
    }

    public void showProductPanel() {
        contentPanel.setVisible(false);
        personPanel.setVisible(false);
        billPanel.setVisible(false);
        productPanel.setVisible(true);

        personButton.setColorActive(false);
        productButton.setColorActive(true);
        billButton.setColorActive(false);
        addMidPanel(productPanel, 25, 0, 25, 0);
    }

    public void showBillPanel() {
        contentPanel.setVisible(false);
        personPanel.setVisible(false);
        productPanel.setVisible(false);
        billPanel.setVisible(true);

        personButton.setColorActive(false);
        productButton.setColorActive(false);
        billButton.setColorActive(true);
        addMidPanel(billPanel, 25, 0, 25, 0);
    }
}
