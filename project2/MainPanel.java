package project2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;

public class MainPanel extends JPanel{
	
	public MainPanel() {
		setBackground(Color.RED);
		setPreferredSize(new Dimension(468, 363));
		setLayout(null);
		
		JLabel titleLabel = new JLabel("Netflix");
		titleLabel.setBounds(52, 28, 60, 37);
		titleLabel.setBackground(new Color(255, 255, 255));
		add(titleLabel);
		
		JButton buttonPusher = new JButton("New button");
		buttonPusher.setBounds(185, 36, 98, 31);
		add(buttonPusher);
	}
	
}

