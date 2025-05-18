package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class Launcher implements ActionListener {

	public static JFrame frame;
	public static JLabel timerLabel;
	public static JPanel timerPanel;
	public static JLabel solvedLabel;
	public static JPanel correctnessColorPanel;
	public static JButton checkButton;
	public static Timer timer;
	public static int hours = 0;
	public static int minutes = 0;
	public static int seconds = 0;
	public static boolean remake = false;
	public static boolean puzzleComplete = false;
	public static HashMap<ArrayList<Integer>, Integer> sudokuAnswers = new HashMap<ArrayList<Integer>, Integer>();
	public static HashMap<ArrayList<Integer>, JTextField> entryBoxes = new HashMap<ArrayList<Integer>, JTextField>();

	public Launcher() {
		
		defaultValues();
		formatWindow();

		do {
			AnswerKey.Generate();
		} while (remake);

		SudokuBoard.createBoard();

		TimerSetup.TimerSet();

		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void defaultValues() {
		
		remake = false;
		puzzleComplete = false;
		sudokuAnswers.clear();
		entryBoxes.clear();
		hours = 0;
		minutes = 0;
		seconds = 0;
	}
	
	public void formatWindow() {
		
		frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(4, 3));
		
		Font customFont = new Font("Arial", Font.PLAIN, 24);
		
		timerPanel = new JPanel();
		timerPanel.setBackground(Color.WHITE);
		timerPanel.setLayout(new GridLayout(1, 1));
		
		timerLabel = new JLabel("00:00:00");
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timerLabel.setFont(customFont);
		timerPanel.add(timerLabel);

		checkButton = new JButton("Check");
		checkButton.setFont(customFont);
		checkButton.addActionListener(this);

		correctnessColorPanel = new JPanel();
		correctnessColorPanel.setBackground(Color.GRAY);
		correctnessColorPanel.setLayout(new GridLayout(1, 1));
		
		solvedLabel = new JLabel("Not Solved");
		solvedLabel.setFont(customFont);
		solvedLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		solvedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		solvedLabel.setVerticalAlignment(SwingConstants.CENTER);
		correctnessColorPanel.add(solvedLabel);

		frame.add(checkButton);
		frame.add(timerPanel);
		frame.add(correctnessColorPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!puzzleComplete) {
			ValidateBoard.checkAnswers();
		} else {
			frame.dispose();
			new Launcher();
		}
	}
	
	public static void main(String[] args) {
		new Launcher();
	}
}
