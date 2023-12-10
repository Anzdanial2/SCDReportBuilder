package BL.Components;

import DataLayer.DataSource;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

/**
 * Represents a text component for displaying styled text.
 * Extends the abstract Component class, specifically for handling text display.
 */
public class Text extends Component{
	private JPanel textPanel;
	private String textInput;
	/**
	 * Constructor for the Text class.
	 * Initializes a text component with a specified text input.
	 *
	 * @param textInput The text to be displayed in the component.
	 */
	public Text(String textInput){
		super(null);
		textPanel = new JPanel();
		this.textInput = textInput;
	}

	/**
	 * Displays the text with specified styling in a JTextPane.
	 */
	@Override
	public void display() {
		JTextPane sample2 = new JTextPane();
		sample2.setText(textInput);
		sample2.setFont(new Font("Arial", Font.BOLD, 14));

		// Center-align the text
		StyledDocument doc = sample2.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		textPanel.setLayout(new BorderLayout());
		textPanel.add(new JScrollPane(sample2), BorderLayout.CENTER);
	}

	/**
	 * Returns the JPanel that contains the displayed text.
	 *
	 * @return The JPanel containing the text.
	 */
	public JComponent getPanel(){
		return textPanel;
	}
}
