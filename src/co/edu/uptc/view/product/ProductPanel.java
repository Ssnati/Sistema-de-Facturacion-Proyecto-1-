package co.edu.uptc.view.product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductPanel extends JPanel {
    private final ActionListener actionListener;

    public ProductPanel(ActionListener actionListener) {
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
