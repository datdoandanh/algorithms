package com.mum.edu.chapter01.arrayandstring;

import java.util.HashMap;

public class StringProblems {

	/**
	 * 3. Longest Substring Without Repeating Characters
	 * Given a string, find the length of the longest substring without repeating characters.
	 * 
	 * Examples:
	 * 	Given "abcabcbb", the answer is "abc", which the length is 3.
	 * 	Given "bbbbb", the answer is "b", with the length of 1.
	 * 	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
	 * 	abcdecfghbkmn
	 * 	"pwke" is a subsequence and not a substring.
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int max = 0, j = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				 j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		
		return max;
    }
	
	/**
	 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
	 * Input: "babad"
	 * Output: "bab"
	 * Note: "aba" is also a valid answer.
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcdecfghbkmn"));
		System.out.println("longestPalindrome: " + longestPalindrome("babad"));
	}

}
