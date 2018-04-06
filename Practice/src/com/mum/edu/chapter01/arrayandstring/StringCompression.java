package com.mum.edu.chapter01.arrayandstring;

/**
 * String Compression: Implement a method to perform basic string compression
 * using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2blc5a3. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string. You
 * can assume the string has only uppercase and lowercase letters (a - z).
 * 
 * @author DatDoan
 *
 */
public class StringCompression {
	public static String compressV0(String source) {
		String result = "";
		String curChar = "";
		int occurence = 0;
		for (int i = 0; i < source.length(); i++) {
			String value = String.valueOf(source.charAt(i));
			if (curChar.equals(value)) {
				occurence++;
				result.substring(0, result.length() - 1);
				result = result.substring(0, result.length() - 1) + occurence;
			} else {
				curChar = value;
				occurence = 1;
				result += curChar + occurence;
			}
		}
		return result.length() < source.length() ? result : source;
	}
	
	public static String compressV1(String source) {
		StringBuilder compressed = new StringBuilder(source.length());
		int occurence = 0;
		for (int i = 0; i < source.length(); i++) {
			occurence++;
			if (i == source.length() - 1 || source.charAt(i) != source.charAt(i+1)) {
				compressed.append(source.charAt(i)).append(occurence);
				occurence = 0;
			}
		}
		return compressed.length() <source.length() ? compressed.toString() : source;
	}

	public static void main(String[] args) {
		System.out.println(compressV1("aabcccccaaa"));
	}

}
