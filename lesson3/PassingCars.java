
public class PassingCars {

	public static void main(String[] args) {
		System.out.printf("Solution: %d\n", new PassingCars().solution(new int[]{0, 1, 0, 1, 1}));
	}

	public int solution(int[] A) {
		long inf = 1000000000l;
		int[] rightGoing = new int[A.length];
		rightGoing[0] = A[0] == 0 ? 1 : 0;
		//System.out.printf("%d", rightGoing[0]);
		for (int i = 1; i < rightGoing.length; i++) {
			rightGoing[i] = rightGoing[i - 1] + (A[i] == 0 ? 1 : 0);
			//System.out.printf("%d", rightGoing[i]);
		}

		long sum = 0l;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				sum += rightGoing[i];
				if (sum > inf) {
					return -1;
				}
			}
		}

		return (int) sum;
 	}
}