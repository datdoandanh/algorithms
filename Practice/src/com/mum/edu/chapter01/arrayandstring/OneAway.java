package com.mum.edu.chapter01.arrayandstring;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. 
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * 
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 * 
 * @author DatDoan
 *
 */
public class OneAway {

	public static boolean oneEditWay(String first, String second) {
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		String s1, s2;
		if (first.length() > second.length()) {
			s1 = first;
			s2 = second;
		} else {
			s1 = second;
			s2 = first;
		}
		int index1 = 0, index2 = 0;
		int countEdit = 0;
		while(index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) == s2.charAt(index2)) {
				index1 ++;
				index2 ++;
			} else {
				if (s1.length() == s2.length()) {
					countEdit++;
					if (countEdit == 2) {
						System.out.println("index1: " + index1 + " index2: " + index2);
						return false;
					}
					index1 ++;
					index2 ++;
					
				} else {
					if (index1 == index2) {
						index1 ++;
					} else {
						System.out.println("index1: " + index1 + " index2: " + index2);
						return false;
					}
				}
			}
		}
		System.out.println("index1: " + index1 + " index2: " + index2);
		return true;
	}
	public static void main(String[] args) {
		System.out.println(oneEditWay("pale", "pal"));
		System.out.println(oneEditWay("pales", "pale"));
		System.out.println(oneEditWay("pale", "pales"));
		System.out.println(oneEditWay("pale", "bale"));
		System.out.println(oneEditWay("pale", "bae"));
		System.out.println(oneEditWay("pale", "pbl"));
		System.out.println(oneEditWay("pale", "ple"));
	}

}
