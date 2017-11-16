package com.model;

import java.util.ArrayList;
import java.util.List;

public class BinomialDistribution implements IGenerator {

	private IGenerator theGenerator;
	private int numberOfSimulations;
	private double upperLimit;
	
	public BinomialDistribution(IGenerator theGenerator, int number, double limit) {
		super();
		this.theGenerator = theGenerator;
		numberOfSimulations = number;
		upperLimit = limit;
		
	}

	@Override
	public double next() {
		int counter = 0;
		double simulationResult = 0;
		for(int i =0;i<numberOfSimulations;i++) {
			simulationResult = theGenerator.next();
			if(simulationResult < upperLimit ) {
				counter++;
				
			}
		}
		return (float)counter/numberOfSimulations;
	}

	

}
