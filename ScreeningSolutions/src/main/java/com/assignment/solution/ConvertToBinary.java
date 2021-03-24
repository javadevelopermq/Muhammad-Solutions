package com.assignment.solution;

public class ConvertToBinary {
	static String reverseBinary(String result) {
		String s = "";
		for (int i = result.length() - 1; i >= 0; i--) {
			s += result.charAt(i);
		}
		return s;
	}

	private static int reverseResult(String result) {
		Integer binaryNumber = Integer.parseInt(result);
		int decimal = 0;
		int p = 0;
		while (true) {
			if (binaryNumber == 0) {
				break;
			} else {
				int temp = binaryNumber % 10;
				decimal += temp * Math.pow(2, p);
				binaryNumber = binaryNumber / 10;
				p++;
			}
		}
		return decimal;
	}

	private static String convertNumberToBinary(int x, int len) {
		StringBuilder result = new StringBuilder();

		for (int i = len - 1; i >= 0; i--) {
			int mask = 1 << i;
			result.append((x & mask) != 0 ? 1 : 0);
		}

		return result.toString();
	}

	public static void main(String[] args) {
		String number = "47";
		String result = convertNumberToBinary(Integer.parseInt(number), 8);
		// System.out.println("Converted Binary Str::" + result);

		int reversedStr = reverseResult(reverseBinary(result));
		System.out.println(reversedStr);
	}
}