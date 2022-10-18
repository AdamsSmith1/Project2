package project2;
//Adams Smith
//CSCI 3381-MWF 0900-O-O SOFTWARE DEVELOPMENT JAVA


//Imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;

import project1.ShowWeek;
import project1.Shows;

import javax.swing.JComboBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Intro + Priv Variables
public class MainPanel extends JPanel{
	private JTextField MOTW;
	private JTextField rndmSuggest;
	private JTextField goldStatus;
	private Shows allData = new Shows("allData","/netflixAllWeeksGlobalProcessed.txt");
	private JTextField goalCounter;
	private JTextField fullMovieList;

	public MainPanel() {
		//Set Panel Color + Size
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(468, 363));
		setLayout(null);

		//Button The Exits The Program
		JButton btnExit = new JButton("Exit Window");
		btnExit.setFont(new Font("Stencil", Font.PLAIN, 9));
		btnExit.setBounds(342, 27, 116, 21);
		add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		//Netflix GIF
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainPanel.class.getResource("/project2/giphy.gif")));
		label.setBounds(-78, 27, 410, 104);
		add(label);

		//Label For MOTW
		JLabel lblMOTW = new JLabel("Search Previous Movies Of The Week! (Enter Week!)");
		lblMOTW.setFont(new Font("Stencil", Font.PLAIN, 9));
		lblMOTW.setBounds(10, 157, 280, 39);
		lblMOTW.setForeground(Color.white);
		add(lblMOTW);

		//Movie Of The Week
		MOTW = new JTextField();
		MOTW.setFont(new Font("Stencil", Font.PLAIN, 9));
		MOTW.setBounds(33, 194, 96, 19);
		add(MOTW);
		MOTW.setColumns(10);

		//Random Suggestion
		rndmSuggest = new JTextField();
		rndmSuggest.setFont(new Font("Stencil", Font.PLAIN, 9));
		rndmSuggest.setBounds(71, 256, 356, 19);
		add(rndmSuggest);
		rndmSuggest.setColumns(10);

		//Button For Watching A New Movie Counter
		JButton newMovieWatched = new JButton("New Movie Watched!");
		newMovieWatched.setFont(new Font("Stencil", Font.PLAIN, 9));
		newMovieWatched.setBounds(294, 314, 164, 21);
		add(newMovieWatched);

		//Progress to 100 Movies Watched
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(304, 342, 146, 11);
		add(progressBar);
		progressBar.setValue(0);
		newMovieWatched.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				progressBar.setValue(progressBar.getValue() + 1);	
				goalCounter.setText("Movie Goal Counter: " + progressBar.getValue() + " / 100.");
			}
		});

		//Gold Status Text Field
		goldStatus = new JTextField();
		goldStatus.setFont(new Font("Stencil", Font.PLAIN, 9));
		goldStatus.setText("Netflix Gold Status Progress (100 Movies Watched)");
		goldStatus.setBounds(10, 300, 274, 21);
		add(goldStatus);
		goldStatus.setColumns(10);

		//Combo Box
		//Credit To Dr. Doderer (Lecture Video)
		JComboBox <ShowWeek> comboBox = new JComboBox();
		comboBox.setFont(new Font("Stencil", Font.PLAIN, 9));
		ArrayList<ShowWeek> mIW = allData.getOneWeek(MOTW.getText());
		if ( mIW != null && mIW.size() > 0) {
			String [] data = new String[mIW.size()];
			int index = 0;
			for (ShowWeek showTheWeek : mIW) {
				data[index] = showTheWeek.getShowTitle();
				index++;
			}
		}
		comboBox.setBounds(300, 184, 127, 39);
		add(comboBox);

		//Box To Indicate User Would Like New Random Show
		JCheckBox randShowCheck = new JCheckBox("New Random Show");
		randShowCheck.setFont(new Font("Stencil", Font.PLAIN, 9));
		randShowCheck.setBounds(147, 229, 198, 21);
		add(randShowCheck);

		//Checks Button For Press and Gives Rand Show
		randShowCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rndmSuggest.setText(allData.randomShow().toString());;
			}
		});

		//Search Button
		JButton searchBTN = new JButton("Search");
		searchBTN.setFont(new Font("Stencil", Font.PLAIN, 9));
		searchBTN.setBounds(139, 193, 85, 21);
		add(searchBTN);

		//Tracking The Gold Status Goal
		goalCounter = new JTextField();
		goalCounter.setFont(new Font("Stencil", Font.PLAIN, 9));
		goalCounter.setText("Movie Goal Counter: 0 / 100.");
		goalCounter.setBounds(33, 334, 191, 19);
		add(goalCounter);
		goalCounter.setColumns(10);

		//Box To Store MIW
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setBounds(342, 97, 116, 34);
		add(textArea);

		//Text Box For "Hot Movies"
		fullMovieList = new JTextField();
		fullMovieList.setFont(new Font("Stencil", Font.PLAIN, 9));
		fullMovieList.setText("Hot Movies This Week:");
		fullMovieList.setBounds(342, 68, 126, 19);
		add(fullMovieList);
		fullMovieList.setColumns(10);



		searchBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ShowWeek> mIW = allData.getOneWeek(MOTW.getText());
				if ( mIW != null && mIW.size() > 0) {
					String [] data = new String[mIW.size()];
					int i = 0;
					for (ShowWeek showTheWeek : mIW) {
						data[i] = showTheWeek.getShowTitle();
						i++;
					}
					comboBox.setModel(new DefaultComboBoxModel(data));
				}
			}
		});

		//Slider For Hot Movies
		JSlider slider = new JSlider();
		slider.setMaximum(10);
		slider.setBounds(304, 141, 164, 22);
		//textArea.setText(allData.suggestShowTrend(allData));
		add(slider);

		//Credit To https://www.tutorialspoint.com/how-to-detect-the-value-change-of-a-jslider-in-java
		//For Help With Slider Values
		ArrayList<ShowWeek> moviesInWeek1 = allData.getOneWeek("2022-09-04");
		if ( moviesInWeek1 != null && moviesInWeek1.size() > 0) {
			String [] data = new String[moviesInWeek1.size()];
			int i = 0;
			for (ShowWeek sw : moviesInWeek1) {
				data[i] = sw.getShowTitle();
				i++;
			}
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent ce) {
					textArea.setText(data[slider.getValue()]);
				}
			});
		}


	}
}


