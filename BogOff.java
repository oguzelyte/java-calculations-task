
/**
 * This is my first project using for module CSC1021 using Java.
 * 
 * @author: b6042185 (Olivija Guzelyte)
 * @version: 09/11/2016
 * @purpose: to understand the basic commands, functions of Java and Eclipse IDE
 */
import java.util.Scanner;

public class BogOff {

	public static int[] income = new int[] { 25, 50, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400,
			425, 450, 500, 550 };

	public static void main(String[] args) {
		/*System.out.println("Insert child's income: ");
		Scanner userInput = new Scanner(System.in);
		int inc = userInput.nextInt();
		int result = TaxCalculator.payableTax(inc);
		System.out.println("Payable tax: £" + (int) result);
		int incLeft = TaxCalculator.incomeLeft(inc);
		System.out.println("Income left: £" + (int) incLeft);
		userInput.close();*/
		
		/* The aforementioned code is made to test if the calculations done by TaxCalculator work.
		 * I commented it so only the bar chart and the corresponding table would be shown.
		 * But it can be uncommented and an arbitrary income can be inserted to test TaxCalculator's correctness. */

		TaxChart taxChartObject = new TaxChart(income);
		taxChartObject.printTable();
		BogOff bogOffObject = new BogOff();
		bogOffObject.taxTables();
		

	}

	public void taxTables() {
		TaxChart taxChartObject = new TaxChart(income);
		taxChartObject.draw();
	}

}
