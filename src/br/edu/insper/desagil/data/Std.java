package br.edu.insper.desagil.data;

import java.util.List;
import java.util.Map;

public class Std extends DataFrame{
private Map<String, List<Double>> columns;
	
	public Std(Map<String, List<Double>> columns) {
		super();
		this.columns = columns;
	}
	public double std(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}

		double s, m;

		s = 0;
		for (double value: values) {
			s += value;
		}
		m = s / values.size();

		s = 0;
		for (double value: values) {
			s += Math.pow(value - m, 2);
		}
		m = s / values.size();

		return Math.sqrt(m);
	}

}
