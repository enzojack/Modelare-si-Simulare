package com.model;

import java.util.ArrayList;
import java.util.List;

public class PoissonDistribution implements IGenerator {

	private IGenerator theGenerator;
	private int numberOfSimulations;
	private double lambda;
	private List<Double> generatedNumbers;

	public PoissonDistribution(IGenerator theGenerator, int numberOfSimulations, double lambda) {
		super();
		this.theGenerator = theGenerator;
		this.numberOfSimulations = numberOfSimulations;
		this.lambda = lambda;
	}

	@Override
	public double next() {
		int counter = 0;
		double p = 1, numberGenerated;
		generatedNumbers = new ArrayList<>();
		double L = 1/Math.pow(Math.E, lambda);
		do {
			counter++;
			numberGenerated = theGenerator.next();
			generatedNumbers.add(numberGenerated);
			p = p * numberGenerated;
		} while (p > L && (counter < numberOfSimulations));
		return (float)(counter - 1)/numberOfSimulations;
	}



}
