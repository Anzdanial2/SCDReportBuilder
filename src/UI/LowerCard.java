package UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LowerCard {
    //Pie
    JCheckBox pieCheckBox;
    JLabel pieSelectSourceLabel;
    JRadioButton pieCSVBtn;
    JRadioButton pieDbBtn;
    ButtonGroup pieSource;
    JButton pieFileChooser;
    JLabel pieLegendsLabel;
    JCheckBox pieLegendsBox;
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
    JCheckBox lineLegendsBox;
    JLabel lineAxisValueLabel;
    JCheckBox lineAxisBox;
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
    JCheckBox barLegendsBox;
    JLabel barAxisValueLabel;
    JCheckBox barAxisBox;
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

    //LINE
    private boolean lineChartSelected;
    private boolean lineCSVSelected;
    private boolean lineDBSelected;
    private String lineCSVPath;
    private boolean lineLegendsSelected;
    private boolean lineAxisValuesSelected;

    //PIE
    private boolean pieChartSelected;
    private boolean pieCSVSelected;
    private boolean pieDBSelected;
    private String pieCSVPath;
    private boolean pieLegendsSelected;

    //BAR
    private boolean barChartSelected;
    private boolean barCSVSelected;
    private boolean barDBSelected;
    private String barCSVPath;
    private boolean barLegendsSelected;
    private boolean barAxisValuesSelected;

    public LowerCard(GenerateReportCallback callback){
        fieldFont = new Font("SansSerif", Font.PLAIN, 15);
        boldFont = new Font("SansSerif", Font.BOLD, 16);
        mediumFont = new Font("SansSerif", Font.TRUETYPE_FONT, 15);
        componentFont = new Font("SansSerif", Font.BOLD, 20);
        pieChartConstructor();
        lineChartConstructor();
        barChartConstructor();

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
        piePanel3.add(pieLegendsBox);
//        piePanel3.add(pieColorChooser);

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
//        linePanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,7));
//        linePanel3.add(lineXaxisLabel);
//        linePanel3.add(lineXaxisField);
//        linePanel3.add(lineYaxisLabel);
//        linePanel3.add(lineYaxisField);


        linePanel4 = new JPanel(new GridLayout(2,3,5,7));
        linePanel4.add(lineLegendsLabel);
        linePanel4.add(lineLegendsBox);
        linePanel4.add(lineAxisValueLabel);
        linePanel4.add(lineAxisBox);
//        linePanel4.add(lineColorBtn);
        linePanel = new JPanel();
        linePanel.setLayout(new BoxLayout(linePanel,BoxLayout.Y_AXIS));
        linePanel.add(linePanel1);
        linePanel.add(linePanel2);
//        linePanel.add(linePanel3);
        linePanel.add(linePanel4);

        barPanel1 = new JPanel(new GridLayout(2,1,5,7));
        barPanel1.add(barCheckBox);
        barPanel1.add(barSelectSourceLabel);
        barPanel2 = new JPanel(new GridLayout(2,2,5,7));
        barPanel2.add(barCSVBtn);
        barPanel2.add(barDbBtn);
        barPanel2.add(barFileChooser);
//        barPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,7));
//        barPanel3.add(barXaxisLabel);
//        barPanel3.add(barXaxisField);
//        barPanel3.add(barYaxisLabel);
//        barPanel3.add(barYaxisField);


        barPanel4 = new JPanel(new GridLayout(2,3,5,7));
        barPanel4.add(barLegendsLabel);
        barPanel4.add(barLegendsBox);
        barPanel4.add(barAxisValueLabel);
        barPanel4.add(barAxisBox);
//        barPanel4.add(barColorBtn);
        barPanel = new JPanel();
        barPanel.setLayout(new BoxLayout(barPanel,BoxLayout.Y_AXIS));
        barPanel.add(barPanel1);
        barPanel.add(barPanel2);
//        barPanel.add(barPanel3);
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
        lowerPanel = new JPanel(new BorderLayout(10, 10)); // added gaps between components

        JPanel topPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // increased the horizontal gap
        topPanel.add(linePanel);
        topPanel.add(barPanel);

        lowerPanel.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10)); // added gaps between components
        piePanel.setBorder(new CompoundBorder(roundedBorder, BorderFactory.createEmptyBorder(20, 20, 20, 20))); // increased border insets
        bottomPanel.add(piePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10)); // added gaps between components
        buttonPanel.add(generateReportBtn);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        lowerPanel.add(bottomPanel, BorderLayout.CENTER);

        // Adjust margins or padding around the panels if necessary
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10)); // Adjust top and bottom padding for the top panel
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));


        // Added the following code to set the border to EmptyBorder
        pieCSVBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        pieDbBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        lineCSVBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        lineDbBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        barCSVBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        barDbBtn.setBorder(new EmptyBorder(0, 0, 0, 0));


        generateReportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callback.onGenerateReportClicked();
            }
        });

    }

    public void pieChartConstructor(){
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
        pieLegendsBox = new JCheckBox("Yes/No");
        pieLegendsBox.setFocusable(false);
        pieLegendsBox.setFont(mediumFont);

        pieCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pieChartSelected = pieCheckBox.isSelected();
            }
        });

        pieCSVBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pieChartSelected) {
                    pieCSVSelected = pieCSVBtn.isSelected();
                } else {
                    JOptionPane.showMessageDialog(null, "Pie Chart Not Selected", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pieDbBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pieChartSelected) {
                    pieDBSelected = pieDbBtn.isSelected();
                } else {
                    JOptionPane.showMessageDialog(null, "Pie Chart Not Selected", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pieFileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pieChartSelected) {
                    JFileChooser imageFileChooser = new JFileChooser();
                    int result = imageFileChooser.showOpenDialog(null);

                    if (result == JFileChooser.APPROVE_OPTION) {
                        pieCSVPath = imageFileChooser.getSelectedFile().getAbsolutePath();
                        JOptionPane.showMessageDialog(null, "File Path:\n" + pieCSVPath, "File Loaded Successfully", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pie Chart Not Selected", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pieLegendsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pieLegendsSelected = pieLegendsBox.isSelected();
            }
        });


//        pieColorChooser = new JButton("Choose Color");
//        pieColorChooser.setFocusable(false);
//        pieColorChooser.setFont(boldFont);
//        pieColorChooser.setBackground(new Color(179, 208, 255));
    }
    public void lineChartConstructor(){
        lineCheckBox = new JCheckBox("Line Chart");
        lineCheckBox.setFocusable(false);
        lineCheckBox.setFont(componentFont);
        lineCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lineChartSelected = lineCheckBox.isSelected();
            }
        });

        lineSelectSourceLabel = new JLabel("Select Data Source");
        lineSelectSourceLabel.setFont(boldFont);
        lineCSVBtn = new JRadioButton("CSV");
        lineCSVBtn.setFocusable(false);
        lineCSVBtn.setFont(mediumFont);

        lineCSVBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lineChartSelected){
                    lineCSVSelected = lineCSVBtn.isSelected();
                }
                else
                    JOptionPane.showMessageDialog(null, "Line Chart Not Selected", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        lineDbBtn = new JRadioButton("Data Base");
        lineDbBtn.setFocusable(false);
        lineDbBtn.setFont(mediumFont);

        lineDbBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lineChartSelected){
                    lineDBSelected = lineDbBtn.isSelected();
                }
                else
                    JOptionPane.showMessageDialog(null, "Line Chart Not Selected", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        lineSource = new ButtonGroup();
        lineSource.add(lineCSVBtn);
        lineSource.add(lineDbBtn);
        lineFileChooser = new JButton("Choose CSV");
        lineFileChooser.setFocusable(false);
        lineFileChooser.setBackground(new Color(179, 208, 255));
        lineFileChooser.setFont(boldFont);
        lineFileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lineChartSelected) {
                    JFileChooser imageFileChooser = new JFileChooser();
                    int result = imageFileChooser.showOpenDialog(null);

                    // Check if a file is selected
                    if (result == JFileChooser.APPROVE_OPTION) {
                        lineCSVPath = imageFileChooser.getSelectedFile().getAbsolutePath();
                        // Do something with the file contents (e.g., store it in a variable)
                        JOptionPane.showMessageDialog(null, "File Path:\n" + lineCSVPath, "File Loaded Successfully", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    // Provide a parent component for the JOptionPane
                    JOptionPane.showMessageDialog(null, "Line Chart Not Selected", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

//        lineXaxisLabel = new JLabel("X-axis Name");
//        lineXaxisLabel.setFont(boldFont);
//        lineYaxisLabel = new JLabel("Y-axis Name");
//        lineYaxisLabel.setFont(boldFont);
//        lineXaxisField = new JTextField(10);
//        lineXaxisField.setFont(fieldFont);
//        lineYaxisField = new JTextField(10);
//        lineYaxisField.setFont(fieldFont);
        lineLegendsLabel = new JLabel("Display Legends");
        lineLegendsLabel.setFont(boldFont);
        lineLegendsBox = new JCheckBox("Yes/No");
        lineLegendsBox.setFocusable(false);
        lineLegendsBox.setFont(mediumFont);

        lineAxisValueLabel = new JLabel("Display Axis Values");
        lineAxisValueLabel.setFont(boldFont);
        lineAxisBox = new JCheckBox("Yes/No");
        lineAxisBox.setFocusable(false);
        lineAxisBox.setFont(mediumFont);

        lineLegendsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lineLegendsSelected = lineLegendsBox.isSelected();
            }
        });

        lineAxisBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lineAxisValuesSelected = lineAxisBox.isSelected();
            }
        });


