package co.edu.uptc.view;

import co.edu.uptc.presenter.Presenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private MainPanel mainPanel;

    public View() {
        super("Facturación");
        setSize(850, 523);
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    private void initComponents() {
        mainPanel = new MainPanel(this);
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed");
        if (e.getSource() == mainPanel.getPersonButton()) showPersonPanel();
        else if (e.getSource() == mainPanel.getBillButton()) showBillPanel();
        else if (e.getSource() == mainPanel.getProductButton()) showProductPanel();
    }

    private void showProductPanel() {
        mainPanel.showProductPanel();
        repaint();
    }

    private void showBillPanel() {
     mainPanel.showBillPanel();
        repaint();
    }

    public void showPersonPanel() {
        mainPanel.showPersonPanel();
        repaint();
    }

    public void setPresenter(Presenter presenter) {
    }

    public void start() {
        setVisible(true);
    }
}
