
public class CountDiv { 

	public static void main(String[] args) {
		System.out.printf("Solution: %d\n", new CountDiv().solution(6, 11, 2));
	}

	public int solution(int A, int B, int K) {
		//System.out.printf("%d\n", B / K);
		//System.out.printf("%d\n", A / K);
		//System.out.printf("%d\n", A % K);
		return B / K - A / K + (A % K == 0 ? 1 : 0);
	}
}