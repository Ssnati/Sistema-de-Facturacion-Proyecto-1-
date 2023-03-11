package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {

    public SearchPanel(ActionListener actionListener) {
        //235 * 117
        setPreferredSize(new Dimension(235, 117));
        setMaximumSize(new Dimension(235, 117));
        setMinimumSize(new Dimension(235, 117));
        setBackground(new Color(15, 119, 214));
        initComponents();
    }

    private void initComponents() {
        JLabel label = new JLabel("Buscar");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 25));
        add(label);

        JTextField textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(200, 40));
        textField.setMaximumSize(new Dimension(200, 40));
        textField.setMinimumSize(new Dimension(200, 40));
        add(textField);
    }
}