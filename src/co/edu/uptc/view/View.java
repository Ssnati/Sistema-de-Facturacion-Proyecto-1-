package co.edu.uptc.view;

import javax.swing.*;

public class View extends JFrame {
    private MainPanel mainPanel;
    public View() {
        super("Facturación");
        setSize(850, 523);
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        mainPanel = new MainPanel();
        add(mainPanel);
    }
}
