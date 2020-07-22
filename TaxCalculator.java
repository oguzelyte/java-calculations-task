public class TaxCalculator {
	public static int payableTax(int inc) {
		double payTax = 0;
		double[] TAX = { 0, 0.1, 0.2, 0.4, 0.6, 1.2 }; // an array of tax
														// constants
		double[] REDUCE = { 100, 50, 50, 100, 100, 0 }; // income range
														// differences
		for (int i = 0; i < TAX.length; i++) {
			if (inc > REDUCE[i]) // if income is bigger than reduction value, we
									// only multiply by the reduction value
				payTax += TAX[i] * REDUCE[i];
			else
				payTax += TAX[i] * inc; // do this if the reduction value is
										// bigger than remaining income, so we
										// don't multiply by more than needed
			inc -= REDUCE[i];
			if (i == TAX.length - 1) { // if loop reaches last cycle, cycle
										// needs to be broken and remaining
										// income used up
				payTax += TAX[i] * inc;
				break;
			}
			if (inc < 0) { // in case the income gets reduced to a negative
				// value
				break;
			}
		}
		payTax = Math.round(payTax);
		return (int) payTax;
	}

	public static int incomeLeft(int inc) {
		return (inc - payableTax(inc));
	}
}
