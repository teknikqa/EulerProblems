/*
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * Find the sum of all the even-valued terms in the sequence which do not exceed four million.
 * 
 * Taken from: http://projecteuler.net/index.php?section=problems&id=2
 * 
 * Solution: 4613732
 */

public class FibonacciSum {
	public static void main(String[] args) {
		
		System.out.println("*** Fibonacci sum ***");
		
		long sum1 = fibonacciSum1();
		long sum2 = fibonacciSum2();
		
		System.out.println("Sum of all even fibonacci terms below 4 million (using fibbonacciSum1) = " + sum1);
		System.out.println("Sum of all even fibonacci terms below 4 million (using fibbonacciSum2) = " + sum2);
	}
	
	private static long fibonacciSum1() {
		long sum = 0, tmp;
		long fibCurr, fibPrev;
		
		fibCurr = fibPrev = 1;
		
		while (fibCurr < 4000000) {
			tmp = fibCurr + fibPrev;
			fibPrev = fibCurr;
			fibCurr = tmp;
			if (fibCurr % 2 == 0)
				sum += fibCurr;
		}
		
		return sum;
	}
	
	/*
	 * The Fibonacci series is:
	 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610...
	 * 
	 * Now, replacing an odd number with O and an even with E, we get:
	 * O, O, E, O, O, E, O, O, E, O, O, E, O, O, E...
	 * 
	 * And so each third number is even. We don't need to calculate the odd numbers.
	 * Starting from an two odd terms x, y, the series is:
	 * x, y, x + y, x + 2y, 2x + 3y, 3x + 5y
	 * 
	 * So finding every third even number by using
	 * x = x + 2y
	 * y = 2x + 3y
	 */
	
	private static long fibonacciSum2() {
		long sum = 0;
		long fibPrev, fibCurr, tmp;
		fibPrev = fibCurr = 1;
		
		while (fibCurr < 4000000) {
			sum += fibPrev + fibCurr;
			tmp = fibPrev + 2*fibCurr;
			fibCurr = 2*fibPrev + 3*fibCurr;
			fibPrev = tmp;
		}
		
		return sum;
	}

}
