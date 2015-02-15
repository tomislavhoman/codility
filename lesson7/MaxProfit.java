public class MaxProfit {

	public static void main(String[] args) { 
		System.out.printf("Solution: %d\n", new MaxProfit().solution(new int[]{23171,21011,21123,21366,21013,21367}));
	}

	public int solution(int[] A) {
		
		if (A.length == 0) {
			return 0;
		}

		int maxDelta = 0;
		int maxProfit = 0;
		for (int i = 1; i < A.length; i++) {
			maxDelta = Math.max(0, maxDelta + A[i] - A[i - 1]);
			maxProfit = Math.max(maxDelta, maxProfit);
		}

		return maxProfit > 0 ? maxProfit : 0;
	}
}