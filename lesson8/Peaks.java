public class Peaks {

  public static void main(String[] args) {
    System.out.printf("Solution: %d\n", new Peaks().solution(new int[]{1,2,3,4,3,4,1,2,3,4,6,2}));
  }

  public int solution(int[] A) {

    int ERR = 0;
    int n = A.length;
    if (n < 3) {
      return ERR;
    }
    
    int[] peaks = new int[n];
    //mark where are the peaks
    for (int i = 1; i < n - 1; i++) {
      if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
        peaks[i] = 1;
      }
    }
    //System.out.printf("peaks: %s\n", java.util.Arrays.toString(peaks));

    //calculate prefix sums for O(1) querying if interval has a peak
    peaks[0] = 0;
    for (int i = 1; i < n; i++) {
      peaks[i] += peaks[i - 1];
    }
    //System.out.printf("peaks: %s\n", java.util.Arrays.toString(peaks));

    //divide the array into segments
    int i = n;
    while (i > 0) {
      if (n % i == 0) {
        int segmentSize = n / i;
        //can be divided into i segments of size segmentSize
        //check if every segment has a peak
        boolean allHaveAPeak = true;
        for (int j = 0; j < n && allHaveAPeak; j += segmentSize) {
          allHaveAPeak = allHaveAPeak && peaks[j + segmentSize - 1] > peaks[j > 0 ? j - 1 : 0];
        }
        if (allHaveAPeak) {
          return i;
        }
      }
      i--;
    }

    return ERR;
  }
}