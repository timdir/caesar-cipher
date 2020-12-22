package core;

import java.awt.Container;
import javax.swing.JFrame;

public class Run {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Caesar Cipher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frame.getContentPane();
		GUI gui = new GUI();
		gui.addComponentToPane(c);

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
