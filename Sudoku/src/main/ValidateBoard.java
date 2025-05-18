package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ValidateBoard {
	
	public static void checkAnswers() {

		boolean solved = true;
		boolean detectedFreeSpace = false;
		Launcher.puzzleComplete = true;

		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {
				List<Integer> individualEntryCoord = new ArrayList<>();
				individualEntryCoord.add(i);
				individualEntryCoord.add(j);

				int fixedResponse = 0;
				String givenResponse = "";
				int correctAnswer = Launcher.sudokuAnswers.get(individualEntryCoord);
				try {
					givenResponse = (Launcher.entryBoxes.get(individualEntryCoord)).getText();
				} catch (Exception e) {
					detectedFreeSpace = true;
				}

				if (detectedFreeSpace) {
					detectedFreeSpace = false;
				} else {
					(Launcher.entryBoxes.get(individualEntryCoord)).setBackground(Color.WHITE);
					try {
						fixedResponse = Integer.parseInt(givenResponse);
					} catch (Exception e) {
						solved = false;
					}

					if (!solved || (correctAnswer != fixedResponse)) {
						Launcher.puzzleComplete = false;
						solved = true;
						(Launcher.entryBoxes.get(individualEntryCoord)).setBackground(Color.PINK);
					}
				}
			}
		}

		if (Launcher.puzzleComplete) {
			Launcher.solvedLabel.setText("Solved!");
			Launcher.correctnessColorPanel.setBackground(Color.GREEN);
			Launcher.timerPanel.setBackground(Color.LIGHT_GRAY);
			Launcher.timer.stop();
			Launcher.checkButton.setText("New Puzzle");
		} else {
			Launcher.solvedLabel.setText("Incorrect!");
			Launcher.correctnessColorPanel.setBackground(Color.ORANGE);
		}
	}
}
