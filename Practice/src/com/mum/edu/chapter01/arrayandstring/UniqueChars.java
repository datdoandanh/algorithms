package com.mum.edu.chapter01.arrayandstring;

//1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
public class UniqueChars {

	public static boolean isUniqueChars(String str) {
		boolean[] charSet = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}
	public static void main(String[] args) {
		boolean checked = isUniqueChars("Doan");
		System.out.println(checked);
	}

}
