package hihoCoder;

import java.util.*;

public class xing2 {
	static boolean flagc = true, flags = true, flagf = true, flagt = true;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			flagc = true;
			flags = true;
			flagf = true;
			flagt = true;
			String s1 = in.next(), s2 = in.next();
			char[] ch1 = s1.toCharArray(), ch2 = s2.toCharArray();
			for (char c : ch1) {
				if (c == 's')
					flags = !flags;
				else if (c == 'm')
					flagc = !flagc;
				else if (c == 'f')
					flagf = !flagf;
				else if (c == 't')
					flagt = !flagt;
			}
			System.out.println(help(ch1, ch2, 0));
		}
		in.close();
	}

	public static int help(char[] ch1, char[] ch2, int pos) {
		if (pos == ch2.length)
			return 0;
		if (ch1[pos] == ch2[pos]) {
			if (ch2[pos] == 's' && flags)
				flags = !flags;
			if (ch2[pos] == 'm' && flagc)
				flagc = !flagc;
			if (ch2[pos] == 't' && flagt)
				flagt = !flagt;
			if (ch2[pos] == 'f' && flagf)
				flagf = !flagf;
			return help(ch1, ch2, pos + 1);
		}
		for (int i = pos + 1; i < ch1.length; i++) {
			if (ch1[i] == ch2[pos]) {
				if (ch2[pos] == 's' && flags) {
					int j = i + 1;
					for (; j < ch1.length; j++)
						if (ch1[j] == ch2[pos])
							break;
					char[] c1 = Arrays.copyOf(ch1, ch1.length), c2 = Arrays.copyOf(ch1, ch1.length);
					char tmp = c1[pos];
					c1[pos] = c1[i];
					c1[i] = tmp;
					tmp = c2[pos];
					c2[pos] = c2[j];
					c2[j] = tmp;
					flags = !flags;
					return 1 + Math.min(help(c1, ch2, pos + 1), help(c2, ch2, pos + 1));
				} else if (ch2[pos] == 'm' && flagc) {
					int j = i + 1;
					for (; j < ch1.length; j++)
						if (ch1[j] == ch2[pos])
							break;
					char[] c1 = Arrays.copyOf(ch1, ch1.length), c2 = Arrays.copyOf(ch1, ch1.length);
					char tmp = c1[pos];
					c1[pos] = c1[i];
					c1[i] = tmp;
					tmp = c2[pos];
					c2[pos] = c2[j];
					c2[j] = tmp;
					flagc = !flagc;
					return 1 + Math.min(help(c1, ch2, pos + 1), help(c2, ch2, pos + 1));
				} else if (ch2[pos] == 'f' && flagf) {
					int j = i + 1;
					for (; j < ch1.length; j++)
						if (ch1[j] == ch2[pos])
							break;
					char[] c1 = Arrays.copyOf(ch1, ch1.length), c2 = Arrays.copyOf(ch1, ch1.length);
					char tmp = c1[pos];
					c1[pos] = c1[i];
					c1[i] = tmp;
					tmp = c2[pos];
					c2[pos] = c2[j];
					c2[j] = tmp;
					flagf = !flagf;
					return 1 + Math.min(help(c1, ch2, pos + 1), help(c2, ch2, pos + 1));
				} else if (ch2[pos] == 't' && flagt) {
					int j = i + 1;
					for (; j < ch1.length; j++)
						if (ch1[j] == ch2[pos])
							break;
					char[] c1 = Arrays.copyOf(ch1, ch1.length), c2 = Arrays.copyOf(ch1, ch1.length);
					char tmp = c1[pos];
					c1[pos] = c1[i];
					c1[i] = tmp;
					tmp = c2[pos];
					c2[pos] = c2[j];
					c2[j] = tmp;
					flagt = !flagt;
					return 1 + Math.min(help(c1, ch2, pos + 1), help(c2, ch2, pos + 1));
				} else {
					char tmp = ch1[pos];
					ch1[pos] = ch1[i];
					ch1[i] = tmp;
					return 1 + help(ch1, ch2, pos + 1);
				}
			}
		}
		return 0;
	}
}
