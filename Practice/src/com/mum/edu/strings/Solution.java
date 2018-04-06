package com.mum.edu.strings;

public class Solution {

	public static int myAtoi(String str) {
		int i = 0, base = 0, sign = 1;
		// discards all leading white spaces
		while(i < str.length() && str.charAt(i) == ' ' ) {
			i++;
		}
		if (i >= str.length()) {
			return 0;
		}
		// sign of the number
		if (str.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		else if (str.charAt(i) == '+') {
			sign = 1;
			i++;
		}
		//overflow and invalid input
		while(i < str.length()) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				int num = str.charAt(i) - '0';
				if (base >  Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && num > 7)) {
					return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				base = base * 10 + num;
			} else {
				break;
			}
			i++;
		}
		return sign * base;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648"));
	}

}
