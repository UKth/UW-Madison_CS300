///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: Seungwook Seo
// Campus ID: 9084030874
// WiscEmail: sseo36@wisc.edu
////////////////////////////////////////////////////////////////////////////////

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HolidayShippingIterator implements Iterator<Double> {
	private Double[] weights;
	private int index = 0;

	public HolidayShippingIterator(Double[] weights) {
		this.weights = weights;
	}

	@Override
	public boolean hasNext() {
		return index < weights.length;
	}

	@Override
	public Double next() {
		if (index >= weights.length) {
			throw new NoSuchElementException("Index out of bound");
		}
		Double weight = weights[index];
		index++;
		return weight + 0.1;
	}

	static boolean testHolidayShippingIterator() {
		Double epsilon = 0.000001d;
		Double[] weights = { 5.6, 2.3, 4.1, 3.6 };
		Double[] expectedWeights = { 5.7, 2.4, 4.2, 3.7 };
		Double sumWeight = 0.0;
		Double expectedSumWeight = 16.0;

		int iteratedIndex = 0;

		HolidayShippingIterator iterator = new HolidayShippingIterator(weights);

		while (iterator.hasNext()) {
			if (iteratedIndex >= expectedWeights.length) {
				return false;
			}
			Double iteratedItem = iterator.next();
			if (Math.abs(iteratedItem - expectedWeights[iteratedIndex]) > epsilon) {
				return false;
			}
			sumWeight += iteratedItem;
			iteratedIndex++;
		}

		if (Math.abs(sumWeight - expectedSumWeight) > epsilon) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println("testHolidayShippingIterator: " + testHolidayShippingIterator());
	}
}
