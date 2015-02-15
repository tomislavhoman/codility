public class Fish {

	public static void main(String[] args) { 
		System.out.printf("Solution: %d\n", new Fish().solution(new int[]{4,3,2,1,5}, new int[]{0,1,0,0,0}));
	}

	public int solution(int[] A, int[] B) {

		java.util.Stack<Integer> river = new java.util.Stack<Integer>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (B[i] == 0) {

				boolean upstreamEaten = false;
				int upstreamFish = A[i];
				while(!river.isEmpty() && !upstreamEaten) {
					int downStreamFish = river.pop();
					if (downStreamFish > upstreamFish) {
						river.push(downStreamFish);
						upstreamEaten = true;
					}
				}

				if (!upstreamEaten) {
					count++;
				}
				
			} else if (B[i] == 1) {
				river.push(A[i]);
			}
		}
		return count + river.size();
	}
}