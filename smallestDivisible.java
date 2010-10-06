/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * Taken from: http://projecteuler.net/index.php?section=problems&id=5
 * 
 * Solution: 232792560
 */
public class smallestDivisible {
	public static void main (String[] args) {
		
		long smallestNumberDivisible;
		
		long product = 1;
		
		for (long i = 1; i <=20; i++) {
			product *= i;
		}
		
		smallestNumberDivisible = 1;
		
		int tmp = 1;
		
		for (long i = 1; i <= 20; i++) {
			tmp *= i;
			if (smallestNumberDivisible % tmp != 0) {
				smallestNumberDivisible *= i;
				System.out.println("i = " + i + " smallestNumberDivisible = " + smallestNumberDivisible);
			}
		}
		
		System.out.println("Smallest number divisible by all numbers from 1 to 20 is " + smallestNumberDivisible);
	}
}
