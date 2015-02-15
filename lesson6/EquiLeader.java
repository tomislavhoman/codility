public class EquiLeader {

	public static void main(String[] args) {
		System.out.printf("Solution: %d\n", new EquiLeader().solution(new int[]{4,3,4,4,4,2}));
	}

	public int solution(int[] A) {
		int count = 0;

		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		stack.push(A[0]);
		for (int i = 0; i < A.length; i++) {
			if (stack.isEmpty()) {
				stack.push(A[i]);
				continue;
			}

			if (stack.peek() == A[i]) {
				stack.push(A[i]);
			} else {
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			return 0;
		}

		int leader = stack.pop();
		int leaderNo = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == leader) {
				leaderNo++;
			}
		}

		if (!(leaderNo > (A.length / 2))) {
			return 0;
		}

		int leadersScanned = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == leader) {
				leadersScanned++;
			} 

			int leftSize = i + 1;
			int rightSize = A.length - leftSize;
			if ((leadersScanned > (leftSize / 2)) && 
				((leaderNo - leadersScanned) > (rightSize / 2))) {
				count++;
			}
		}

		return count;
	}
}