public class MaxCounters {
	
	public static void main(String[] args) {
		int[] solution = new MaxCounters().solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
		System.out.printf("Solution: ");
		for (int i = 0; i < solution.length; i++) {
			System.out.printf("%d", solution[i]);	
			if (i < solution.length - 1) {
				System.out.printf(", ");
			}
		}
		System.out.printf("\n");
	}

	public int[] solution(int N, int[] A) {
		int[] counters = new int[N];

		int currentMax = 0;
		int currentFloor = 0;
		for (int i = 0; i < A.length; i++) {
			int op = A[i];
			if (op > N) {
				currentFloor = currentMax;
			} else {
				if (counters[op-1] < currentFloor) {
					counters[op-1] = currentFloor;
				}
				counters[op-1]++;
				currentMax = Math.max(currentMax, counters[op-1]);
			}
		}

		for (int i = 0; i < counters.length; i++) {
			if (counters[i] < currentFloor) {
				counters[i] = currentFloor;
			}
		}

		return counters;
	}
}