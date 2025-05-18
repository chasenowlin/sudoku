package main;

import java.util.ArrayList;
import java.util.List;

public class AnswerKey {
	
	public static void Generate() {
		List<Integer> rowOne = new ArrayList<>();
		List<Integer> rowTwo = new ArrayList<>();
		List<Integer> rowThree = new ArrayList<>();
		List<Integer> rowFour = new ArrayList<>();
		List<Integer> rowFive = new ArrayList<>();
		List<Integer> rowSix = new ArrayList<>();
		List<Integer> rowSeven = new ArrayList<>();
		List<Integer> rowEight = new ArrayList<>();
		List<Integer> rowNine = new ArrayList<>();
	
		List<Integer> colOne = new ArrayList<>();
		List<Integer> colTwo = new ArrayList<>();
		List<Integer> colThree = new ArrayList<>();
		List<Integer> colFour = new ArrayList<>();
		List<Integer> colFive = new ArrayList<>();
		List<Integer> colSix = new ArrayList<>();
		List<Integer> colSeven = new ArrayList<>();
		List<Integer> colEight = new ArrayList<>();
		List<Integer> colNine = new ArrayList<>();
	
		int i;
		int j;
	
		for (i = 0; i < 9; i++) {
			List<Integer> exclusionList = new ArrayList<>();
			for (j = 0; j < 9; j++) {
	
				List<Integer> specifiedRow = new ArrayList<>();
				List<Integer> specifiedCol = new ArrayList<>();
	
				if (i == 0 || i == 3 || i == 6) {
					if (j == 0 || j == 3 || j == 6) {
						specifiedRow = rowOne;
					} else if (j == 1 || j == 4 || j == 7) {
						specifiedRow = rowTwo;
					} else {
						specifiedRow = rowThree;
					}
				} else if (i == 1 || i == 4 || i == 7) {
					if (j == 0 || j == 3 || j == 6) {
						specifiedRow = rowFour;
					} else if (j == 1 || j == 4 || j == 7) {
						specifiedRow = rowFive;
					} else {
						specifiedRow = rowSix;
					}
				} else {
					if (j == 0 || j == 3 || j == 6) {
						specifiedRow = rowSeven;
					} else if (j == 1 || j == 4 || j == 7) {
						specifiedRow = rowEight;
					} else {
						specifiedRow = rowNine;
					}
				}
	
				if (i == 0 || i == 1 || i == 2) {
					if (j == 0 || j == 1 || j == 2) {
						specifiedCol = colOne;
					} else if (j == 3 || j == 4 || j == 5) {
						specifiedCol = colTwo;
					} else {
						specifiedCol = colThree;
					}
				} else if (i == 3 || i == 4 || i == 5) {
					if (j == 0 || j == 1 || j == 2) {
						specifiedCol = colFour;
					} else if (j == 3 || j == 4 || j == 5) {
						specifiedCol = colFive;
					} else {
						specifiedCol = colSix;
					}
				} else {
					if (j == 0 || j == 1 || j == 2) {
						specifiedCol = colSeven;
					} else if (j == 3 || j == 4 || j == 5) {
						specifiedCol = colEight;
					} else {
						specifiedCol = colNine;
					}
				}
	
				int number = (int) (Math.ceil(Math.random() * 9.0));
				int count = 0;
				while ((exclusionList.contains(number) || specifiedRow.contains(number)
						|| specifiedCol.contains(number)) && count < 100) {
					number = (int) (Math.ceil(Math.random() * 9.0));
					count++;
				}
				if (count >= 100) {
					Launcher.remake = true;
					return;
				}
				specifiedCol.add(number);
				specifiedRow.add(number);
				exclusionList.add(number);
	
				List<Integer> individualBoxCoord = new ArrayList<>();
				individualBoxCoord.add(i);
				individualBoxCoord.add(j);
				Launcher.sudokuAnswers.put((ArrayList<Integer>) individualBoxCoord, number);
			}
		}
		Launcher.remake = false;
	}
}
