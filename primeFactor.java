
/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 600851475143
 *   8462696833
 *    716151937
 *    408464633
 *     87625999
 *     
 * 71, 839, 1471, 6857
 * 
 * Taken from: http://projecteuler.net/index.php?section=problems&id=3
 * 
 * Solution: 6857
 */

public class primeFactor {
	private static long num = 600851475143L; //975481294L;	
	private static long[] factor = new long[1000];
	private static int factorLength;
	private static long largestPrimeFactor;
	
	public static void main (String[] args) {
		
		long largestFactor = largestPrimeFactorFinder();
		
		System.out.print("Factors of " + num + " are : ");
		printFactor();
		System.out.print("Prime factors of " + num + " are : ");
		primeFinder();
		System.out.println("Largest factor of " + num + " is : " + largestFactor);
		System.out.println("Largest prime factor of " + num + " is : " + largestPrimeFactor);
	}
	
	private static void printFactor() {
		for (int i = 0; i < factorLength; i++) {
			System.out.print(factor[i] + " ");
		}
		System.out.println();
	}
	
	private static void primeFinder() {
		boolean flag = true;
		for (int i = 0; i < factorLength; i++) {
			long tmp = factor[i];
			flag = true;
			for (long j = 2; j < tmp; j++) {
				if (tmp % j == 0)
					flag = false;
			}
			if (flag == true) {
				System.out.print(tmp + " ");
				largestPrimeFactor = tmp;
			}
		}
		System.out.println();
	}
	
	private static long largestPrimeFactorFinder() {
		long factorTemp = 1;
		int k = 0;
		
		for (long i = 2; i <= num/factorTemp; i++) {
			if (num % i == 0) {
					factorTemp = i;
					factor[k++] = i;
				}
		}
		factorLength = k;
		return factorTemp;
	}
}