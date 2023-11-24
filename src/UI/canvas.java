package UI;

import javax.swing.*;
import java.awt.*;

public class canvas extends JFrame{
	public canvas() {
		setTitle("Image Display");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon imageIcon = new ImageIcon("FASTLOGO.png");
		JLabel label = new JLabel(imageIcon);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.add(label, BorderLayout.CENTER);
		panel1.setSize(200,100);
		panel2.add(new JButton("Save"), BorderLayout.CENTER);
		add(panel1);
		add(panel2);
		pack();
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			canvas frame = new canvas();
			frame.setVisible(true);
		});
	}
//	public canvas(){
//		setTitle("Report Builder");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		ImageIcon logo = new ImageIcon("FASTLOGO.png");
//		setLayout(new BorderLayout());
//
//	}
//
//	public static void main(String []args){
//	}
}
