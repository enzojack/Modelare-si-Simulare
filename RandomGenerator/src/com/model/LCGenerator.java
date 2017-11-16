package com.model;
public class LCGenerator implements IGenerator {

	private int seed;
	private int constantMultiplier;
	private int increment;
	private int module;
	private NumbersGenerated generatedNumbers;
	private int contor;

	public LCGenerator(int otherSeed, int constantMultiplier, int increment, int module) {
		super();
		this.constantMultiplier = constantMultiplier;
		this.increment = increment;
		this.module = module;
		this.generatedNumbers = new NumbersGenerated();
		this.seed = otherSeed;
		this.contor = 0;
	}

	@Override
	public double next() {
		double result = applyLCG();
		while (generatedNumbers.verifyIfNumberExist(result)) {
			if(contor == 1000) {
				contor = 0;
			}
			contor++;
			result = result + contor/Math.pow(10, 4);
		}
		result = (Math.round(result * Math.pow(10, 4 )))/Math.pow(10,4);
		generatedNumbers.addResult(result);
		return result;
	}

	private double applyLCG() {
		seed = (constantMultiplier * seed + increment) % module;
		return (double) (Math.round((double) seed / module * 10000)) / 10000;

	}

	

}
