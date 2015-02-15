public class TapeEquilibrium {

	public static void main(String[] args) {
		System.out.printf("Solution is: %d\n", new TapeEquilibrium().solution(new int[]{3, 1, 2, 4, 3})); 
	}

	public int solution(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int partialSum = 0;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < A.length - 1; i++) {
			partialSum += A[i];
			minDiff = Math.min(minDiff, Math.abs(partialSum - (sum - partialSum)));
		}

		return minDiff;
	}
}
