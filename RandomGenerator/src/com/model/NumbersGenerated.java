package com.model;

import java.util.ArrayList;
import java.util.List;

public class NumbersGenerated {
	private List<Double> generatedNumbers;

	public NumbersGenerated() {
		this.generatedNumbers = new ArrayList<>();
	}

	public boolean verifyIfNumberExist(double result) {
		for (Double number : generatedNumbers) {
			if (number == result) {
				return true;
			}
		}
		return false;
	}

	public void addResult(double result) {
		generatedNumbers.add(result);
		if (generatedNumbers.size() == 1000) {
			generatedNumbers.clear();

		}
	}
	


}
