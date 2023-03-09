package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JButton personButton;
    private JButton billButton;
    private JButton productButton;
    private JLabel titleLabel;

    public MainPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(180, 180, 180));
        initComponents();
    }

    private void initComponents() {
        personButton = new MainOptionButton("PERSONAS");
        billButton = new MainOptionButton("FACTURAS");
        productButton = new MainOptionButton("PRODUCTOS");
        titleLabel = new JLabel("<html><center>S I S T E M A <br/> D E <br/> FACTURACI\u00d3N</center></html>");

        setLabelFeatures();

        addTitleLabel();
        addPersonButton();
        addBillButton();
        addProductButton();
    }

    private void setLabelFeatures() {
        titleLabel.setMinimumSize(new Dimension(850,422));
        titleLabel.setMaximumSize(new Dimension(850,422));
        titleLabel.setPreferredSize(new Dimension(850,422));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 80));
    }

    private void addTitleLabel() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        add(titleLabel, constraints);
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
}
