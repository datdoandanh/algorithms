package com.mum.edu.chapter01.arrayandstring;

import java.util.HashMap;

/**
 * Objective: Give two strings, check whether one string is permutation of other
 * Example: "sumit" and "tiums" are permutations of each other.
 * 
 * @author DatDoan
 *
 */
public class Permutation {

	public static boolean isPermutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			int value = s.charAt(i);
			int currentCount = 0;
			if (hm.containsKey(value)) {
				currentCount = hm.get(value);
			}
			hm.put(value, ++currentCount);
		}
		
		for (int i = 0; i < t.length(); i++) {
			int value = t.charAt(i);
			if (hm.containsKey(value)) {
				int currentCount = hm.get(value);
				if (currentCount < 0) {
					return false;
				}
			} else {
				return false;
			}
			
		}
		return true;
	}

	public static void main(String[] args) {
		boolean checked = isPermutation("sumit", "tiums");
		System.out.println(checked);
	}

}
