package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class MainOptionButton extends JButton {
    private final Font buttonFont = new Font("Arial", Font.PLAIN, 25);
    private final Color buttonColorInactive = new Color(45, 66, 255);
    private final Color buttonColorActive =new Color(97, 113, 255);
    public MainOptionButton(String text) {
        this.setFont(buttonFont);
        this.setFocusable(false);
        this.setMinimumSize(new Dimension(280, 61));
        this.setMaximumSize(new Dimension(280, 61));
        this.setPreferredSize(new Dimension(280, 61));
        this.setForeground(Color.WHITE);
        this.setBackground(buttonColorInactive);
        this.setText(text);
    }
    public void setColorActive(boolean active) {
        if (active) this.setBackground(buttonColorActive);
        else this.setBackground(buttonColorInactive);
    }
}
