package jtm.extra03;

import java.util.ArrayList;


public class PracticalNumbers {

	// TODO Read article https://en.wikipedia.org/wiki/Practical_number
	// Implement method, which returns practical numbers in given range
	// including
	public String getPracticalNumbers(int from, int to) {
		ArrayList<Integer> practicalNumbers = new ArrayList<>();
		for (int i = from; i <= to; i++) {
			if(checkIfPractical(i)) {
				practicalNumbers.add(i);
			}
		}
		return practicalNumbers.toString();
	}

	public boolean checkIfPractical(int number) {
		ArrayList<Integer> divisors = new ArrayList<>();

		for(int j = 1; j < number; j++) {
			if(number % j == 0) {
				divisors.add(j);
			}
		}
		for(int i = number - 1; i > 0; i--) {
			int currentNumber = i;
			for (int j = divisors.size() - 1; j >= 0; j--) {
				if(currentNumber > 0) {
					currentNumber -= divisors.get(j);
				}
				if(currentNumber < 0) {
					currentNumber += divisors.get(j);
				}
				if(currentNumber == 0) {
					break;
				}
			}
			if(currentNumber != 0) {
				return false;
			}
		}
		return true;
	}
}