//        lineColorBtn = new JButton("Choose Color");
//        lineColorBtn.setFocusable(false);
//        lineColorBtn.setBackground(new Color(179, 208, 255));
//        lineColorBtn.setFont(boldFont);
    }
    public void barChartConstructor(){
        barCheckBox = new JCheckBox("Bar Chart");
        barCheckBox.setFocusable(false);
        barCheckBox.setFont(componentFont);

        barCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barChartSelected = barCheckBox.isSelected();
            }
        });

        barSelectSourceLabel = new JLabel("Select Data Source");
        barSelectSourceLabel.setFont(boldFont);
        barCSVBtn = new JRadioButton("CSV");
        barCSVBtn.setFocusable(false);
        barCSVBtn.setFont(mediumFont);

        barCSVBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(barChartSelected){
                    barCSVSelected = barCSVBtn.isSelected();
                }
                else
                    JOptionPane.showMessageDialog(null, "Bar Chart Not Selected", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        barDbBtn = new JRadioButton("Data Base");
        barDbBtn.setFocusable(false);
        barDbBtn.setFont(mediumFont);

        barDbBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(barChartSelected){
                    barDBSelected = barDbBtn.isSelected();
                }
                else
                    JOptionPane.showMessageDialog(null, "Bar Chart Not Selected", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        barSource = new ButtonGroup();
        barSource.add(lineCSVBtn);
        barSource.add(lineDbBtn);
//        barXaxisLabel = new JLabel("X-axis Name");
//        barXaxisLabel.setFont(boldFont);
//        barYaxisLabel = new JLabel("Y-axis Name");
//        barYaxisLabel.setFont(boldFont);
//        barXaxisField = new JTextField(10);
//        barXaxisField.setFont(fieldFont);
//        barYaxisField = new JTextField(10);
//        barYaxisField.setFont(fieldFont);
        barFileChooser = new JButton("Choose CSV");
        barFileChooser.setFocusable(false);
        barFileChooser.setBackground(new Color(179, 208, 255));

        barFileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (barChartSelected) {
                    JFileChooser imageFileChooser = new JFileChooser();
                    int result = imageFileChooser.showOpenDialog(null);

                    // Check if a file is selected
                    if (result == JFileChooser.APPROVE_OPTION) {
                        barCSVPath = imageFileChooser.getSelectedFile().getAbsolutePath();
                        // Do something with the file contents (e.g., store it in a variable)
                        JOptionPane.showMessageDialog(null, "File Path:\n" + barCSVPath, "File Loaded Successfully", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    // Provide a parent component for the JOptionPane
                    JOptionPane.showMessageDialog(null, "Bar Chart Not Selected", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

//        barFileChooser.setForeground(new Color(51, 133, 255));
        barFileChooser.setFont(boldFont);
        barLegendsLabel = new JLabel("Display Legends");
        barLegendsLabel.setFont(boldFont);
        barLegendsBox = new JCheckBox("Yes/No");
        barLegendsBox.setFocusable(false);
        barLegendsBox.setFont(mediumFont);
        barAxisValueLabel = new JLabel("Display Axis Values");
        barAxisValueLabel.setFont(boldFont);
        barAxisBox = new JCheckBox("Yes/No");
        barAxisBox.setFocusable(false);
        barAxisBox.setFont(mediumFont);

        barLegendsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barLegendsSelected = barLegendsBox.isSelected();
            }
        });

        barAxisBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barAxisValuesSelected = barAxisBox.isSelected();
            }
        });


