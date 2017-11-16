package com.model;

public class MiddleSquare implements IGenerator {

	private int seed;
	private NumbersGenerated generatedNumbers;
	private int numberOfDigits;
	private int contor;

	public MiddleSquare(int otherSeed) {
		this.generatedNumbers = new NumbersGenerated();
		this.seed = otherSeed;
		this.numberOfDigits = numberOfDigits();
		this.contor = 0;
	}

	@Override
	public double next() {
		double result = applyMidSquare();
		while (generatedNumbers.verifyIfNumberExist(result)) {
			if (contor == Math.pow(10, numberOfDigits)) {
				contor = 0;
			}
			contor++;
			result = result + contor / Math.pow(10, numberOfDigits + 1);
		}
		result = (Math.round(result * Math.pow(10, numberOfDigits))) / Math.pow(10, numberOfDigits);
		generatedNumbers.addResult(result);
		return result;
	}

	private void recalculateSeed(int otherResult) {
		seed = Math
				.abs((int) ((otherResult / Math.pow(10, (int) numberOfDigits / 2)) % (Math.pow(10, numberOfDigits))));
		while (hasLessDigits()) {

			seed += (5 * Math.pow(10, numberOfDigits - 1));
		}
		while (hasMoreDigits()) {
			seed /= 10;
		}
		if (seed % 100 == 0) {
			seed += 1;
		}

	}

	private boolean hasLessDigits() {
		int limit = (int) (Math.pow(10, numberOfDigits - 1) - 1);
		if (seed <= limit) {
			return true;
		}
		return false;
	}

	private boolean hasMoreDigits() {
		int limit = (int) (Math.pow(10, numberOfDigits));
		if (seed >= limit) {
			return true;
		}
		return false;
	}

	private int numberOfDigits() {
		int otherSeed = seed;
		int digits = 0;
		while (otherSeed != 0) {
			digits++;
			otherSeed /= 10;
		}
		return digits;
	}

	private double applyMidSquare() {
		recalculateSeed(seed * seed);
		return (double) seed / Math.pow(10, numberOfDigits);

	}

	

}
