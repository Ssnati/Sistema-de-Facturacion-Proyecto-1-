package co.edu.uptc.view;

import co.edu.uptc.view.bill.BillPanel;
import co.edu.uptc.view.person.PersonPanel;
import co.edu.uptc.view.product.ProductPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private MainPanel mainPanel;
    private PersonPanel personPanel;
    private BillPanel billPanel;
    private ProductPanel productPanel;
    private MainPanelContent mainPanelContent;

    public View() {
        super("Facturación");
        setSize(850, 523);
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        mainPanel = new MainPanel(this);
        add(mainPanel);
        mainPanelContent = new MainPanelContent();
        personPanel = new PersonPanel(this);
//        billPanel = new BillPanel(this);
//        productPanel = new ProductPanel(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainPanel.getPersonButton()) showPersonPanel();
        else if (e.getSource() == mainPanel.getBillButton()) showBillPanel();
        else if (e.getSource() == mainPanel.getProductButton()) showProductPanel();
    }

    private void showProductPanel() {
    }

    private void showBillPanel() {
    }

    private void showPersonPanel() {
        mainPanelContent.setVisible(false);
        getContentPane().add(personPanel, BorderLayout.CENTER);
        mainPanel.getPersonButton().setBackground(new Color(97, 113, 255));
        repaint();
    }
}
