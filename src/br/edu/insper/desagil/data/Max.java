package br.edu.insper.desagil.data;

import java.util.List;
import java.util.Map;

public class Max extends DataFrame{
	private Map<String, List<Double>> columns;
	
	public Max(Map<String, List<Double>> columns) {
		super();
		this.columns = columns;
	}
	@Override
	public double contas (String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}

		double m = Double.NEGATIVE_INFINITY;
		for (double value: values) {
			if (m < value) {
				m = value;
			}
		}
		return m;
	}
}
