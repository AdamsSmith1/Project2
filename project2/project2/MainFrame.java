package project2;

import javax.swing.JFrame;

import project1.Shows;

public class MainFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Push Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainPanel panel = new MainPanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
		

		Shows allData = new Shows("allData","./project1/netflixAllWeeksGlobalProcessed.txt");
		
	}
}

