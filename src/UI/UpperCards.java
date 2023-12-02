package UI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class UpperCards {
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
    JPanel imagePanel3;
    public UpperCards(){
        titleLabel = new JLabel("Title");
        titleField = new JTextField(30);
        selectComponentsLabel = new JLabel("Select Components");

        //Text
        textCheckBox = new JCheckBox("Text");
        textDataSourceLabel  = new JLabel("Select Data Source");
        textTxtBtn = new JRadioButton("txt file");
        textDbBtn = new JRadioButton("Data Base");
        textSource = new ButtonGroup();
        textSource.add(textTxtBtn);
        textSource.add(textDbBtn);
        textFileChooserBtn = new JButton("Choose File");
        textDbLabel = new JLabel("DataBase Name:");
        textDbField = new JTextField(10);

        //Image
        imageCheckBox = new JCheckBox("Image/Logo");
        imageFileChooserBtn = new JButton("Choose Image");
        imageSourceLabel = new JLabel("Select Data Source");
        imageFileBtn = new JRadioButton("png");
        imageDbBtn = new JRadioButton("Data Base");
        imageSource = new ButtonGroup();
        imageSource.add(imageFileBtn);
        imageSource.add(imageDbBtn);

        //Table
        tableDataSourceLabel  = new JLabel("Select Data Source");
        tableCheckBox = new JCheckBox("Table");
        tableCSVBtn = new JRadioButton("CSV");
        tableDbBtn = new JRadioButton("Data Base");
        tableSource = new ButtonGroup();
        tableSource.add(tableCSVBtn);
        tableSource.add(tableDbBtn);
        tableFileChooser = new JButton("Choose CSV");
        tableDbLabel = new JLabel("DB name");
        tableDbField = new JTextField(10);
        tableColorBtn = new JButton("Choose Color");

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
        tabelPanel.setBackground(new Color(179, 255, 249)); // light blue
        setPanelBackground(tabelPanel, new Color(179, 255, 249));

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
        imagePanel.setBackground(new Color(179, 208, 255)); // light blue
        setPanelBackground(imagePanel, new Color(179, 208, 255));

        //Composing Layouts
        upperPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        upperPanel1.add(titleLabel);
        upperPanel1.add(titleField);

        // Create a rounded border
        Border roundedBorder1 = new LineBorder(new Color(179, 208, 255), 2, true);
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
        frame.setSize(1000,900);
        UpperCards uc = new UpperCards();
        LowerCards lc = new LowerCards();
//        uc.getUpperPanel2().add(lc.getPiePanel());
        frame.setLayout(new BorderLayout());
        frame.add(uc.getUpperPanel(),BorderLayout.NORTH);
        frame.add(lc.getLowerPanel(),BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
