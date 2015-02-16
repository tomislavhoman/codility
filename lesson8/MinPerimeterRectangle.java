public class MinPerimeterRectangle {

  public static void main(String[] args) {
    System.out.printf("Solution: %d\n", new MinPerimeterRectangle().solution(30));
  }

  public int solution(int N) {
    int minPerimeter = Integer.MAX_VALUE;

    int i = 1;
    while (i * i < N) {
      if (N % i == 0) {
        minPerimeter = Math.min(minPerimeter, 2 * (i + N / i));
      }
      i++;
    }

    if (i * i == N) {
      minPerimeter = Math.min(minPerimeter, 4 * i);
    }

    return minPerimeter; 
  }
}