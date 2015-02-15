public class PermCheck {
	public static void main(String[] args) {
		System.out.printf("Solution: %d\n", new PermCheck().solution(new int[]{4, 1, 3, 2}));
		System.out.printf("Solution: %d\n", new PermCheck().solution(new int[]{4, 1, 3}));
	}

	public int solution(int[] A) {
		int[] count = new int[A.length + 1];
		for (int i = 0; i < A.length; i++) {
			if(A[i] >= 0 && A[i] <= A.length) {
				count[A[i]]++;
			}
		}

		for (int i = 1; i < count.length; i++) {
			if (count[i] == 0) {
				return 0;
			}
		}

		return 1;
	}
}