//        barColorBtn = new JButton("Choose Color");
//        barColorBtn.setFocusable(false);
//        barColorBtn.setFont(boldFont);
//        barColorBtn.setBackground(new Color(179, 208, 255));
    }

    public boolean isLineChartSelected() {
        return lineChartSelected;
    }

    public boolean isLineCSVSelected() {
        return lineCSVSelected;
    }

    public boolean isLineDBSelected() {
        return lineDBSelected;
    }

    public String getLineCSVPath() {
        return lineCSVPath;
    }

    public boolean isLineLegendsSelected() {
        return lineLegendsSelected;
    }

    public boolean isLineAxisValuesSelected() {
        return lineAxisValuesSelected;
    }

    // Getters for Bar Chart
    public boolean isBarChartSelected() {
        return barChartSelected;
    }

    public boolean isBarCSVSelected() {
        return barCSVSelected;
    }

    public boolean isBarDBSelected() {
        return barDBSelected;
    }

    public String getBarCSVPath() {
        return barCSVPath;
    }

    public boolean isBarLegendsSelected() {
        return barLegendsSelected;
    }

    public boolean isBarAxisValuesSelected() {
        return barAxisValuesSelected;
    }

    // Getters for Pie Chart
    public boolean isPieChartSelected() {
        return pieChartSelected;
    }

    public boolean isPieCSVSelected() {
        return pieCSVSelected;
    }

    public boolean isPieDBSelected() {
        return pieDBSelected;
    }

    public String getPieCSVPath() {
        return pieCSVPath;
    }

    public boolean isPieLegendsSelected() {
        return pieLegendsSelected;
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

    public JCheckBox getPieLegendsBox() {
        return pieLegendsBox;
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

    public JCheckBox getLineLegendsBox() {
        return lineLegendsBox;
    }

    public JLabel getLineAxisValueLabel() {
        return lineAxisValueLabel;
    }

    public JCheckBox getLineAxisBox() {
        return lineAxisBox;
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

    public JCheckBox getBarLegendsBox() {
        return barLegendsBox;
    }

    public JLabel getBarAxisValueLabel() {
        return barAxisValueLabel;
    }

    public JCheckBox getBarAxisBox() {
        return barAxisBox;
    }

    public JButton getBarColorBtn() {
        return barColorBtn;
    }

    public JButton getGenerateReportBtn() {
        return generateReportBtn;
    }

}
