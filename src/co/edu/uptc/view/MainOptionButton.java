package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class MainOptionButton extends JButton {
    private final Font buttonFont = new Font("Arial", Font.PLAIN, 25);
    public MainOptionButton(String text) {
        this.setFont(buttonFont);
        this.setFocusable(false);
        this.setMinimumSize(new Dimension(280, 61));
        this.setMaximumSize(new Dimension(280, 61));
        this.setPreferredSize(new Dimension(280, 61));
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(45, 66, 255));
        this.setText(text);
    }
}
