
public class MinAvgTwoSlice {
	
	public static void main(String[] args) {
		System.out.printf("Solution: %d\n", new MinAvgTwoSlice().solution(new int[]{4,2,2,5,1,5,8}));
	}

	public int solution(int[] A) {
		int[] prefs = new int[A.length];
		prefs[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			prefs[i] = prefs[i - 1] + A[i];
		} 

		float min = Float.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < A.length - 1; i++) {
			float avg = (A[i + 1] + A[i]) / 2.0f;
			if (avg < min) {
				min = avg;
				index = i;
			}
			//System.out.printf("i - %d, A[i] - %d, A[i+1] - %d, avg - %f, min - %f, index - %d\n", i, A[i], A[i+1], avg, min, index);
		}

		for (int i = 0; i < A.length - 2; i++) {
			float avg = (A[i + 2] + A[i + 1] + A[i]) / 3.0f;
			if (avg < min) {
				min = avg;
				index = i;
			}
			//System.out.printf("i - %d, A[i] - %d, A[i+1] - %d, avg - %f, min - %f, index - %d\n", i, A[i], A[i+1], avg, min, index);
		}

		return index;
	}
}