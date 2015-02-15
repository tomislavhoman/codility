public class FrogRiverOne {
	public static void main(String[] args) {
		System.out.printf("Solution: %d\n", new FrogRiverOne().solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
	}

	public int solution(int X, int[] A) {
		int[] count = new int[X + 1];
		int availableLeaves = 0;
		for (int i = 0; i < A.length; i++) {
			if (count[A[i]] == 0) {
				//First time here
				availableLeaves++;
				if (availableLeaves == X) {
					return i;
				}
			} 
			count[A[i]]++;
		}

		return -1;
	}
}