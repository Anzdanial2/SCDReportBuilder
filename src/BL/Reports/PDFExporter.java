package BL.Reports;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class PDFExporter implements Exporter{
	private JFrame mainFrame;
	public PDFExporter(JFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	@Override
	public void export() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save PDF File");
		fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files (*.pdf)", "pdf"));
		int userSelection = fileChooser.showSaveDialog(mainFrame);

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
					BufferedImage image = new BufferedImage(mainFrame.getWidth(), mainFrame.getHeight(), BufferedImage.TYPE_INT_RGB);
					mainFrame.paint(image.getGraphics());

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

				JOptionPane.showMessageDialog(mainFrame, "PDF exported successfully to:\n" + fileToSave.getAbsolutePath(),
						"Export Successful", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(mainFrame, "Error exporting PDF:\n" + e.getMessage(),
						"Export Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private byte[] imageToByteArray(BufferedImage image) throws IOException {
		File tempFile = File.createTempFile("tempImage", ".png");
		ImageIO.write(image, "png", tempFile);
		return Files.readAllBytes(tempFile.toPath());
	}
}
