public class CountFactors {

  public static void main(String[] args) {
    System.out.printf("Solution: %d\n", new CountFactors().solution(24));
  }

  public int solution(int N) {
    
    int noFactors = 0;
    long i = 1;
    long longN = (long) N;

    while (i * i < longN) {
      if (N % i == 0) {
        noFactors += 2;
      }
      i++;
    }

    if (i * i == N) {
      noFactors++;
    }

    return noFactors;
  }
}