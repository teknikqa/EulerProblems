/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, 
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * Taken from http://projecteuler.net/index.php?section=problems&id=1
 * 
 * Solution: 233168
 */


public class FindMultiple {
	public static void main(String[] args) {
		
		System.out.println("*** Multiple Finder ***");
		
		int sum1 = moduloSum();
		
		int sum2 = efficientSum(3) + efficientSum(5) - efficientSum(15);
		
		System.out.println("Sum of multiples of 3 & 5 below 1000 (using moduloSum) = " + sum1);
		System.out.println("Sum of multiples of 3 & 5 below 1000 (using efficientSum) = " + sum2);
	}
	
	/*
	 * A simple method that determines if a number is divisible by 3 or by 5
	 * and if so, adds it to the sum.
	 */
	
	private static int moduloSum() {
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			if (i%3 == 0 || i%5 == 0)
				sum+=i;
		}
		return sum;
	}
	
	/*
	 * An improvisation of the formulae for arithmetic progressions. 
	 * For example, to find the sum of the terms 3,6,9,12,..., you would use (n/2)(a+l), 
	 * where n is the number of terms, a is the first term, and l is the last term. 
	 * The nth term is given by a+(n-1)d, where d is the common difference. 
	 * 
	 * In general, a+(n-1)d=x, gives n=int((x-a)/d+1).
	 * But for this problem we can improve even further, as a=d we get 
	 * n=int(x/d-d/d+1)=int(x/d).
	 * 
	 * The nth (last) term, 
	 * l=a+(n-1)d=d+(int(x/d)-1)*d=d*int(x/d).
	 * 
	 * Combining this to find the sum, 
	 * S=(n/2)(a+l)=(int(x/d)/2)*(d+d*int(x/d)).
	 * 
	 * Simplifying, S=d*int(x/d)*(1+int(x/d))/2.
	 * 
	 * As the problem asks for the sum of multiples of 3 and 5 we find the sum of each series,
	 * but as 3,6,9,... and 5,10,15,... have multiples of 15 in common, 
	 * we need to subtract the series for 15,30,45,...
	 * However, caution is needed. 
	 * The problem states below then 1000, so we must use 999 in the formula
	 * (otherwise it would include 1000 in the sum, as a multiple of 5):
	 * 
	 * T = 3*int(999/3)*(1+int(999/3))/2 + 5*int(999/5)*(1+int(999/5))/2 - 15*int(999/15)*(1+int(999/15))/2
	 * Therefore, T = 3*333*(1+333)/2 + 5*199*(1+199)/2 - 15*66*(1+66)/2 = 233168.
	 */
	
	private static int efficientSum(int n) {
		int sum = n*(999/n)*(1+999/n)/2;
		return sum;
	}
}
