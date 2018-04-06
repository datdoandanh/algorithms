package com.mum.edu.chapter01.arrayandstring;

import java.util.HashMap;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a
 * permutation of a palindrome. A palindrome is a word or phrase that is the
 * same forwards and backwards. A permutation is a rearrangement of letters. The
 * palindrome does not need to be limited to just dictionary words. EXAMPLE
 * Input: Tact Coa Output: True (permutations: "taco cat'; "atc o eta·; etc.)
 * 
 * Solution: We need to have an even number of almost all characters, so that
 * half can be on one side and half can be on the other side. At most one
 * character (the middle character) can have an odd count.
 * 
 * @author DatDoan
 *
 */
public class PalindromePermutation {

	public static boolean isPalindromeOfPermutation(String phrase) {
		int countOdd = 0;
		HashMap<Integer, Integer> table = new HashMap<>();
		phrase = phrase.toLowerCase();
		for (int i = 0; i < phrase.length(); i++) {
			int val = phrase.charAt(i);
			if (val >= 'a' && val <= 'z') {
				int count = 1;
				if (table.containsKey(val)) {
					count = table.get(val);
					count++;
				}
				if (count % 2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
				table.put(val, count);
			}
		}
		System.out.println(table);
		System.out.println("countOdd: " + countOdd);
		return countOdd <= 1;
	}

	public static void main(String[] args) {
		System.out.println(isPalindromeOfPermutation("Tact Coa"));
	}

}
