package UI;

import BL.Components.Charts.Bar;
import BL.Components.Charts.Chart;
import BL.Components.Component;
import BL.Components.Image;
import BL.Components.Table;
import DataLayer.CSV;
import DataLayer.Database;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class canvas extends JFrame {
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
		Chart barChart = new Bar(new Database(Database.ChartType.BAR));
		JPanel chartPanel = new JPanel(new BorderLayout());
		chartPanel.add(barChart, BorderLayout.CENTER);
		chartPanel.setPreferredSize(new Dimension(500, 400));
		add(chartPanel, BorderLayout.WEST);

		JButton exportButton = new JButton("Export to PDF");
		exportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportToPDF();
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(exportButton);
		add(buttonPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	public void exportToPDF() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save PDF File");
		fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files (*.pdf)", "pdf"));
		int userSelection = fileChooser.showSaveDialog(this);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			if (!fileToSave.getName().toLowerCase().endsWith(".pdf")) {
				fileToSave = new File(fileToSave.getParentFile(), fileToSave.getName() + ".pdf");
			}

			try {
				PDDocument document = new PDDocument();
				PDPage page = new PDPage(PDRectangle.A4);
				page.setRotation(90); // Set page orientation to landscape
				document.addPage(page);

				try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
					BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
					paint(image.getGraphics());

					float scaleX = page.getMediaBox().getWidth() / (float) image.getWidth();
					float scaleY = page.getMediaBox().getHeight() / (float) image.getHeight();
					float scale = Math.min(scaleX, scaleY);

					float x = (page.getMediaBox().getWidth() - image.getWidth() * scale) / 2;
					float y = (page.getMediaBox().getHeight() - image.getHeight() * scale) / 2;

					PDImageXObject pdImage = LosslessFactory.createFromImage(document, image);
					contentStream.drawImage(pdImage, x, y, pdImage.getWidth() * scale, pdImage.getHeight() * scale);
				}

				document.save(fileToSave.getAbsolutePath());
				document.close();

				JOptionPane.showMessageDialog(this, "PDF exported successfully to:\n" + fileToSave.getAbsolutePath(),
						"Export Successful", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error exporting PDF:\n" + e.getMessage(),
						"Export Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private byte[] imageToByteArray(BufferedImage image) throws IOException {
		File tempFile = File.createTempFile("tempImage", ".png");
		ImageIO.write(image, "png", tempFile);
		return Files.readAllBytes(tempFile.toPath());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			canvas frame = new canvas();
		});
	}
}
