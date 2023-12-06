package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Canvas implements GenerateReportCallback{
    private JFrame welcomeFrame;
    private JFrame selectedFrame;

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

    private void selectComponents() {
        JFrame selectFrame = new JFrame("Report Builder");
        selectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectFrame.setSize(1200, 700);

        UpperCard uc = new UpperCard();
        LowerCard lc = new LowerCard(this);

        JScrollPane scrollPane = new JScrollPane();
        JPanel scrollPanel = new JPanel(new BorderLayout());
        scrollPanel.add(uc.getUpperPanel(), BorderLayout.NORTH);
        scrollPanel.add(lc.getLowerPanel(), BorderLayout.CENTER);

        scrollPane.setViewportView(scrollPanel);
        selectFrame.add(scrollPane);


        selectFrame.setLocationRelativeTo(null);
        selectFrame.setVisible(true);
        selectedFrame = selectFrame;
    }

    private void generateReport() {
        // Dispose of the previous window
        if (selectedFrame != null) {
            selectedFrame.dispose();
        }

        JFrame reportFrame = new JFrame("Generate Report");
        reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reportFrame.setSize(400, 300);

        JButton backButton = createBackButton();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectComponents(); // Open the previous window (selectComponents)
                reportFrame.dispose(); // Dispose of the current window (generateReport window)
            }
        });

        JPanel reportPanel = new JPanel(new BorderLayout());
        reportPanel.add(backButton, BorderLayout.NORTH); // Place the button at the top
        reportPanel.add(new JLabel("Report content goes here..."), BorderLayout.CENTER);

        reportFrame.add(reportPanel);

        reportFrame.setLocationRelativeTo(null);
        reportFrame.setVisible(true);
    }

    private JButton createBackButton() {
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(63, 81, 181));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);

        return backButton;
    }


    @Override
    public void onGenerateReportClicked() {
        generateReport();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Canvas canvas = new Canvas();
//            canvas.welcomePage();  // Call the welcome page method
//            canvas.selectComponents();
            canvas.generateReport();
        });
    }
}
