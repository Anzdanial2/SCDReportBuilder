package BL.Components;

import BL.DataSources.DataSource;

import java.awt.*;
import javax.swing.*;

public class Image extends Component{
	private String imagePath;
	private JPanel imagePanel;
	public Image(String imagePath, DataSource dataSource){
		super(dataSource);
		imagePanel = new JPanel(new BorderLayout());
		this.imagePath = imagePath;
	}
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
	public JComponent getPanel(){
		return imagePanel;
	}
}
