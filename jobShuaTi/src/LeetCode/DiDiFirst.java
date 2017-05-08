package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DiDiFirst {
	Map<Character, String> dict = new HashMap<>();

	public void mapInit() {
		dict.put('2', "abc");
		dict.put('3', "def");
		dict.put('4', "ghi");
		dict.put('5', "jki");
		dict.put('6', "mno");
		dict.put('7', "pqrs");
		dict.put('8', "tuv");
		dict.put('9', "wxyz");

	}

	public static int LCS(String str1, String str2) {
		int[][] opt = new int[str2.length() + 1][str1.length() + 1];

		for (int i = 0; i <= str2.length(); i++) {
			opt[i][0] = 0;
		}

		for (int j = 0; j <= str1.length(); j++) {
			opt[0][j] = 0;
		}

		for (int j = 1; j <= str1.length(); j++) {
			for (int i = 1; i <= str2.length(); i++) {
				if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
					opt[i][j] = opt[i - 1][j - 1] + 1;
				} else {
					opt[i][j] = (opt[i - 1][j] >= opt[i][j - 1] ? opt[i - 1][j] : opt[i][j - 1]);
				}
			}
		}

		return opt[str2.length()][str1.length()];
	}

	public String getSimiWord(String word, String[] wordList) {
		StringBuffer buffer = new StringBuffer();
		for (int j = 0; j < word.length(); ++j) {
			buffer.append(dict.get(word.charAt(j)));
		}
		String oriWord = buffer.toString();
		int len = Integer.MIN_VALUE;
		String result = null;
		for (int i = 0; i < wordList.length; ++i) {
			int temp = LCS(oriWord, wordList[i]);
			if (temp > len) {
				len = temp;
				result = wordList[i];
				System.out.println(len + "," + wordList[i]);
			}
		}
		System.out.println(len);
		return result;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		while (in.hasNextInt()) {// 注意while处理多个case
			String[] words = in.nextLine().split(" ");
			String b = in.nextLine();
			for (String string : words) {
				System.out.print(string+",");
			}
			DiDiFirst test = new DiDiFirst();
			test.mapInit();
			System.out.println(test.getSimiWord(b, words));

//		}

	}
}
// Produces a printable string representation of a dictionary
