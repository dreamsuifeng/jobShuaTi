package LeetCode;

import java.util.Stack;

public class TagValidator591 {
	public boolean isValid1(String code) {
        if (code.equals("t")) return false;
        code = code.replaceAll("<!\\[CDATA\\[.*?\\]\\]>", "c");

        String prev = "";
        while (!code.equals(prev)) {
            prev = code;
            code = code.replaceAll("<([A-Z]{1,9})>[^<]*</\\1>", "t");
        }

        return code.equals("t");
    }
	
	public boolean isValid(String code) {
		int i = 0;
		Stack<String> stk = new Stack<>();
		while (i < code.length()) {
			if (i > 0 && stk.isEmpty()) return false;
			int k = code.indexOf("<", i);
			if (k == -1) return false;
			if (code.startsWith("<![CDATA[", k)) {
				int next = code.indexOf("]]>", k);
				if (next == -1) return false;
				i = next + 3;
			} else if (code.startsWith("</", k)) {
				int end = code.indexOf(">", k);
				if (end == -1) return false;
				String name = code.substring(k + 2, end);
				if (stk.isEmpty() || !stk.pop().equals(name)) return false;
				i = end + 1;
			} else {
				String trimmed = code.substring(i, k).trim();
				if (!trimmed.isEmpty()) return false;
				int end = code.indexOf(">", k);
				if (end == -1) 	return false;
				String name = code.substring(k + 1, end);
				if (name.length() < 1 || name.length() > 9) return false;
				for (char c : name.toCharArray()) {
					if (c < 'A' || c > 'Z') return false;
				}
				stk.push(name);
				i = end + 1;
			}
		}
		return stk.isEmpty();
	}
	
}	
