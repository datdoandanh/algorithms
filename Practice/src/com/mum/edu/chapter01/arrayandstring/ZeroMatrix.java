package com.mum.edu.chapter01.arrayandstring;

import java.util.Arrays;

public class ZeroMatrix {

	public static void setZeros(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// row
		for (int row = 0; row < matrix.length; row++) {
			if (matrix[row][0] == 0) {
				setRowZero(matrix, row);
			}
		}
		// col
		for (int col = 0; col < matrix[0].length; col++) {
			if (matrix[0][col] == 0) {
				setColZero(matrix, col);
			}
		}
	}

	private static void setRowZero(int matrix[][], int row) {
		for (int col = 0; col < matrix[0].length; col++) {
			matrix[row][col] = 0;
		}
	}

	private static void setColZero(int matrix[][], int col) {
		for (int row = 0; row < matrix.length; row++) {
			matrix[row][col] = 0;
		}
	}

	private static void print(int[][] matrix) {
		for (int i=0; i< matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 9, 0 } };
		System.out.println("Before");
		print(matrix);
		System.out.println("After");
		setZeros(matrix);
		print(matrix);
	}

}
