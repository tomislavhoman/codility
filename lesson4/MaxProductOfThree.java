import java.util.Arrays;

public class MaxProductOfThree {

	public static void main(String[] args) { 
		System.out.printf("Solution: %d\n", new MaxProductOfThree().solution(new int[]{-3, 1, 2, -2, 5, 6}));
	}

	public int solution(int[] A) {
		Arrays.sort(A);
		int len = A.length;
		int prod1 = A[len - 3] * A[len - 2] * A[len - 1];
		int prod2 = A[0] * A[1] * A[len - 1];
		return Math.max(prod1, prod2);
	}
}