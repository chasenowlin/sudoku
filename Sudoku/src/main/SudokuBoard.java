package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SudokuBoard {
	
	public static void createBoard() {

		boolean freeSpace = false;

		for (int i = 0; i < 9; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(3, 3));
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			Launcher.frame.add(panel, null, i);

			for (int j = 0; j < 9; j++) {

				List<Integer> individualEntryCoord = new ArrayList<>();
				individualEntryCoord.add(i);
				individualEntryCoord.add(j);

				if ((Math.random() * 100) <= 50) {
					freeSpace = true;
				} else {
					freeSpace = false;
				}

				if (freeSpace) {
					String freeName = String.valueOf(Launcher.sudokuAnswers.get(individualEntryCoord));
					JLabel givenNumber = new JLabel(freeName);
					givenNumber.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
					givenNumber.setHorizontalAlignment(SwingConstants.CENTER);
					panel.add(givenNumber, null, j);
				} else {
					JTextField entryBox = new JTextField(1);
					entryBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
					entryBox.setHorizontalAlignment(SwingConstants.CENTER);
					panel.add(entryBox, null, j);

					Launcher.entryBoxes.put((ArrayList<Integer>) individualEntryCoord, entryBox);
				}
			}
		}
	}
}
