package UI;
import BL.Components.Charts.Bar;
import BL.Components.Charts.Chart;
import BL.Components.Component;
import BL.Components.Image;
import BL.Components.Table;
import BL.DataSources.CSV;

import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class canvas extends JFrame{
	public canvas() {
		setTitle("Report Builder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 700);

		// Create an instance of the Image component
		Component image = new Image("FASTLOGO.png", new CSV("chartData.txt"));
		image.display();
		JComponent imagePanel = image.getPanel();
		add(imagePanel, BorderLayout.NORTH);

		// Create an instance of the Table component
		Component table = new Table(new CSV("chartData.txt"));
		table.setData();
		table.display();
		add(table.getPanel(), BorderLayout.EAST);

		// Create an instance of the Bar chart
		Chart barChart = new Bar();
		JPanel chartPanel = new JPanel(new BorderLayout());
		chartPanel.add(barChart, BorderLayout.CENTER);
		chartPanel.setPreferredSize(new Dimension(500, 400));
		add(chartPanel, BorderLayout.WEST);


		JButton exportButton = new JButton("Export as PNG");
		exportButton.addActionListener(e -> exportAsPNG());
		add(exportButton, BorderLayout.SOUTH);

//		JButton exportButton1 = new JButton("Export as PDF");
//		exportButton1.addActionListener(e -> exportAsPDF());
//		add(exportButton1, BorderLayout.SOUTH);

		setVisible(true);

	}

	private void exportAsPNG() {
		try {
			// Get the content pane bounds
			Rectangle contentPaneBounds = getContentPane().getBounds();

			// Create a robot
			Robot robot = new Robot();

			// Capture the content pane only
			BufferedImage screenshot = robot.createScreenCapture(
					new Rectangle(getLocationOnScreen().x + contentPaneBounds.x,
							getLocationOnScreen().y + contentPaneBounds.y,
							contentPaneBounds.width, contentPaneBounds.height)
			);

			// Show a file chooser for saving the PNG
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Save As");
			fileChooser.setFileFilter(new FileNameExtensionFilter("PNG files", "png"));

			int userSelection = fileChooser.showSaveDialog(this);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
				if (!fileToSave.getName().toLowerCase().endsWith(".png")) {
					fileToSave = new File(fileToSave.getAbsolutePath() + ".png");
				}
				ImageIO.write(screenshot, "png", fileToSave);
				JOptionPane.showMessageDialog(this, "Export successful!");
			}
		} catch (AWTException | IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Export failed!");
		}
	}

//	private void exportAsPDF() {
//		try {
//			// Create a temporary file for storing the screenshot
//			File tempFile = File.createTempFile("screenshot", ".png");
//
//			// Get the content pane bounds
//			Rectangle contentPaneBounds = getContentPane().getBounds();
//
//			// Create a robot
//			Robot robot = new Robot();
//
//			// Capture the content pane only
//			BufferedImage screenshot = robot.createScreenCapture(
//					new Rectangle(getLocationOnScreen().x + contentPaneBounds.x,
//							getLocationOnScreen().y + contentPaneBounds.y,
//							contentPaneBounds.width, contentPaneBounds.height)
//			);
//
//			// Save the screenshot to the temporary file
//			ImageIO.write(screenshot, "png", tempFile);
//
//			// Show a file chooser for saving the PDF
//			JFileChooser fileChooser = new JFileChooser();
//			fileChooser.setDialogTitle("Save As");
//			fileChooser.setFileFilter(new FileNameExtensionFilter("PDF files", "pdf"));
//
//			int userSelection = fileChooser.showSaveDialog(this);
//			if (userSelection == JFileChooser.APPROVE_OPTION) {
//				File fileToSave = fileChooser.getSelectedFile();
//				if (!fileToSave.getName().toLowerCase().endsWith(".pdf")) {
//					fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
//				}
//
//				// Create a Document
//				Document document = new Document();
//				PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
//
//				// Open the document for writing
//				document.open();
//
//				// Add the screenshot to the PDF
//				com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(tempFile.getAbsolutePath());
//				document.add(image);
//
//				// Close the document
//				document.close();
//
//				JOptionPane.showMessageDialog(this, "Export successful!");
//			}
//
//			// Delete the temporary file
//			tempFile.delete();
//
//		} catch (AWTException | IOException | DocumentException ex) {
//			ex.printStackTrace();
//			JOptionPane.showMessageDialog(this, "Export failed!");
//		}
//	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			canvas frame = new canvas();
		});
	}
}
