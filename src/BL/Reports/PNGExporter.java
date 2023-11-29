package BL.Reports;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class PNGExporter implements Exporter{
	private JFrame mainFrame;
	public PNGExporter(JFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	@Override
	public void export() {
		try {
			// Get the content pane bounds
			Rectangle contentPaneBounds = mainFrame.getContentPane().getBounds();

			// Create a robot
			Robot robot = new Robot();

			// Capture the content pane only
			BufferedImage screenshot = robot.createScreenCapture(
					new Rectangle(mainFrame.getLocationOnScreen().x + contentPaneBounds.x,
							mainFrame.getLocationOnScreen().y + contentPaneBounds.y,
							contentPaneBounds.width, contentPaneBounds.height)
			);

			// Show a file chooser for saving the PNG
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Save As");
			fileChooser.setFileFilter(new FileNameExtensionFilter("PNG files", "png"));

			int userSelection = fileChooser.showSaveDialog(mainFrame);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
				if (!fileToSave.getName().toLowerCase().endsWith(".png")) {
					fileToSave = new File(fileToSave.getAbsolutePath() + ".png");
				}
				ImageIO.write(screenshot, "png", fileToSave);
				JOptionPane.showMessageDialog(mainFrame, "Export successful!");
			}
		} catch (AWTException | IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(mainFrame, "Export failed!");
		}
	}
}
