package UI;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Represents the upper card panel in the UI, handling the configuration of various components like Text, Image, and Table.
 * This class provides a user interface for selecting these components and configuring their respective properties.
 */
public class UpperCard {
    private JLabel titleLabel;
    private JTextField titleField;
    private JLabel selectComponentsLabel;
    // Test
    private JCheckBox textCheckBox;
    private JLabel textDataSourceLabel;
    private JRadioButton textTxtBtn;
    private JRadioButton textDbBtn;
    private ButtonGroup textSource;
    private JButton textFileChooserBtn;
    private JLabel textDbLabel;
    private JTextField textDbField;
    private JCheckBox tableCheckBox;
    private JCheckBox imageCheckBox;
    // Image card
    private JButton imageFileChooserBtn;
    private JLabel imageSourceLabel;
    private JRadioButton imageDbBtn;
    private JRadioButton imageFileBtn;
    private ButtonGroup imageSource;
    // Table
    private JLabel tableDataSourceLabel;
    private JButton tableFileChooser;
    private JLabel tableDbLabel;
    private JTextField tableDbField;
    private JRadioButton tableCSVBtn;
    private JRadioButton tableDbBtn;
    private ButtonGroup tableSource;
    private JButton tableColorBtn;
    private JPanel upperPanel1;
    private JPanel upperPanel2;
    private JPanel upperPanel;
    private JPanel textPanel;
    private JPanel textPanel2;
    private JPanel textPanel3;
    private JPanel tablePanel;
    private JPanel tablePanel2;
    private JPanel tablePanel3;
    private JPanel imagePanel;
    private JPanel textPanel4;
    private JPanel textPanel5;
    private JPanel tablePanel4;
    private JPanel tablePanel5;
    private JPanel imagePanel1;
    private JPanel imagePanel2;
    private Font boldFont;
    private Font mediumFont;
    private Font titleFont;
    private Font fieldFont;
    private Font titleFieldFont;
    private Font componentFont;
    private JPanel imagePanel3;

    private boolean textCompSelected;
    private JFileChooser textFileChooser;
    private String textFromFileChooser;

    private boolean imageCompSelected;
    private JFileChooser imageFileChooser;
    private String imageFilePath;
    private String reportTitle;
    private boolean tableCompSelected;

    private boolean textRadioTXTSelected;
    private boolean textRadioDBSelected;

    /**
     * Constructor for the UpperCard class.
     * Initializes UI components and sets up action listeners for the various controls.
     */
    public UpperCard(){
        fieldFont = new Font("SansSerif", Font.PLAIN, 15);
        titleFieldFont = new Font("SansSerif", Font.BOLD, 20);
        boldFont = new Font("SansSerif", Font.BOLD, 16);
        componentFont = new Font("SansSerif", Font.BOLD, 20);
        mediumFont = new Font("SansSerif", Font.TRUETYPE_FONT, 15);
        titleFont = new Font("SansSerif", Font.BOLD, 25);
        titleLabel = new JLabel("Title");
        titleLabel.setFont(titleFont);
        titleField = new JTextField(30);
        titleField.setFont(titleFieldFont);
        titleField.setPreferredSize(new Dimension(titleField.getPreferredSize().width, 35));
        titleField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTextFieldContent();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTextFieldContent();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTextFieldContent();
            }

