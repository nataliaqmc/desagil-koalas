package br.edu.insper.desagil.data;

import java.util.List;
import java.util.Map;

public class Sum extends DataFrame {
	private Map<String, List<Double>> columns;
	
	public Sum(Map<String, List<Double>> columns) {
		super();
		this.columns = columns;
	}

	public double sum(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}

		double s = 0;
		for (double value: values) {
			s += value;
		}
		return s;
	}
}
