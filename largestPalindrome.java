/*
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * Taken from: http://projecteuler.net/index.php?section=problems&id=4
 * 
 * Solution: 913 * 993 = 906609
 */
public class largestPalindrome {
	public static void main (String[] args) {
		
		int largestPalindrome,number1, number2;
		largestPalindrome = number1 = number2 = 0;
		
		for (int i = 999; i > 99; i--) {
			for (int j = 999; j >= i; j--) {
				if (i*j <= largestPalindrome)
					break;
				if (isPalindrome(i*j)) {
					largestPalindrome = i*j;
					number1 = i;
					number2 = j;
				}
			}
		}
		
		System.out.println("Largest palindrome made from product of two 3-digit numbers (" + number1 + "*" + number2 +") is " + largestPalindrome);
	}
	
	private static long reverseNumber(long n) {
		long reversed = 0;
		
		while (n > 0) {
			reversed = reversed*10 + n%10;
			n /= 10;
		}
		return reversed;
	}
	
	private static boolean isPalindrome(long n) {
		if (n == reverseNumber(n))
			return true;
		return false;
	}
	
	/*
	 * for (int i = 999; i > 99; i--) {
	 * 		for (int j = 999; j >= i; j--) {
	 * 			int tmp = i*j;
	 * 			while (tmp > 0) {
	 * 				remainder = tmp %10;
	 * 				reverse = reverse * 10 + remainder;
	 * 				tmp = tmp/10;
	 * 			}
	 * 			if (reverse == i*j) {
	 * 				if (i*j > largestPalindrome) {
	 * 					largestPalindrome = i*j;
	 * 					number1 = i;
	 * 					number2 = j;
	 * 				}
	 * 			}
	 * 			reverse = 0;
	 *		}
	 * }
	 */
}