            // Helper method to update the text field content variable
            private void updateTextFieldContent() {
                reportTitle = titleField.getText();
            }
        });
        selectComponentsLabel = new JLabel("Select Components");
        selectComponentsLabel.setFont(titleFont);

        //Text
        textConstructor();
        //Image
        imageConstructor();
        //Table
        tableConstructor();


        //Composing Layouts
        upperPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        upperPanel1.add(titleLabel);
        upperPanel1.add(titleField);

        // Create a rounded border
        Border roundedBorder1 = new LineBorder(new Color(83, 140, 198), 2, true);
        Border roundedBorder2 = new LineBorder(Color.BLACK, 2, true);
        Border roundedBorder3 = new LineBorder(Color.BLACK, 2, true);

        // Add rounded border to each panel with some empty space
        textPanel.setBorder(new CompoundBorder(roundedBorder1, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        tablePanel.setBorder(new CompoundBorder(roundedBorder1, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        imagePanel.setBorder(new CompoundBorder(roundedBorder1, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        upperPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        upperPanel2.add(textPanel);
        upperPanel2.add(tablePanel);
        upperPanel2.add(imagePanel);

        upperPanel = new JPanel(new BorderLayout());
        upperPanel.add(upperPanel1,BorderLayout.NORTH);
        upperPanel.add(selectComponentsLabel,BorderLayout.CENTER);
        upperPanel.add(upperPanel2,BorderLayout.SOUTH);
    }

    /**
     * Initializes UI components for Text component configuration.
     */
    public void textConstructor() {
        textCompSelected = false;
        textFromFileChooser = "";
        textCheckBox = new JCheckBox("Text");
        textCheckBox.setFocusable(false);
        textCheckBox.setFont(componentFont);
        textCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textCompSelected = textCheckBox.isSelected();
            }
        });

        // Commented out unnecessary components
//        textDataSourceLabel = new JLabel("Select Data Source");
//        textDataSourceLabel.setFont(boldFont);
//        textTxtBtn = new JRadioButton("TXT File");
//        textTxtBtn.setFocusable(false);
//        textTxtBtn.setFont(mediumFont);
//        textTxtBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (textCompSelected)
//                    textRadioTXTSelected = textTxtBtn.isSelected();
//            }
//        });
//        textDbBtn = new JRadioButton("DataBase");
//        textDbBtn.setFocusable(false);
//        textDbBtn.setFont(mediumFont);
//        textDbBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (textCompSelected)
//                    textRadioDBSelected = textDbBtn.isSelected();
//            }
//        });
//        textSource = new ButtonGroup();
//        textSource.add(textTxtBtn);
//        textSource.add(textDbBtn);
        textFileChooserBtn = new JButton("Choose File");
        textFileChooserBtn.setFocusable(false);
        textFileChooserBtn.setBackground(new Color(179, 208, 255));
        textFileChooserBtn.setFont(boldFont);

        textFileChooserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textCompSelected) {
                    textFileChooser = new JFileChooser();
                    int result = textFileChooser.showOpenDialog(null);

                    // Check if a file is selected
                    if (result == JFileChooser.APPROVE_OPTION) {
                        try {
                            String selectedFilePath = textFileChooser.getSelectedFile().getAbsolutePath();

                            // Read the contents of the selected file into a String
                            textFromFileChooser = new String(Files.readAllBytes(Paths.get(selectedFilePath)), StandardCharsets.UTF_8);

                            // Do something with the file contents (e.g., store it in a variable)
                            JOptionPane.showMessageDialog(null, "File Contents:\n" + textFromFileChooser, "File Loaded Successfully", JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            // Handle IOException (e.g., show an error message)
                        }
                    }
                } else {
                    // Provide a parent component for the JOptionPane
                    JOptionPane.showMessageDialog(null, "Text Component Not Selected", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
//        textDbLabel = new JLabel("DataBase Name:");
//        textDbField = new JTextField(10);

        textPanel2 = new JPanel(new GridLayout(2, 1, 5, 7)); // Adjusted the grid layout
        textPanel2.add(textCheckBox);
//        textPanel2.add(textDataSourceLabel);
        textPanel3 = new JPanel(new GridLayout(2, 2, 5, 7));
//        textPanel3.add(textTxtBtn);
//        textPanel3.add(textDbBtn);
        textPanel3.add(textFileChooserBtn);

        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(textPanel2);
        textPanel.add(textPanel3);
        textPanel.setBackground(new Color(83, 140, 198));
        setPanelBackground(textPanel, new Color(83, 140, 198));
    }

    public boolean getTextCompSelected(){
        return textCompSelected;
    }
    public String getTextFromFileChooser(){return textFromFileChooser;}
    public String getReportTitle(){return reportTitle;}

    /**
     * Initializes UI components for Image component configuration.
     */
    public void imageConstructor() {
        imageCompSelected = false;
        imageFilePath = "";
        imageCheckBox = new JCheckBox("Image/Logo");
        imageCheckBox.setFocusable(false);
        imageCheckBox.setFont(componentFont);
        imageFileChooserBtn = new JButton("Choose Image");
        imageFileChooserBtn.setFocusable(false);
        imageFileChooserBtn.setBackground(new Color(179, 208, 255));
        imageFileChooserBtn.setFont(boldFont);

        imageCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageCompSelected = imageCheckBox.isSelected();
            }
        });

        imageFileChooserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imageCompSelected) {
                    imageFileChooser = new JFileChooser();
                    int result = imageFileChooser.showOpenDialog(null);

                    // Check if a file is selected
                    if (result == JFileChooser.APPROVE_OPTION) {
                        imageFilePath = imageFileChooser.getSelectedFile().getAbsolutePath();
                        // Do something with the file contents (e.g., store it in a variable)
                        JOptionPane.showMessageDialog(null, "File Path:\n" + imageFilePath, "File Loaded Successfully", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    // Provide a parent component for the JOptionPane
                    JOptionPane.showMessageDialog(null, "Image Component Not Selected", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Commented out unnecessary components
//        imageSourceLabel = new JLabel("Select Data Source");
//        imageSourceLabel.setFont(boldFont);
//        imageFileBtn = new JRadioButton("png");
//        imageFileBtn.setFocusable(false);
//        imageFileBtn.setFont(mediumFont);
//        imageDbBtn = new JRadioButton("Data Base");
//        imageDbBtn.setFocusable(false);
//        imageDbBtn.setFont(mediumFont);
//        imageSource = new ButtonGroup();
//        imageSource.add(imageFileBtn);
//        imageSource.add(imageDbBtn);
        imagePanel1 = new JPanel(new GridLayout(2, 1, 5, 7));
        imagePanel1.add(imageCheckBox);
//        imagePanel1.add(imageSourceLabel);
        imagePanel2 = new JPanel(new GridLayout(2, 2, 5, 7));
//        imagePanel2.add(imageFileBtn);
//        imagePanel2.add(imageDbBtn);
        imagePanel2.add(imageFileChooserBtn);
//        imagePanel = new JPanel();
//        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
//        imagePanel.add(imagePanel1);
        imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imagePanel.add(imagePanel1);
        imagePanel.add(imagePanel2);
        imagePanel.setBackground(new Color(83, 140, 198)); // light blue
        setPanelBackground(imagePanel, new Color(83, 140, 198));
    }
    public boolean getImageCompSelected(){
        return imageCompSelected;
    }
    public String getImageFilePath(){return imageFilePath;}

    /**
     * Initializes UI components for Table component configuration.
     */
    public void tableConstructor() {
        tableCompSelected = false;
        tableDataSourceLabel = new JLabel("Select Data Source");
        tableDataSourceLabel.setFont(boldFont);
        tableCheckBox = new JCheckBox("Table");
        tableCheckBox.setFocusable(false);
        tableCheckBox.setFont(componentFont);

        tableCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableCompSelected = tableCheckBox.isSelected();
            }
        });
        // Commented out unnecessary components
//        tableCSVBtn = new JRadioButton("CSV");
//        tableCSVBtn.setFocusable(false);
//        tableCSVBtn.setFont(mediumFont);
//        tableDbBtn = new JRadioButton("Data Base");
//        tableDbBtn.setFocusable(false);
//        tableDbBtn.setFont(mediumFont);
//        tableSource = new ButtonGroup();
//        tableSource.add(tableCSVBtn);
//        tableSource.add(tableDbBtn);
//        tableFileChooser = new JButton("Choose CSV");
//        tableFileChooser.setFocusable(false);
//        tableFileChooser.setBackground(new Color(179, 208, 255));
//        tableFileChooser.setFont(boldFont);
//        tableDbLabel = new JLabel("DB name");
//        tableDbField = new JTextField(10);
//        tableColorBtn = new JButton("Choose Color");
//        tableColorBtn.setFocusable(false);
//        tableColorBtn.setBackground(new Color(179, 208, 255));
//        tableColorBtn.setFont(boldFont);
        tablePanel2 = new JPanel(new GridLayout(3, 1, 5, 7));
        tablePanel2.add(tableCheckBox);
//        tablePanel2.add(tableDataSourceLabel);
//        tablePanel3 = new JPanel(new GridLayout(2, 2, 5, 7));
//        tablePanel3.add(tableCSVBtn);
//        tablePanel3.add(tableDbBtn);
//        tablePanel3.add(tableFileChooser);
//        tablePanel3.add(tableColorBtn);
//        tablePanel = new JPanel();
//        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
//        tablePanel.add(tablePanel2);
//        tablePanel.add(tablePanel3);
        tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
        tablePanel.add(tablePanel2);
        tablePanel.setBackground(new Color(83, 140, 198));
        setPanelBackground(tablePanel, new Color(83, 140, 198));
    }
    public boolean getTableCompSelected(){
        return tableCompSelected;
    }


    // Helper method to set background color for a panel and its child components
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

    private void setFixedPanelSize(JPanel panel, int width, int height) {
        panel.setPreferredSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
        panel.setMaximumSize(new Dimension(width, height));
    }


    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JLabel getSelectComponentsLabel() {
        return selectComponentsLabel;
    }

    public JCheckBox getTextCheckBox() {
        return textCheckBox;
    }

    public JLabel getTextDataSourceLabel() {
        return textDataSourceLabel;
    }

    public JRadioButton getTextTxtBtn() {
        return textTxtBtn;
    }

    public JRadioButton getTextDbBtn() {
        return textDbBtn;
    }

    public ButtonGroup getTextSource() {
        return textSource;
    }

    public JButton getTextFileChooserBtn() {
        return textFileChooserBtn;
    }

    public JLabel getTextDbLabel() {
        return textDbLabel;
    }

    public JTextField getTextDbField() {
        return textDbField;
    }

    public JCheckBox getTableCheckBox() {
        return tableCheckBox;
    }

    public JCheckBox getImageCheckBox() {
        return imageCheckBox;
    }

    public JButton getImageFileChooserBtn() {
        return imageFileChooserBtn;
    }

    public JLabel getImageSourceLabel() {
        return imageSourceLabel;
    }

    public JRadioButton getImageDbBtn() {
        return imageDbBtn;
    }

    public JRadioButton getImageFileBtn() {
        return imageFileBtn;
    }

    public ButtonGroup getImageSource() {
        return imageSource;
    }

    public JLabel getTableDataSourceLabel() {
        return tableDataSourceLabel;
    }

    public JButton getTableFileChooser() {
        return tableFileChooser;
    }

    public JLabel getTableDbLabel() {
        return tableDbLabel;
    }

    public JTextField getTableDbField() {
        return tableDbField;
    }

    public JRadioButton getTableCSVBtn() {
        return tableCSVBtn;
    }

    public JRadioButton getTableDbBtn() {
        return tableDbBtn;
    }

    public ButtonGroup getTableSource() {
        return tableSource;
    }

    public JButton getTableColorBtn() {
        return tableColorBtn;
    }


    public JPanel getUpperPanel() {
        // Set fixed sizes for each panel
        setFixedPanelSize(textPanel, 200, 150); // Adjust the width and height as needed
        setFixedPanelSize(tablePanel, 200, 150); // Adjust the width and height as needed
        setFixedPanelSize(imagePanel, 200, 150); // Adjust the width and height as needed

        return upperPanel;
    }
}
