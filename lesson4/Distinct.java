public class Distinct {

	public static void main(String[] args) { 
		System.out.printf("Solution: %d\n", new Distinct().solution(new int[]{2, 1, 1, 2, 3, 1}));
	}

	public int solution(int[] A) {
		java.util.Arrays.sort(A);
		if (A.length == 0) {
			return 0;
		}

		if (A.length == 1) {
			return 1;
		}

		int distinct = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				distinct++;
			}
		}
		return distinct;
	}
}