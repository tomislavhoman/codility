public class Nesting {

	public static void main(String[] args) { 
		System.out.printf("Solution: %d\n", new Nesting().solution("(()(())())"));
		//System.out.printf("Solution: %d\n", new Nesting().solution("())"));
	}

	public int solution(String S) {
				if (S == null || "".equals(S)) {
			return 1;
		}

		java.util.Stack<Character> stack = new java.util.Stack<Character>();
		for(int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty()) {
					return 0;
				}

				char top = stack.pop();
				if (c == ')' && top != '(') {
					return 0;
				}
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}
}