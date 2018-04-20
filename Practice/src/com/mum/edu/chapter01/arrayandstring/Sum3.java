/**
 * Author: DatDoan Created Date: Apr 17, 2018
 */
package com.mum.edu.chapter01.arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets. Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author DatDoan
 *
 */
public class Sum3 {
  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> results = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
        int low = i + 1;
        int high = nums.length - 1;
        while (low < high) {
          int sum = nums[i] + nums[low] + nums[high];
          if (sum == 0) {
            results.add(Arrays.asList(nums[i], nums[low], nums[high]));
            while (low < high && nums[low] == nums[low + 1]) {
              low++;
            }
            while (low < high && nums[high] == nums[high - 1]) {
              high--;
            }
            low++;
            high--;
          } else if (sum > 0) {
            high--;
          } else {
            low++;
          }
        }
      }
    }

    return results;
  }

  public static void main(String[] args) {
    System.out
        .println(threeSum(new int[] {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));
  }
}
