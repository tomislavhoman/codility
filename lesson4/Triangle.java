public class Triangle {

	public static void main(String[] args) { 
		System.out.printf("Solution: %d\n", new Triangle().solution(new int[]{10, 2, 5, 1, 8, 20}));
	}

	public int solution(int[] A) {

		if (A.length < 3) {
			return 0;
		}

		java.util.Arrays.sort(A);

		for (int i = 0; i < A.length - 2; i++) {
			long firstTwo = (long) A[i] + (long) A[i + 1];
			long last =  (long) A[i + 2];
			if (firstTwo > last) {
				return 1;
			}
		}

		return 0;
	}
}