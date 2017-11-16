package com.model;

public class Evaluator {
	private IGenerator generator;
	private int numbersOfGenerations;

	public Evaluator(IGenerator generator, int simulations) {
		super();
		this.generator = generator;
		this.numbersOfGenerations = simulations;

	}

	public double evaluate() {
		int pointsInCircle = 0;
		double abscis = 0;
		double ordinate = 0;
		for (int i = 0; i < numbersOfGenerations; i++) {

			if (i % 2 == 0) {
				abscis = generator.next();
			} else if (i % 2 == 1) {
				ordinate = generator.next();
				double point = Math.sqrt(Math.pow(abscis, 2) + Math.pow(ordinate, 2));
				if (point <= 1) {
					pointsInCircle++;
				}
			}
		}
		int totalPoints = (int) (numbersOfGenerations / 2);
		System.out.println(pointsInCircle);
		System.out.println("total points" + totalPoints);
		return Math.abs(Math.PI - (double) 4 * pointsInCircle / totalPoints);
	}

}
