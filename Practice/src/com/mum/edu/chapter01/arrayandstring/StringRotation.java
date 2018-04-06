package com.mum.edu.chapter01.arrayandstring;

/**
 * 
 * Assume you have a method isSubString which checks if one word is substring of another.
 * Give 2 strings, s1 and s2. Write code to check if s2 is a rotation of s1 using only one 
 * call to isSubString
 * e.g., "waterbottle" is a rotation of "erbottlewat"
 * Solution:  
 * In a rotation, we cut s1 into 2 parts, x and y, and rearrange them to get s2
 * s1 = xy = "waterbottle";
 * 	x = wat
 * 	y = erbottle
 * s2 = yx = "erbottlewat"
 * We can see that yx is always a substring of xyyx regardless of where the division between x and y is.
 * So that s2 is always a substring of s1s1 
 * @author DatDoan
 *
 */
public class StringRotation {

	public static boolean isRotation(String s1, String s2) {
		String s = s1 + s1;
		return s.contains(s2);
	}
	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "erbottlewat"));
	}

}
