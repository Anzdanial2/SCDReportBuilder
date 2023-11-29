package BL.Components;

import DataLayer.DataSource;

import javax.swing.*;
import java.awt.*;


//Modify later
public class Text extends Component{
	private JPanel textPanel;
	private String textInput;
	public Text(String textInput, DataSource dataSource){
		super(dataSource);
		textPanel = new JPanel();
		this.textInput = textInput;
	}
	@Override
	public void display() {
		JTextArea sample2 = new JTextArea();
		sample2.setText(textInput);
		sample2.setFont(new Font("Arial", Font.BOLD, 14));
		textPanel.add(sample2);
	}
	public JComponent getPanel(){
		return textPanel;
	}
}
