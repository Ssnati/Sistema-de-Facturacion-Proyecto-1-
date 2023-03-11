package co.edu.uptc.view.bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BillPanel extends JPanel {
    private final ActionListener actionListener;
    public BillPanel(ActionListener actionListener) {
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
    }
}
