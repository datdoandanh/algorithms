package com.mum.edu.chapter01.arrayandstring;

public class Cipher {
	
	public static String encode(String input, int rotation) {
		StringBuilder output = new StringBuilder();
		for (int i=0; i< input.length(); i++) {
			int charRotation = input.charAt(i) + rotation;
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z' ) {
				if (charRotation > 'z')
					charRotation = charRotation - 'z' + 'a' - 1;
			}
			
			if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' ) {
				if (charRotation > 'Z')
					charRotation = charRotation - 'Z' + 'A' - 1;
			}
			output.append((char)charRotation);
		}
		return output.toString();
	}
	
	public static String decode(String input, int rotation) {
		StringBuilder output = new StringBuilder();
		for (int i=0; i< input.length(); i++) {
			int charRotation = input.charAt(i) - rotation;
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z' ) {
				if (charRotation < 'a')
					charRotation = 'z' - ('a' - charRotation) + 1;
			}
			
			if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' ) {
				if (charRotation < 'A')
					charRotation = 'Z' - ('A' - charRotation) + 1;
			}
			output.append((char)charRotation);
		}
		return output.toString();
	}
	public static void main(String[] args) {
		System.out.println(encode("HELLO", 5));
		System.out.println(decode("BTWQI", 5));
	}

}
