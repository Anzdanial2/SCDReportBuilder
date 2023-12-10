package UI;

import BL.Components.Charts.Bar;
import BL.Components.Charts.Chart;
import BL.Components.Charts.Line;
import BL.Components.Charts.Pie;
import BL.Components.Image;
import BL.Components.Table;
import BL.Components.Text;
import BL.Reports.PDFExporter;
import BL.Reports.PNGExporter;
import BL.Reports.Report;
import DataLayer.CSV;
import DataLayer.Database;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


/**
 * The Canvas class is responsible for the user interface of the Report Builder application.
 * It handles the creation and management of various frames for user interaction,
 * including the welcome page, component selection, and report generation.
 */
public class Canvas implements GenerateReportCallback{
    private JFrame welcomeFrame;
    private JFrame selectedFrame;
    private Report report;
    private UpperCard uc;
    private LowerCard lc;

    /**
     * Displays the welcome page of the Report Builder application.
     */
    private void welcomePage() {
        welcomeFrame = new JFrame("Report Builder");
        welcomeFrame.setTitle("Report Builder");
        welcomeFrame.setSize(600, 500);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setLocationRelativeTo(null);

        welcomeFrame.setLayout(new BorderLayout(20, 20));

        // Add a panel for the heading with background color
        JPanel headingPanel = new JPanel();
        headingPanel.setBackground(new Color(63, 81, 181)); // Set background color
        headingPanel.setLayout(new BorderLayout());

        // Add the heading label with stylish font and centered
        JLabel headingLabel = new JLabel("<html><div style='text-align: center; font-size: 48px; font-family: Arial, sans-serif; font-weight: bold; color: #FFFFFF;'>Report Builder</div></html>");
        headingLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Add padding
        headingPanel.add(headingLabel, BorderLayout.CENTER);

        // Add the heading panel to the frame
        welcomeFrame.add(headingPanel, BorderLayout.NORTH);

        // Add the description label with bullet points and styling
        JLabel descriptionLabel = new JLabel("<html><div style='font-size: 16px; font-family: Arial, sans-serif; margin: 10px;'>" +
                "Welcome to the Report Builder!<br><br>" +
                "Report Builder offers component and layout customization for you to freely expand your report building process.<br><br>" +
                "We offer 3 Types of Charts:<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&bull; Line Chart<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&bull; Bar Chart<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&bull; <b>Pie Chart</b></span></div></html>");
        welcomeFrame.add(descriptionLabel, BorderLayout.CENTER);

        // Add the "Let's Start!" button with styling at the right-hand bottom
        JButton startButton = new JButton("Let's Start!");
        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        startButton.setBackground(new Color(63, 81, 181));
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event to open the new frame (SelectComponents)
                selectComponents();
                welcomeFrame.dispose(); // Close the welcome frame
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(startButton);

        // Add the button panel to the frame with margins
        welcomeFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        welcomeFrame.setVisible(true);
    }

    /**
     * Opens a new frame for selecting components for the report.
     */
    private void selectComponents() {
        JFrame selectFrame = new JFrame("Report Builder");
        selectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectFrame.setSize(1200, 700);

        uc = new UpperCard();
        lc = new LowerCard(this);

        JScrollPane scrollPane = new JScrollPane();
        JPanel scrollPanel = new JPanel(new BorderLayout());
        scrollPanel.add(uc.getUpperPanel(), BorderLayout.NORTH);
        scrollPanel.add(lc.getLowerPanel(), BorderLayout.CENTER);

        scrollPane.setViewportView(scrollPanel);
        selectFrame.add(scrollPane);

        // Add a JTextArea with the message
        JTextArea messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setText("Please Only choose One Chart Type to Generate in the report.\n");

        // Create a panel to hold the JTextArea
        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.add(messageArea, BorderLayout.CENTER);

        // Add the message panel to the frame
        selectFrame.add(messagePanel, BorderLayout.SOUTH);
        selectedFrame = selectFrame;

        selectFrame.setLocationRelativeTo(null);
        selectFrame.setVisible(true);

    }

