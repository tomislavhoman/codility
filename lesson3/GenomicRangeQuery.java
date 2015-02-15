import java.util.Arrays;

public class GenomicRangeQuery {
	
	public static void main(String[] args) {
		System.out.printf("Solution: ");
		int[] solution = new GenomicRangeQuery().solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6});
		for (int i = 0; i < solution.length; i++) {
			System.out.printf("%d", solution[i]);
			if (i < solution.length - 1) {
				System.out.printf(", ");
			}
		}
		System.out.printf("\n");
	}

	public int[] solution(String S, int[] P, int[] Q) {

		int[] result = new int[P.length];

		int[] A = new int[S.length()];
		int[] C = new int[S.length()];
		int[] G = new int[S.length()];
		int[] T = new int[S.length()];

		A[0] = S.charAt(0) == 'A' ? 1 : 0;
		C[0] = S.charAt(0) == 'C' ? 1 : 0;
		G[0] = S.charAt(0) == 'G' ? 1 : 0;
		T[0] = S.charAt(0) == 'T' ? 1 : 0;
		for (int i = 1; i < S.length(); i++) {

			A[i] = A[i - 1];
			C[i] = C[i - 1];
			G[i] = G[i - 1];
			T[i] = T[i - 1];
			char c = S.charAt(i);
			if (c == 'A') {
				A[i]++;
			} else if (c == 'C') {
				C[i]++;
			} else if (c == 'G') {
				G[i]++;
			} else if (c == 'T') {
				T[i]++;
			}
		}

		//System.out.println("A: " + Arrays.toString(A));
		//System.out.println("C: " + Arrays.toString(C));
		//System.out.println("G: " + Arrays.toString(G));
		//System.out.println("T: " + Arrays.toString(T));

		/*for (int i = 0; i < P.length; i++) {
			int from = P[i];
			int to = Q[i];

			int noA = A[to] - (from > 0 ? A[from - 1] : 0);
			int noC = C[to] - (from > 0 ? C[from - 1] : 0);
			int noG = G[to] - (from > 0 ? G[from - 1] : 0);
			int noT = T[to] - (from > 0 ? T[from - 1] : 0);

			result[i] = noA > 0 ? 1 : noC > 0 ? 2 : noG > 0 ? 3 : noT > 0 ? 4 : 0;
		}*/

		for (int i = 0; i < P.length; i++) {
			result[i] = 
			A[Q[i]] - (P[i] > 0 ? A[P[i] - 1] : 0) > 0 ? 1 :
			C[Q[i]] - (P[i] > 0 ? C[P[i] - 1] : 0) > 0 ? 2 :
			G[Q[i]] - (P[i] > 0 ? G[P[i] - 1] : 0) > 0 ? 3 :
			T[Q[i]] - (P[i] > 0 ? T[P[i] - 1] : 0) > 0 ? 4 : 
			0;
		}

		return result;
	}
}