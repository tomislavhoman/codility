public class Brackets {

	public static void main(String[] args) {
		System.out.printf("Solution: %d\n", new Brackets().solution("{[(ddd)(lll)]}()"));
	}

	public int solution(String S) {
		if (S == null || "".equals(S)) {
			return 1;
		}

		java.util.Stack<Character> stack = new java.util.Stack<Character>();
		for(int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
			} else if (c == '}' || c == ']' || c == ')') {
				if (stack.isEmpty()) {
					return 0;
				}

				char top = stack.pop();
				if ((c == '}' && top != '{') || 
					(c == ']' && top != '[') || 
					(c == ')' && top != '(')) {
					return 0;
				}
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}
}