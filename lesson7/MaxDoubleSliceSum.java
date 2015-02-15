public class MaxDoubleSliceSum {

  public static void main(String[] args) {
    System.out.printf("Solution: %d\n", new MaxDoubleSliceSum().solution(new int[]{3,2,6,-1,4,5,-1,2}));
  } 
  
  public int solution(int[] A) {
        
    int N = A.length;
    if (N < 3) {
        return 0;
    }
    
    int[] maxEnding = new int[N];
    int[] maxBegining = new int[N];
    
    int maxSoFar = 0;
    for (int i = 1; i < N; i++) {
        maxSoFar = Math.max(0, maxSoFar + A[i]);
        maxEnding[i] = maxSoFar;
    }
    
    maxSoFar = 0;
    for (int i = N - 2; i >= 0; i--) {
        maxSoFar = Math.max(0, maxSoFar + A[i]);
        maxBegining[i] = maxSoFar;
    }
    
    //System.out.println("Max ending: " + Arrays.toString(maxEnding));
    //System.out.println("Max begining: " + Arrays.toString(maxBegining));
    
    int maxDoubleSlice = 0;
    for (int i = 0; i < N - 2; i++) {
        int doubleSlice = maxEnding[i] + maxBegining[i + 2];
        if (doubleSlice > maxDoubleSlice) {
            maxDoubleSlice = doubleSlice;
        }
    }
    
    return maxDoubleSlice;
  }
}