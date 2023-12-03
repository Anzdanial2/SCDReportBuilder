package UI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
//Upper Cards here
public class UpperCards {
    ReportUI reportUI;
    JLabel titleLabel;
    JTextField titleField;
    JLabel selectComponentsLabel;
    //Test
    JCheckBox textCheckBox;
    JLabel textDataSourceLabel;
    JRadioButton textTxtBtn;
    JRadioButton textDbBtn;
    ButtonGroup textSource;
    JButton textFileChooserBtn;
    JLabel textDbLabel;
    JTextField textDbField;
    JCheckBox tableCheckBox;
    JCheckBox imageCheckBox;
    //Image card
    JButton imageFileChooserBtn;
    JLabel imageSourceLabel;
    JRadioButton imageDbBtn;
    JRadioButton imageFileBtn;
    ButtonGroup imageSource;
    //table
    JLabel tableDataSourceLabel;
    JButton tableFileChooser;
    JLabel tableDbLabel;
    JTextField tableDbField;
    JRadioButton tableCSVBtn;
    JRadioButton tableDbBtn;
    ButtonGroup tableSource;
    JButton tableColorBtn;
    JPanel upperPanel1;
    JPanel upperPanel2;
    JPanel upperPanel;
    JPanel textPanel;
    JPanel textPanel2;
    JPanel textPanel3;
    JPanel tabelPanel;
    JPanel tablePanel2;
    JPanel tablePanel3;
    JPanel imagePanel;
    JPanel textPanel4;
    JPanel textPanel5;
    JPanel tablePanel4;
    JPanel tablePanel5;
    JPanel imagePanel1;
    JPanel imagePanel2;
    Font boldFont;
    Font mediumFont;
    Font titleFont;
    Font fieldFont;
    Font titleFieldFont;
    Font componentFont;
    JPanel imagePanel3;
    public UpperCards(){
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
        selectComponentsLabel = new JLabel("Select Components");
        selectComponentsLabel.setFont(titleFont);

        //Text
        textCheckBox = new JCheckBox("Text");
        textCheckBox.setFocusable(false);
        textCheckBox.setFont(componentFont);
        textDataSourceLabel  = new JLabel("Select Data Source");
        textDataSourceLabel.setFont(boldFont);
        textTxtBtn = new JRadioButton("txt file");
        textTxtBtn.setFocusable(false);
        textTxtBtn.setFont(mediumFont);
        textDbBtn = new JRadioButton("Data Base");
        textDbBtn.setFocusable(false);
        textDbBtn.setFont(mediumFont);
        textSource = new ButtonGroup();
        textSource.add(textTxtBtn);
        textSource.add(textDbBtn);
        textFileChooserBtn = new JButton("Choose File");
        textFileChooserBtn.setFocusable(false);
        textFileChooserBtn.setBackground(new Color(179, 208, 255));
        textFileChooserBtn.setFont(boldFont);
        textDbLabel = new JLabel("DataBase Name:");
        textDbField = new JTextField(10);

        //Image
        imageCheckBox = new JCheckBox("Image/Logo");
        imageCheckBox.setFocusable(false);
        imageCheckBox.setFont(componentFont);
        imageFileChooserBtn = new JButton("Choose Image");
        imageFileChooserBtn.setFocusable(false);
        imageFileChooserBtn.setBackground(new Color(179, 208, 255));
        imageFileChooserBtn.setFont(boldFont);
        imageSourceLabel = new JLabel("Select Data Source");
        imageSourceLabel.setFont(boldFont);
        imageFileBtn = new JRadioButton("png");
        imageFileBtn.setFocusable(false);
        imageFileBtn.setFont(mediumFont);
        imageDbBtn = new JRadioButton("Data Base");
        imageDbBtn.setFocusable(false);
        imageDbBtn.setFont(mediumFont);
        imageSource = new ButtonGroup();
        imageSource.add(imageFileBtn);
        imageSource.add(imageDbBtn);

        //Table
        tableDataSourceLabel  = new JLabel("Select Data Source");
        tableDataSourceLabel.setFont(boldFont);
        tableCheckBox = new JCheckBox("Table");
        tableCheckBox.setFocusable(false);
        tableCheckBox.setFont(componentFont);
        tableCSVBtn = new JRadioButton("CSV");
        tableCSVBtn.setFocusable(false);
        tableCSVBtn.setFont(mediumFont);
        tableDbBtn = new JRadioButton("Data Base");
        tableDbBtn.setFocusable(false);
        tableDbBtn.setFont(mediumFont);
        tableSource = new ButtonGroup();
        tableSource.add(tableCSVBtn);
        tableSource.add(tableDbBtn);
        tableFileChooser = new JButton("Choose CSV");
        tableFileChooser.setFocusable(false);
        tableFileChooser.setBackground(new Color(179, 208, 255));
        tableFileChooser.setFont(boldFont);
        tableDbLabel = new JLabel("DB name");
        tableDbField = new JTextField(10);
        tableColorBtn = new JButton("Choose Color");
        tableColorBtn.setFocusable(false);
        tableColorBtn.setBackground(new Color(179, 208, 255));
        tableColorBtn.setFont(boldFont);

        //text Layout
        textPanel2 = new JPanel(new GridLayout(2,1,5,7));
        textPanel2.add(textCheckBox);
        textPanel2.add(textDataSourceLabel);
        textPanel3 = new JPanel(new GridLayout(2,2,5,7));
        textPanel3.add(textTxtBtn);
        textPanel3.add(textDbBtn);
        textPanel3.add(textFileChooserBtn);
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.Y_AXIS));
        textPanel.add(textPanel2);
        textPanel.add(textPanel3);
        textPanel.setBackground(new Color(83, 140, 198));
        setPanelBackground(textPanel, new Color(83, 140, 198));

        tablePanel2 = new JPanel(new GridLayout(2,1,5,7));
        tablePanel2.add(tableCheckBox);
        tablePanel2.add(tableDataSourceLabel);

        tablePanel3 = new JPanel(new GridLayout(2,2,5,7));
        tablePanel3.add(tableCSVBtn);
        tablePanel3.add(tableDbBtn);
        tablePanel3.add(tableFileChooser);
        tablePanel3.add(tableColorBtn);

        tabelPanel = new JPanel();
        tabelPanel.setLayout(new BoxLayout(tabelPanel,BoxLayout.Y_AXIS));
        tabelPanel.add(tablePanel2);
        tabelPanel.add(tablePanel3);
        tabelPanel.setBackground(new Color(83, 140, 198));
        setPanelBackground(tabelPanel, new Color(83, 140, 198));

        //Image Layout
        imagePanel1 = new JPanel(new GridLayout(2,1,5,7));
        imagePanel1.add(imageCheckBox);
        imagePanel1.add(imageSourceLabel);

        imagePanel2 = new JPanel(new GridLayout(2,2,5,7));
        imagePanel2.add(imageFileBtn);
        imagePanel2.add(imageDbBtn);
        imagePanel2.add(imageFileChooserBtn);

        imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel,BoxLayout.Y_AXIS));
        imagePanel.add(imagePanel1);
        imagePanel.add(imagePanel2);
        imagePanel.setBackground(new Color(83, 140, 198)); // light blue
        setPanelBackground(imagePanel, new Color(83, 140, 198));

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
        tabelPanel.setBorder(new CompoundBorder(roundedBorder1, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        imagePanel.setBorder(new CompoundBorder(roundedBorder1, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        upperPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        upperPanel2.add(textPanel);
        upperPanel2.add(tabelPanel);
        upperPanel2.add(imagePanel);

        upperPanel = new JPanel(new BorderLayout());
        upperPanel.add(upperPanel1,BorderLayout.NORTH);
        upperPanel.add(selectComponentsLabel,BorderLayout.CENTER);
        upperPanel.add(upperPanel2,BorderLayout.SOUTH);


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
    private void createReportUI(){
        if(reportUI==null){
            reportUI = new ReportUI();
        }
        reportUI.showFrame();
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
        return upperPanel;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Report Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100,850);
        UpperCards uc = new UpperCards();
        LowerCards lc = new LowerCards();
        frame.setLayout(new BorderLayout());
        frame.add(uc.getUpperPanel(),BorderLayout.NORTH);
        frame.add(lc.getLowerPanel(),BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
