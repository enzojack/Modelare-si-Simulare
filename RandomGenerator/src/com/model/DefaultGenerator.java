package com.model;

import java.util.Random;

public class DefaultGenerator implements IGenerator {
	private Random rand;
	private NumbersGenerated generatedNumbers;
	private int seed;

	public DefaultGenerator(int otherSeed) {
		super();
		this.rand = new Random();
		this.generatedNumbers = new NumbersGenerated();
		this.seed = otherSeed;
		rand.setSeed(seed);
	}

	@Override
	public double next() {
		double result = (double) Math.round(rand.nextDouble() * 10000) / 10000;
		generatedNumbers.addResult(result);
		return result;
	}

	

	
}
