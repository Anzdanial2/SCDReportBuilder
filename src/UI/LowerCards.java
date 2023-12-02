package UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LowerCards {
    //Pie
    JCheckBox pieCheckBox;
    JLabel pieSelectSourceLabel;
    JRadioButton pieCSVBtn;
    JRadioButton pieDbBtn;

    ButtonGroup pieSource;
    JButton pieFileChooser;
    JLabel pieLegendsLabel;
    JCheckBox pieYesBox;
    JCheckBox pieNoBox;
    //Line
    JCheckBox lineCheckBox;
    JLabel lineSelectSourceLabel;
    JRadioButton lineCSVBtn;
    JRadioButton lineDbBtn;

    ButtonGroup lineSource;
    JButton lineFileChooser;
    JLabel lineXaxisLabel;
    JTextField lineXaxisField;
    JLabel lineYaxisLabel;
    JTextField lineYaxisField;
    JLabel lineLegendsLabel;
    JCheckBox lineLegendsYesBox;
    JCheckBox lineLegendsNoBox;
    JLabel lineAxisValueLabel;
    JCheckBox lineAxisYesBox;
    JCheckBox lineAxisNoBox;
    JButton lineColorBtn;
    //Bar
    JCheckBox barCheckBox;
    JLabel barSelectSourceLabel;
    JRadioButton barCSVBtn;
    JRadioButton barDbBtn;
    ButtonGroup barSource;
    JLabel barXaxisLabel;
    JTextField barXaxisField;
    JLabel barYaxisLabel;
    JTextField barYaxisField;
    JButton barFileChooser;
    JLabel barLegendsLabel;
    JCheckBox barLegendsYesBox;
    JCheckBox barLegendsNoBox;
    JLabel barAxisValueLabel;
    JCheckBox barAxisYesBox;
    JCheckBox barAxisNoBox;
    JButton barColorBtn;
    JButton generateReportBtn;
    //Panels
    JPanel piePanel;
    JPanel barPanel;
    JPanel linePanel;
    JPanel piePanel1;
    JPanel piePanel2;
    JPanel piePanel3;
    JPanel linePanel1;
    JPanel linePanel2;
    JPanel linePanel3;
    JPanel linePanel4;
    JPanel barPanel1;
    JPanel barPanel2;
    JPanel barPanel3;
    JPanel barPanel4;
    JPanel lowerPanel;
    public LowerCards(){
        pieCheckBox = new JCheckBox("Pie Chart");
        pieSelectSourceLabel = new JLabel("Select Data Source");
        pieCSVBtn = new JRadioButton("CSV");
        pieDbBtn = new JRadioButton("Data Base");
        pieSource = new ButtonGroup();
        pieSource.add(pieCSVBtn);
        pieSource.add(pieDbBtn);
        pieFileChooser = new JButton("Choose CSV");
        pieLegendsLabel = new JLabel("Display Legends");
        pieYesBox = new JCheckBox("Yes");
        pieNoBox = new JCheckBox("No");

        //Line
        lineCheckBox = new JCheckBox("Line Chart");
        lineSelectSourceLabel = new JLabel("Select Data Source");
        lineCSVBtn = new JRadioButton("CSV");
        lineDbBtn = new JRadioButton("Data Base");
        lineSource = new ButtonGroup();
        lineSource.add(lineCSVBtn);
        lineSource.add(lineDbBtn);
        lineFileChooser = new JButton("Choose CSV");
        lineXaxisLabel = new JLabel("X-axis Name");
        lineYaxisLabel = new JLabel("Y-axis Name");
        lineXaxisField = new JTextField(10);
        lineYaxisField = new JTextField(10);
        lineLegendsLabel = new JLabel("Display Legends");
        lineLegendsYesBox = new JCheckBox("Yes");
        lineLegendsNoBox = new JCheckBox("No");
        lineAxisValueLabel = new JLabel("Display Axis Values");
        lineAxisYesBox = new JCheckBox("Yes");
        lineAxisNoBox = new JCheckBox("No");
        lineColorBtn = new JButton("Choose Color");

        //Bar
        barCheckBox = new JCheckBox("Bar Chart");
        barSelectSourceLabel = new JLabel("Select Data Source");
        barCSVBtn = new JRadioButton("CSV");
        barDbBtn = new JRadioButton("Data Base");
        barSource = new ButtonGroup();
        barSource.add(lineCSVBtn);
        barSource.add(lineDbBtn);
        barXaxisLabel = new JLabel("X-axis Name");
        barYaxisLabel = new JLabel("Y-axis Name");
        barXaxisField = new JTextField(10);
        barYaxisField = new JTextField(10);
        barFileChooser = new JButton("Choose CSV");
        barLegendsLabel = new JLabel("Display Legends");
        barLegendsYesBox = new JCheckBox("Yes");
        barLegendsNoBox = new JCheckBox("No");
        barAxisValueLabel = new JLabel("Display Axis Values");
        barAxisYesBox = new JCheckBox("Yes");
        barAxisNoBox = new JCheckBox("No");
        barColorBtn = new JButton("Choose Color");
        generateReportBtn = new JButton("Generate Report");
        generateReportBtn.setPreferredSize(new Dimension(150,50));

        piePanel1 = new JPanel(new GridLayout(2,1,5,7));
        piePanel1.add(pieCheckBox);
        piePanel1.add(pieSelectSourceLabel);

        piePanel2 = new JPanel(new GridLayout(2,2,5,7));
        piePanel2.add(pieCSVBtn);
        piePanel2.add(pieDbBtn);
        piePanel2.add(pieFileChooser);
        piePanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,7));
        piePanel3.add(pieLegendsLabel);
        piePanel3.add(pieYesBox);
        piePanel3.add(pieNoBox);

        piePanel = new JPanel();
        piePanel.setLayout(new BoxLayout(piePanel,BoxLayout.Y_AXIS));
        piePanel.add(piePanel1);
        piePanel.add(piePanel2);
        piePanel.add(piePanel3);

        linePanel1 = new JPanel(new GridLayout(2,1,5,7));
        linePanel1.add(lineCheckBox);
        linePanel1.add(lineSelectSourceLabel);
        linePanel2 = new JPanel(new GridLayout(2,2,5,7));
        linePanel2.add(lineCSVBtn);
        linePanel2.add(lineDbBtn);
        linePanel2.add(lineFileChooser);
        linePanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,7));
        linePanel3.add(lineXaxisLabel);
        linePanel3.add(lineXaxisField);
        linePanel3.add(lineYaxisLabel);
        linePanel3.add(lineYaxisField);


        linePanel4 = new JPanel(new GridLayout(3,3,5,7));
        linePanel4.add(lineLegendsLabel);
        linePanel4.add(lineLegendsYesBox);
        linePanel4.add(lineLegendsNoBox);
        linePanel4.add(lineAxisValueLabel);
        linePanel4.add(lineAxisYesBox);
        linePanel4.add(lineAxisNoBox);
        linePanel4.add(lineColorBtn);
        linePanel = new JPanel();
        linePanel.setLayout(new BoxLayout(linePanel,BoxLayout.Y_AXIS));
        linePanel.add(linePanel1);
        linePanel.add(linePanel2);
        linePanel.add(linePanel3);
        linePanel.add(linePanel4);

        barPanel1 = new JPanel(new GridLayout(2,1,5,7));
        barPanel1.add(barCheckBox);
        barPanel1.add(barSelectSourceLabel);
        barPanel2 = new JPanel(new GridLayout(2,2,5,7));
        barPanel2.add(barCSVBtn);
        barPanel2.add(barDbBtn);
        barPanel2.add(barFileChooser);
        barPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,7));
        barPanel3.add(barXaxisLabel);
        barPanel3.add(barXaxisField);
        barPanel3.add(barYaxisLabel);
        barPanel3.add(barYaxisField);


        barPanel4 = new JPanel(new GridLayout(3,3,5,7));
        barPanel4.add(barLegendsLabel);
        barPanel4.add(barLegendsYesBox);
        barPanel4.add(barLegendsNoBox);
        barPanel4.add(barAxisValueLabel);
        barPanel4.add(barAxisYesBox);
        barPanel4.add(barAxisNoBox);
        barPanel4.add(barColorBtn);
        barPanel = new JPanel();
        barPanel.setLayout(new BoxLayout(barPanel,BoxLayout.Y_AXIS));
        barPanel.add(barPanel1);
        barPanel.add(barPanel2);
        barPanel.add(barPanel3);
        barPanel.add(barPanel4);
        //background color
        piePanel.setBackground(new Color(179, 208, 255)); // light blue
        setPanelBackground(piePanel, new Color(179, 208, 255));
        linePanel.setBackground(new Color(179, 208, 255));
        setPanelBackground(linePanel, new Color(179, 208, 255));
        barPanel.setBackground(new Color(179, 208, 255)); // light blue
        setPanelBackground(barPanel, new Color(179, 208, 255));
        Border roundedBorder = new LineBorder(new Color(179, 208, 255), 2, true);
        piePanel.setBorder(new CompoundBorder(roundedBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        linePanel.setBorder(new CompoundBorder(roundedBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        barPanel.setBorder(new CompoundBorder(roundedBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        lowerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
        lowerPanel.add(linePanel);
        lowerPanel.add(barPanel);
        lowerPanel.add(piePanel);
        lowerPanel.add(generateReportBtn);

    }
    private void setPanelBackground(Container container, Color color) {
        container.setBackground(color);
        for (Component component : container.getComponents()) {
            if (!(component instanceof JTextField) && !(component instanceof JButton)) {
                if (component instanceof Container) {
                    setPanelBackground((Container) component, color);
                } else if (component instanceof JComponent) {
                    ((JComponent) component).setOpaque(true);
                    component.setBackground(color);
                }
            }
        }
    }


    public JPanel getLowerPanel() {
        return lowerPanel;
    }

    public JCheckBox getPieCheckBox() {
        return pieCheckBox;
    }

    public JLabel getPieSelectSourceLabel() {
        return pieSelectSourceLabel;
    }

    public JRadioButton getPieCSVBtn() {
        return pieCSVBtn;
    }

    public JRadioButton getPieDbBtn() {
        return pieDbBtn;
    }

    public ButtonGroup getPieSource() {
        return pieSource;
    }

    public JButton getPieFileChooser() {
        return pieFileChooser;
    }

    public JLabel getPieLegendsLabel() {
        return pieLegendsLabel;
    }

    public JCheckBox getPieYesBox() {
        return pieYesBox;
    }

    public JCheckBox getPieNoBox() {
        return pieNoBox;
    }

    public JCheckBox getLineCheckBox() {
        return lineCheckBox;
    }

    public JLabel getLineSelectSourceLabel() {
        return lineSelectSourceLabel;
    }

    public JRadioButton getLineCSVBtn() {
        return lineCSVBtn;
    }

    public JRadioButton getLineDbBtn() {
        return lineDbBtn;
    }

    public ButtonGroup getLineSource() {
        return lineSource;
    }

    public JButton getLineFileChooser() {
        return lineFileChooser;
    }

    public JLabel getLineXaxisLabel() {
        return lineXaxisLabel;
    }

    public JTextField getLineXaxisField() {
        return lineXaxisField;
    }

    public JLabel getLineYaxisLabel() {
        return lineYaxisLabel;
    }

    public JTextField getLineYaxisField() {
        return lineYaxisField;
    }

    public JLabel getLineLegendsLabel() {
        return lineLegendsLabel;
    }

    public JCheckBox getLineLegendsYesBox() {
        return lineLegendsYesBox;
    }

    public JCheckBox getLineLegendsNoBox() {
        return lineLegendsNoBox;
    }

    public JLabel getLineAxisValueLabel() {
        return lineAxisValueLabel;
    }

    public JCheckBox getLineAxisYesBox() {
        return lineAxisYesBox;
    }

    public JCheckBox getLineAxisNoBox() {
        return lineAxisNoBox;
    }

    public JButton getLineColorBtn() {
        return lineColorBtn;
    }

    public JCheckBox getBarCheckBox() {
        return barCheckBox;
    }

    public JLabel getBarSelectSourceLabel() {
        return barSelectSourceLabel;
    }

    public JRadioButton getBarCSVBtn() {
        return barCSVBtn;
    }

    public JRadioButton getBarDbBtn() {
        return barDbBtn;
    }

    public ButtonGroup getBarSource() {
        return barSource;
    }

    public JLabel getBarXaxisLabel() {
        return barXaxisLabel;
    }

    public JTextField getBarXaxisField() {
        return barXaxisField;
    }

    public JLabel getBarYaxisLabel() {
        return barYaxisLabel;
    }

    public JTextField getBarYaxisField() {
        return barYaxisField;
    }

    public JButton getBarFileChooser() {
        return barFileChooser;
    }

    public JLabel getBarLegendsLabel() {
        return barLegendsLabel;
    }

    public JCheckBox getBarLegendsYesBox() {
        return barLegendsYesBox;
    }

    public JCheckBox getBarLegendsNoBox() {
        return barLegendsNoBox;
    }

    public JLabel getBarAxisValueLabel() {
        return barAxisValueLabel;
    }

    public JCheckBox getBarAxisYesBox() {
        return barAxisYesBox;
    }

    public JCheckBox getBarAxisNoBox() {
        return barAxisNoBox;
    }

    public JButton getBarColorBtn() {
        return barColorBtn;
    }

    public JButton getGenerateReportBtn() {
        return generateReportBtn;
    }

}
