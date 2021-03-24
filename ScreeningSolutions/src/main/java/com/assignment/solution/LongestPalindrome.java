package com.assignment.solution;

public class LongestPalindrome {

	static String printSubStr(String str, int low, int high) {
		return str.substring(low, high + 1);
	}

	public String getLongPal(String str) {

		int maxLen = 1, start = 0;

		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				int flag = 1;

				for (int k = 0; k < (j - i + 1) / 2; k++)
					if (str.charAt(i + k) != str.charAt(j - k))
						flag = 0;

				if (flag != 0 && (j - i + 1) > maxLen) {
					start = i;
					maxLen = j - i + 1;
				}
			}
		}

		return printSubStr(str, start, start + maxLen - 1);

	}

	public static void main(String[] args) {
		LongestPalindrome lp = new LongestPalindrome();
		System.out.println(lp.getLongPal("racecar"));
	}

}
