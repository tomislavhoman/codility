public class StoneWall {

	public static void main(String[] args) { 
		System.out.printf("Solution: %d\n", new StoneWall().solution(new int[]{8,8,5,7,9,8,7,4,8}));
	}

	public int solution(int[] H) {
		int count = 0;
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		stack.push(H[0]);

		for (int i = 1; i < H.length; i++) {
			//System.out.printf("i: %d, count: %d, stack: %s\n", i, count, stack.toString());
			if (H[i] < H[i - 1]) {
				while(!stack.isEmpty() && stack.peek() > H[i]) {
					stack.pop();
					count++;
				}

				if (stack.isEmpty() || H[i] > stack.peek()) {
					stack.push(H[i]);
				}
				
			} else if (H[i] > H[i - 1]) {
				stack.push(H[i]);
			}
		}

		return count + stack.size();
	}
}