public class MissingInteger { 
	
	public static void main(String[] args) {
		System.out.printf("Solution: %d\n", new MissingInteger().solution(new int[]{1, 3, 6, 4, 1, 2}));
	}

	public int solution(int[] A) {

		if (A.length == 1 && A[0] != 1) { //A hack for the extreme case
			return 1;
		}

		int N = A.length;
		int[] counter = new int[N + 1]; 
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && A[i] <= N) {
				counter[A[i]]++;
			}
		}

		for (int i = 1; i < N; i++) {
			if (counter[i] == 0) {
				return i;
			}
		}

		return N + 1;
	}
}