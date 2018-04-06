package com.mum.edu.chapter01.arrayandstring;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumSolution {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				result = new int[] { map.get(complement), i};
				return result;
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {2, 7, 11, 15};
		System.out.println(Arrays.toString(twoSum(nums, 9))); 
	}
}