    /**
     * Generates and displays the report based on the selected components and settings.
     */
    private void generateReport() {
        // Dispose of the previous window
        if (selectedFrame != null) {
            selectedFrame.dispose();
        }

        Text txtComp = null;
        Image imageComp = null;
        Table tableComp = null;
        Chart selectedChart = null; // Use a common type for different chart types
        // ...

        report = new Report(uc.getReportTitle());

        if (lc.isLineChartSelected()) {
            if (lc.isLineCSVSelected()) {
                selectedChart = new Line(new CSV(lc.getLineCSVPath()),lc.isLineLegendsSelected(),lc.isLineAxisValuesSelected());
                report.add(selectedChart);
            } else if (lc.isLineDBSelected()) {
                selectedChart = new Line(new Database(Database.ChartType.LINE),lc.isLineLegendsSelected(),lc.isLineAxisValuesSelected());
                report.add(selectedChart);
            }
        } else if (lc.isBarChartSelected()) {
            if (lc.isBarCSVSelected()) {
                selectedChart = new Bar(new CSV(lc.getBarCSVPath()),lc.isBarLegendsSelected(),lc.isBarAxisValuesSelected());
                report.add(selectedChart);
            } else if (lc.isBarDBSelected()) {
                selectedChart = new Bar(new Database(Database.ChartType.BAR),lc.isBarLegendsSelected(),lc.isBarAxisValuesSelected());
                report.add(selectedChart);
            }
        } else if (lc.isPieChartSelected()) {
            if (lc.isPieCSVSelected()) {
                selectedChart = new Pie(new CSV(lc.getPieCSVPath()),lc.isPieLegendsSelected());
                report.add(selectedChart);
            } else if (lc.isPieDBSelected()) {
                selectedChart = new Pie(new Database(Database.ChartType.PIE),lc.isPieLegendsSelected());
                report.add(selectedChart);
            }
        }

        if (uc.getTextCompSelected()) {
            txtComp = new Text(uc.getTextFromFileChooser());
            report.add(txtComp);
        }

        if (uc.getImageCompSelected()) {
            imageComp = new Image(uc.getImageFilePath());
            report.add(imageComp);
        }

        if (uc.getTableCompSelected() && lc.isLineChartSelected()) {
            if (lc.isLineCSVSelected()) {
                tableComp = new Table(new CSV(lc.getLineCSVPath()));
                report.add(tableComp);
            } else if (lc.isLineDBSelected()) {
                tableComp = new Table(new Database(Database.ChartType.LINE));
                report.add(tableComp);
            }
        } else if (uc.getTableCompSelected() && lc.isBarChartSelected()) {
            if (lc.isBarCSVSelected()) {
                tableComp = new Table(new CSV(lc.getBarCSVPath()));
                report.add(tableComp);
            } else if (lc.isBarDBSelected()) {
                tableComp = new Table(new Database(Database.ChartType.BAR));
                report.add(tableComp);
            }
        } else if (uc.getTableCompSelected() && lc.isPieChartSelected()) {
            if (lc.isPieCSVSelected()) {
                tableComp = new Table(new CSV(lc.getPieCSVPath()));
                report.add(tableComp);
            } else if (lc.isPieDBSelected()) {
                tableComp = new Table(new Database(Database.ChartType.PIE));
                report.add(tableComp);
            }
        }

        JFrame reportFrame = new JFrame("Generate Report");
        reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reportFrame.setSize(800, 600);

        JButton backButton = createBackButton();
        JButton exportButton = new JButton("Export As");

        String[] reportTypes = {"Select Type", "PNG", "PDF"};
        JComboBox<String> typeDropDown = new JComboBox<>(reportTypes);

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Determine which format to export based on the selected item in the dropdown
                    String selectedType = (String) typeDropDown.getSelectedItem();
                    if ("PNG".equals(selectedType)) {
                        // Call your method to export as PNG
                        report.export(new PNGExporter(reportFrame));
                    } else if ("PDF".equals(selectedType)) {
                        // Call your method to export as PDF
                        report.export(new PDFExporter(reportFrame));
                    } else {
                        JOptionPane.showMessageDialog(reportFrame, "Please select a valid export type.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(reportFrame, "Failed to export: " + ex.getMessage());
                }
            }
        });


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectComponents();
                reportFrame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(backButton, BorderLayout.WEST);

        Font titleFont = new Font("SansSerif", Font.BOLD, 20);
        JLabel reportTitleLabel = new JLabel(uc.getReportTitle(), SwingConstants.CENTER);
        reportTitleLabel.setFont(titleFont);

        buttonPanel.add(reportTitleLabel, BorderLayout.CENTER);

        JPanel exportPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        exportPanel.add(exportButton);
        exportPanel.add(typeDropDown);

        buttonPanel.add(exportPanel, BorderLayout.EAST);

        JPanel reportPanel = new JPanel(new BorderLayout());
        reportPanel.add(buttonPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel chartPanel = new JPanel(new BorderLayout());
        chartPanel.setPreferredSize(new Dimension(600, 700)); // Set preferred size for chart panel

        if (selectedChart != null) {
            JPanel selectedChartPanel = (JPanel) selectedChart.getPanel();
            selectedChartPanel.setPreferredSize(new Dimension(600, 700)); // Ensure the chart panel is properly sized
            chartPanel.add(selectedChartPanel, BorderLayout.CENTER);
        }
        contentPanel.add(chartPanel);

        report.load();
        report.display();
        // Sidebar on the right with TextComponent, TableComponent, and ImageComponent
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS)); // BoxLayout for vertical stacking

        // Check if TextComponent was selected and add it to the placeholder
        if (uc.getTextCompSelected() && txtComp != null) {
            JPanel textPanel = (JPanel) txtComp.getPanel();
            sidebarPanel.add(textPanel, BorderLayout.NORTH);
        } else {
            // Placeholder for TextComponent on the right side
            JPanel textPanel = new JPanel();
            textPanel.setBorder(BorderFactory.createTitledBorder("Text"));
            sidebarPanel.add(textPanel, BorderLayout.NORTH);
        }

        // Check if TableComponent was selected and add it to the placeholder
        if (uc.getTableCompSelected() && tableComp != null) {
            JTable table = tableComp.getTable(); // Get the JTable from your Table component
            JScrollPane tableScrollPane = new JScrollPane(table); // Wrap the table in a JScrollPane

            // Create a panel with GridBagLayout to hold the JScrollPane
            JPanel tablePanel = new JPanel(new GridBagLayout());
            tablePanel.setBorder(BorderFactory.createTitledBorder("Table"));

            // Create constraints for the GridBagLayout
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0; // Center alignment
            gbc.gridy = 0; // Center alignment
            gbc.gridwidth = 1; // The number of columns the component occupies
            gbc.gridheight = 1; // The number of rows the component occupies
            gbc.weightx = 0.5; // Request extra horizontal space
            gbc.weighty = 0.5; // Request extra vertical space
            gbc.anchor = GridBagConstraints.CENTER; // Anchor the component to the center

            // Add an empty border around the table to act as padding
            tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Add the JScrollPane with the table to the panel with constraints
            tablePanel.add(tableScrollPane, gbc);

            // This creates padding around the tablePanel
            gbc.weightx = 0;
            gbc.weighty = 0;
            gbc.gridx = 1;
            tablePanel.add(Box.createHorizontalStrut(0), gbc);

            gbc.gridx = -1;
            tablePanel.add(Box.createHorizontalStrut(0), gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            tablePanel.add(Box.createVerticalStrut(0), gbc);

            gbc.gridy = -1;
            tablePanel.add(Box.createVerticalStrut(0), gbc);

            // Now add the tablePanel to the sidebarPanel
            sidebarPanel.add(tablePanel); // Add it without BorderLayout constraints to let GridBagLayout manage the layout
        } else {
            // Placeholder for TableComponent on the right side
            JPanel emptyTablePanel = new JPanel();
            emptyTablePanel.setBorder(BorderFactory.createTitledBorder("Table"));
            sidebarPanel.add(emptyTablePanel);
        }

        // Check if ImageComponent was selected and add it to the placeholder
        if (uc.getImageCompSelected() && imageComp != null) {
            JPanel imagePanel = (JPanel) imageComp.getPanel();
            sidebarPanel.add(imagePanel, BorderLayout.SOUTH);
        } else {
            // Placeholder for ImageComponent on the right side
            JPanel imagePanel = new JPanel();
            imagePanel.setBorder(BorderFactory.createTitledBorder("Image"));
            sidebarPanel.add(imagePanel, BorderLayout.SOUTH);
        }

        sidebarPanel.add(Box.createVerticalGlue());
        contentPanel.add(sidebarPanel);

        // Wrap the content panel in a JScrollPane with both horizontal and vertical scrolling
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, chartPanel, sidebarPanel);
        splitPane.setDividerLocation(600); // You can adjust this for the initial position of the divider
        splitPane.setResizeWeight(0.5); // This allows both sides to resize proportionally

        contentPanel.add(splitPane, BorderLayout.CENTER); // Add the split pane to the center of the content panel

        // Wrap the content panel in a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        reportPanel.add(scrollPane, BorderLayout.CENTER);

        reportFrame.add(reportPanel);
        reportFrame.setLocationRelativeTo(null);
        reportFrame.setVisible(true);
    }

    /**
     * Creates and returns a styled 'Back' button.
     *
     * @return A JButton configured as a 'Back' button.
     */
    private JButton createBackButton() {
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(63, 81, 181));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);

        return backButton;
    }

    /**
     * Invoked when the 'Generate Report' button is clicked.
     * Validates the selected options and triggers report generation.
     */
    @Override
    public void onGenerateReportClicked() {
        int selectedChartsCount = 0;
        if (lc.isLineChartSelected()) selectedChartsCount++;
        if (lc.isBarChartSelected()) selectedChartsCount++;
        if (lc.isPieChartSelected()) selectedChartsCount++;

        // Check if exactly one chart is selected
        if (selectedChartsCount != 1) {
            JOptionPane.showMessageDialog(null, "Please select exactly one chart type.");
            return; // Do not proceed further
        }

        // Now check for the selected chart type
        boolean dataSourceSelected = false;
        Boolean displayLegends = null;
        Boolean displayAxisValues = null;

        if (lc.isLineChartSelected()) {
            dataSourceSelected = lc.isLineCSVSelected() || lc.isLineDBSelected();
            displayLegends = lc.isLineLegendsSelected();
            displayAxisValues = lc.isLineAxisValuesSelected();
        } else if (lc.isBarChartSelected()) {
            dataSourceSelected = lc.isBarCSVSelected() || lc.isBarDBSelected();
            displayLegends = lc.isBarLegendsSelected();
            displayAxisValues = lc.isBarAxisValuesSelected();
        } else if (lc.isPieChartSelected()) {
            dataSourceSelected = lc.isPieCSVSelected() || lc.isPieDBSelected();
            displayLegends = lc.isPieLegendsSelected();
        }

        // Check if a data source is selected for the chosen chart type
        if (!dataSourceSelected) {
            JOptionPane.showMessageDialog(null, "Please select a data source for the chosen Chart.");
            return;
        }

        // Check if display legends is selected for the chosen chart type
        if (displayLegends == null) {
            JOptionPane.showMessageDialog(null, "Please select if you want to display legends for the chosen Chart.");
            return;
        }

        // Check if display axis values is selected for the chosen chart type
        if ((lc.isLineChartSelected() || lc.isBarChartSelected()) && displayAxisValues == null) {
            JOptionPane.showMessageDialog(null, "Please select if you want to display axis values for the chosen Chart.");
            return;
        }

        // If all checks pass, proceed to generate the report
        generateReport();
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Canvas canvas = new Canvas();
            canvas.welcomePage();
//            canvas.selectComponents();
//            canvas.generateReport();
        });
    }
}
