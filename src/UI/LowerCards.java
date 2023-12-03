package UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
//lowercards

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
    JButton pieColorChooser;
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
    JComboBox<String> layoutDropDown;
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
    Font boldFont;
    Font mediumFont;
    Font componentFont;
    Font fieldFont;
    public LowerCards(){
        fieldFont = new Font("SansSerif", Font.PLAIN, 15);
        boldFont = new Font("SansSerif", Font.BOLD, 16);
        mediumFont = new Font("SansSerif", Font.TRUETYPE_FONT, 15);
        componentFont = new Font("SansSerif", Font.BOLD, 20);
        pieCheckBox = new JCheckBox("Pie Chart");
        pieCheckBox.setFocusable(false);
        pieCheckBox.setFont(componentFont);
        pieCheckBox.setFont(boldFont);
        pieSelectSourceLabel = new JLabel("Select Data Source");
        pieSelectSourceLabel.setFont(boldFont);
        pieCSVBtn = new JRadioButton("CSV");
        pieCSVBtn.setFocusable(false);
        pieCSVBtn.setFont(mediumFont);
        pieDbBtn = new JRadioButton("Data Base");
        pieDbBtn.setFocusable(false);
        pieDbBtn.setFont(mediumFont);
        pieSource = new ButtonGroup();
        pieSource.add(pieCSVBtn);
        pieSource.add(pieDbBtn);
        pieFileChooser = new JButton("Choose CSV");
        pieFileChooser.setFocusable(false);
        pieFileChooser.setBackground(new Color(179, 208, 255));
        pieFileChooser.setFont(boldFont);
//        roundButtonCorners(pieFileChooser, 15);
        pieLegendsLabel = new JLabel("Display Legends");
        pieLegendsLabel.setFont(boldFont);
        pieYesBox = new JCheckBox("Yes");
        pieYesBox.setFocusable(false);
        pieYesBox.setFont(mediumFont);
        pieNoBox = new JCheckBox("No");
        pieNoBox.setFocusable(false);
        pieNoBox.setFont(mediumFont);
        pieColorChooser = new JButton("Choose Color");
        pieColorChooser.setFocusable(false);
        pieColorChooser.setFont(boldFont);
        pieColorChooser.setBackground(new Color(179, 208, 255));

        //Line
        lineCheckBox = new JCheckBox("Line Chart");
        lineCheckBox.setFocusable(false);
        lineCheckBox.setFont(componentFont);
        lineSelectSourceLabel = new JLabel("Select Data Source");
        lineSelectSourceLabel.setFont(boldFont);
        lineCSVBtn = new JRadioButton("CSV");
        lineCSVBtn.setFocusable(false);
        lineCSVBtn.setFont(mediumFont);
        lineDbBtn = new JRadioButton("Data Base");
        lineDbBtn.setFocusable(false);
        lineDbBtn.setFont(mediumFont);
        lineSource = new ButtonGroup();
        lineSource.add(lineCSVBtn);
        lineSource.add(lineDbBtn);
        lineFileChooser = new JButton("Choose CSV");
        lineFileChooser.setFocusable(false);
        lineFileChooser.setBackground(new Color(179, 208, 255));
        lineFileChooser.setFont(boldFont);
        lineXaxisLabel = new JLabel("X-axis Name");
        lineXaxisLabel.setFont(boldFont);
        lineYaxisLabel = new JLabel("Y-axis Name");
        lineYaxisLabel.setFont(boldFont);
        lineXaxisField = new JTextField(10);
        lineXaxisField.setFont(fieldFont);
        lineYaxisField = new JTextField(10);
        lineYaxisField.setFont(fieldFont);
        lineLegendsLabel = new JLabel("Display Legends");
        lineLegendsLabel.setFont(boldFont);
        lineLegendsYesBox = new JCheckBox("Yes");
        lineLegendsYesBox.setFocusable(false);
        lineLegendsYesBox.setFont(mediumFont);
        lineLegendsNoBox = new JCheckBox("No");
        lineLegendsNoBox.setFocusable(false);
        lineLegendsNoBox.setFont(mediumFont);
        lineAxisValueLabel = new JLabel("Display Axis Values");
        lineAxisValueLabel.setFont(boldFont);
        lineAxisYesBox = new JCheckBox("Yes");
        lineAxisYesBox.setFocusable(false);
        lineAxisYesBox.setFont(mediumFont);
        lineAxisNoBox = new JCheckBox("No");
        lineAxisNoBox.setFocusable(false);
        lineAxisNoBox.setFont(mediumFont);
        lineColorBtn = new JButton("Choose Color");
        lineColorBtn.setFocusable(false);
        lineColorBtn.setBackground(new Color(179, 208, 255));
        lineColorBtn.setFont(boldFont);

        //Bar
        barCheckBox = new JCheckBox("Bar Chart");
        barCheckBox.setFocusable(false);
        barCheckBox.setFont(componentFont);
        barSelectSourceLabel = new JLabel("Select Data Source");
        barSelectSourceLabel.setFont(boldFont);
        barCSVBtn = new JRadioButton("CSV");
        barCSVBtn.setFocusable(false);
        barCSVBtn.setFont(mediumFont);
        barDbBtn = new JRadioButton("Data Base");
        barDbBtn.setFocusable(false);
        barDbBtn.setFont(mediumFont);

        barSource = new ButtonGroup();
        barSource.add(lineCSVBtn);
        barSource.add(lineDbBtn);
        barXaxisLabel = new JLabel("X-axis Name");
        barXaxisLabel.setFont(boldFont);
        barYaxisLabel = new JLabel("Y-axis Name");
        barYaxisLabel.setFont(boldFont);
        barXaxisField = new JTextField(10);
        barXaxisField.setFont(fieldFont);
        barYaxisField = new JTextField(10);
        barYaxisField.setFont(fieldFont);
        barFileChooser = new JButton("Choose CSV");
        barFileChooser.setFocusable(false);
        barFileChooser.setBackground(new Color(179, 208, 255));
//        barFileChooser.setForeground(new Color(51, 133, 255));
        barFileChooser.setFont(boldFont);
        barLegendsLabel = new JLabel("Display Legends");
        barLegendsLabel.setFont(boldFont);
        barLegendsYesBox = new JCheckBox("Yes");
        barLegendsYesBox.setFocusable(false);
        barLegendsYesBox.setFont(mediumFont);
        barLegendsNoBox = new JCheckBox("No");
        barLegendsNoBox.setFocusable(false);
        barLegendsNoBox.setFont(mediumFont);
        barAxisValueLabel = new JLabel("Display Axis Values");
        barAxisValueLabel.setFont(boldFont);
        barAxisYesBox = new JCheckBox("Yes");
        barAxisYesBox.setFocusable(false);
        barAxisYesBox.setFont(mediumFont);
        barAxisNoBox = new JCheckBox("No");
        barAxisNoBox.setFocusable(false);
        barAxisNoBox.setFont(mediumFont);
        barColorBtn = new JButton("Choose Color");
        barColorBtn.setFocusable(false);
        barColorBtn.setFont(boldFont);
        barColorBtn.setBackground(new Color(179, 208, 255));
        generateReportBtn = new JButton("Generate Report");
        String[] layoutOptions = {"Default layout","Image,Text,Table,Chart",
                "Text,Image,Table,Chart","Image,Chart,Table,Text","Table,Text,Image,Chart"};
        layoutDropDown = new JComboBox<>(layoutOptions);
        layoutDropDown.setFont(boldFont);
        generateReportBtn.setFocusable(false);
        generateReportBtn.setFont(componentFont);
        generateReportBtn.setBackground(new Color(77, 255, 136));
        generateReportBtn.setPreferredSize(new Dimension(200,50));

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
        piePanel3.add(pieColorChooser);

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
        piePanel.setBackground(new Color(83, 140, 198)); // light blue
        setPanelBackground(piePanel, new Color(83, 140, 198));
        linePanel.setBackground(new Color(83, 140, 198));
        setPanelBackground(linePanel, new Color(83, 140, 198));
        barPanel.setBackground(new Color(83, 140, 198)); // light blue
        setPanelBackground(barPanel, new Color(83, 140, 198));
        Border roundedBorder = new LineBorder(new Color(83, 140, 198), 2, true);
        piePanel.setBorder(new CompoundBorder(roundedBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        linePanel.setBorder(new CompoundBorder(roundedBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        barPanel.setBorder(new CompoundBorder(roundedBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        lowerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
        lowerPanel.add(linePanel);
        lowerPanel.add(barPanel);
        lowerPanel.add(piePanel);
        lowerPanel.add(layoutDropDown);
        lowerPanel.add(generateReportBtn);


        // Added the following code to set the border to EmptyBorder
        pieCSVBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        pieDbBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        lineCSVBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        lineDbBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        barCSVBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        barDbBtn.setBorder(new EmptyBorder(0, 0, 0, 0));

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
    private static void roundButtonCorners(AbstractButton button, int radius) {
        button.setBorder(new LineBorder(button.getBackground(), radius, true));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
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