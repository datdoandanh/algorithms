package com.mum.edu.integers;

public class Solution {

	/**
	 * Given a 32-bit signed integer, reverse digits of an integer.
	 * Input: 123
	 * Output:  321
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		int result = 0;
		while (Math.abs(x) > 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x = x / 10;
		}
		return result;
	}

	/**
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 * @param x
	 * @return 121
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		int reverse = 0;
		while (reverse < x) {
			int tail = x % 10;
			reverse = reverse * 10 + tail;
			x = x / 10;
		}
		if (x == reverse || x * 10 + reverse % 10 == reverse) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
//		System.out.println(reverse(1534236469));
//		System.out.println(964632435*10);
		
		System.out.println(isPalindrome(10));
	}

}
