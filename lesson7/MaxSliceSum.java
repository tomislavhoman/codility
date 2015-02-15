public class MaxSliceSum {

	public static void main(String[] args) { 
		System.out.printf("Solution: %d\n", new MaxSliceSum().solution(new int[]{3,2,-6,4,0}));
	}

  public int solution(int[] A) {
		
    int maxEnding = 0;
    int maxSlice = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      //System.out.printf("i: %d, maxEnding: %d, maxSlice: %d\n", i, maxEnding, maxSlice);
      maxEnding = Math.max(0, maxEnding + A[i]);
      maxSlice = Math.max(maxEnding, maxSlice);
    }

    if (maxSlice == 0) {
      int maxElement = A[0];
      for (int i = 1; i < A.length; i++) {
        maxElement = Math.max(A[i], maxElement);
      }
      return maxElement;
    }

    return maxSlice;
  }
}