/**
 * Author: DatDoan Created Date: Apr 18, 2018
 */
package com.mum.edu.chapter01.arrayandstring;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
 * the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
 * does not map to any letters.
 * 
 * Input: "23" 
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * @author DatDoan
 *
 */
public class LetterCombinations {
  public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<>();
    if (digits.isEmpty()) {
      return ans;
    }
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for (int i=0; i < digits.length(); i++) {
      int x = Character.getNumericValue(digits.charAt(i));
      while(ans.peek().length() == i) {
        String t = ans.remove();
        for (char s: mapping[x].toCharArray()) {
          ans.add(t + s);
        }
      }
    }
    return ans;
  }
  
  public static void main(String[] args) {
    LetterCombinations solution = new LetterCombinations();
    solution.letterCombinations("23");
  }
}
