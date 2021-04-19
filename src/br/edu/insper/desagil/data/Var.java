package br.edu.insper.desagil.data;

import java.util.List;
import java.util.Map;

public class Var extends DataFrame {
private Map<String, List<Double>> columns;
	
	public Var(Map<String, List<Double>> columns) {
		super();
		this.columns = columns;
	}
	public double var(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}

		double s;

		s = 0;
		for (double value: values) {
			s += value;
		}
		double m = s / values.size();

		s = 0;
		for (double value: values) {
			s += Math.pow(value - m, 2);
		}
		return s / values.size();
	}

}
