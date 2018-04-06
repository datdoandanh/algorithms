package com.mum.edu.chapter01.arrayandstring;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArrayProblem {

	/**
	 * Find all pairs in array of integers whose sum is equal to the give sum - Does
	 * array contain only positive or negative number? - What if the same pair
	 * repeat twice, should we print it every time? - Is reverse of pair is
	 * acceptable, e.g. can we print both (4,1) and (1, 4) if the give sum is 5? - -
	 * Do we only need to print distinct pair? does (3,3) is a valid pair if the
	 * give sum is 6? Solution: - If the give sum is 7 and the one number in pair is
	 * 3, the the other number must be 4. - To implement this solution, we need to
	 * store all numbers in array in a hashtable to check if it contains the second
	 * number.
	 * 
	 * @param input
	 * @param sum
	 */
	public static void hasPairWithSum(int[] input, int sum) {
		Map<Integer, Integer> map = new Hashtable<>();
		int occurence = 0;
		for (int num : input) {
			occurence = 1;
			if (map.containsKey(num)) {
				occurence = map.get(num);
				occurence++;
			}
			map.put(num, occurence);
		}

		for (int first : input) {
			int second = sum - first;
			if (map.containsKey(second)) {
				occurence = map.get(second);
				if (occurence > 0) {
					if (second == first) {
						if (occurence > 1) {
							System.out.println("[" + first + "," + second + "]");
							occurence -= 2;
							map.put(first, occurence);
						}
					} else {
						int firstOccurence = map.get(first);
						firstOccurence--;
						int secondOccurence = map.get(second);
						secondOccurence--;
						map.put(first, firstOccurence);
						map.put(second, secondOccurence);
						System.out.println("[" + first + "," + second + "]");
					}
				}
			}
		}

	}

	public static int equivalentArrays(int[] a1, int[] a2) {
		Set<Integer> setA1 = new HashSet<>();
		for (int i = 0; i < a1.length; i++) {
			setA1.add(a1[i]);
		}
		Set<Integer> setA2 = new HashSet<>();
		for (int i = 0; i < a2.length; i++) {
			setA2.add(a2[i]);
		}

		if (setA1.size() != setA2.size()) {
			return 0;
		}

		for (int num : setA1) {
			if (!setA2.contains(num)) {
				return 0;
			}
		}
		return 1;
	}

	public static int hasSingleMaximum(int[] a) {
		int max = Integer.MIN_VALUE;
		int occurrence = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				occurrence = 1;
				max = a[i];
			} else if (a[i] == max) {
				occurrence++;
			}
		}
		if (occurrence == 1) {
			return 1;
		}
		return 0;
	}

	public static int isOnionArray(int[] a) {
		for (int j = 0; j < a.length; j++) {
			int k = a.length - 1 - j;
			if (j != k) {
				if (a[j] + a[k] > 10) {
					return 0;
				}
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		// int[] input = new int[] { 1, 2, 3, 4, 4, 3, 5 };
		// hasPairWithSum(input, 8);

		// System.out.println(isOnionArray(new int[] {1, 2, 19, 4, 5}));
		// System.out.println(isOnionArray(new int[] {1, 2, 3, 4, 15}));

		System.out.println(equivalentArrays(new int[] { 1, 2, 3 }, new int[] { 2 }));

	}

}
