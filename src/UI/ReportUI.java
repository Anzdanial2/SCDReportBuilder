package UI;

import javax.swing.*;
import java.awt.*;

public class ReportUI {
    JFrame reportFrame;
    JButton backBtn;
    JComboBox<String> exportResultsDropDown;
    JPanel panel1;
    JPanel reportPanel;
    public ReportUI(){
        reportFrame = new JFrame("Report Builder");
        reportFrame.setSize(1100,850);
        backBtn = new JButton("<-");
        String[] exportOptions = {"Select Type","Pdf","png"};
        exportResultsDropDown = new JComboBox<>(exportOptions);
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(backBtn);
        reportPanel = new JPanel();
        reportPanel.setLayout(new BoxLayout(reportPanel,BoxLayout.Y_AXIS));
        reportPanel.add(panel1);  //Contains back button
        reportPanel.add(exportResultsDropDown);
        reportFrame.add(reportPanel);
        reportFrame.setVisible(false);
        //Now on runtime canvas panel should be added, ok Anas
        //if you want to add export results drop down in canvas you can do so...
    }
    public void showFrame(){
        reportFrame.setVisible(true);
    }
}
