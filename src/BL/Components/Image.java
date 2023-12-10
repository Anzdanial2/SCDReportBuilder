package BL.Components;

import DataLayer.DataSource;

import java.awt.*;
import javax.swing.*;


/**
 * Represents a graphical component for displaying an image.
 * Extends the abstract Component class, specifically for handling image display.
 */
public class Image extends Component{
	private String imagePath;
	private JPanel imagePanel;

	/**
	 * Constructor for the Image class.
	 * Initializes an image component with a given image path.
	 *
	 * @param imagePath The path to the image file to be displayed.
	 */
	public Image(String imagePath){
		super(null);
		imagePanel = new JPanel(new BorderLayout());
		this.imagePath = imagePath;
	}

	/**
	 * Loads and displays the image from the specified path.
	 * The image is scaled to a default size.
	 */
	public void display() {
		ImageIcon fastLogo = new ImageIcon(imagePath);
		JLabel logoLabel = new JLabel();
		logoLabel.setIcon(fastLogo);

		java.awt.Image originalImage = fastLogo.getImage();
		java.awt.Image scaledImage = originalImage.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
		logoLabel.setIcon(new ImageIcon(scaledImage));

		imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		imagePanel.add(logoLabel);
	}

	/**
	 * Returns the JPanel that contains the displayed image.
	 *
	 * @return The JPanel containing the image.
	 */
	public JComponent getPanel(){
		return imagePanel;
	}
}
