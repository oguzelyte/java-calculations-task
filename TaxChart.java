public class TaxChart {
	private int[] income;

	public TaxChart(int[] inc) { // creation of constructor
		income = inc;
	}

	public void draw() {
		int b = 0;
		int WIDTH = 3;
		int maxY = 0; // will be used for y axis height
		int maxX = ((income.length * WIDTH) + (income.length * 10))
				- 20; /* width of x axis */
		int SHRINK = 3; /*
						 * divide bars by SHRINK to reduce the overall size of
						 * the chart
						 */
		for (int i = 0; i < income.length; i++) {
			Bar taxBar = new Bar(); // each time create a tax bar
			taxBar.changeSize(WIDTH, TaxCalculator.payableTax(income[i]) / SHRINK);
			taxBar.changeColour(Colour.RED);
			taxBar.moveHorizontal(b); /* don't let bars pile up on each other */
			taxBar.moveVertical(-TaxCalculator.payableTax(income[i])
					/ SHRINK); /* invert the bar so negative value */
			taxBar.moveVertical(200 - TaxCalculator.incomeLeft(income[i])
					/ SHRINK); /* move it to lay on the net income bar */
			Bar taxReducedBar = new Bar(); // each time create a new net income
											// bar
			taxReducedBar.changeSize(WIDTH, TaxCalculator.incomeLeft(income[i]) / SHRINK);
			taxReducedBar.changeColour(Colour.YELLOW);
			taxReducedBar.moveVertical(200 - TaxCalculator.incomeLeft(income[i])
					/ SHRINK); /* invert the net income bar */
			taxReducedBar.moveHorizontal(b);
			taxBar.makeVisible();
			taxReducedBar.makeVisible();
			b += 10; // move each bar farther away
			if ((TaxCalculator.payableTax(income[i])
					/ SHRINK) /* find out the height of y axis */
					+ (TaxCalculator.incomeLeft(income[i]) / SHRINK) > maxY) {
				maxY = ((TaxCalculator.payableTax(income[i]) / SHRINK)
						+ (TaxCalculator.incomeLeft(income[i]) / SHRINK));
			}
		}
		Bar axisY = new Bar();
		axisY.changeSize(1, maxY
				+ 10); /* height is made bigger so it can cross with x axis */
		axisY.moveVertical(200 - maxY);
		axisY.moveHorizontal(
				-10); /* move to the left so y axis doesn't touch the bars */
		axisY.changeColour(Colour.BLACK);
		axisY.makeVisible();

		Bar axisX = new Bar();
		axisX.changeSize(maxX, 1);
		axisX.moveVertical(200);
		axisX.moveHorizontal(-20);
		axisX.changeColour(Colour.BLACK);
		axisX.makeVisible();
	}

	public void printTable() {
		System.out.print("|  INCOME  |TAX TO PAY| NET INC. |\n");
		for (int i = 0; i < income.length; i++) {
			int temp = TaxCalculator.payableTax(income[i]);
			System.out.format("|%-10d|%-10d|%-10d|\n", income[i], temp, TaxCalculator.incomeLeft(income[i]));
		}

	}
}