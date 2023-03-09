package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class MainPanelContent extends JPanel {
    private JLabel titleLabel;

    public MainPanelContent() {
        setBackground(new Color(255, 255, 255, 0));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(750, 381));
        initComponents();
    }

    private void initComponents(){
        initTitleLabel();
        add(titleLabel, BorderLayout.NORTH);
    }

    private void initTitleLabel() {
        titleLabel = new JLabel("<html><center>S I S T E M A <br/> D E <br/> FACTURACI\u00d3N</center></html>");
        titleLabel.setMinimumSize(new Dimension(850,422));
        titleLabel.setMaximumSize(new Dimension(850,422));
        titleLabel.setPreferredSize(new Dimension(850,422));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 80));
    }
}
