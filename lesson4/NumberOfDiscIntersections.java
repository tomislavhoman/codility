public class NumberOfDiscIntersections {

	public static void main(String[] args) {
		System.out.printf("Solution: %d\n", new NumberOfDiscIntersections().solution(new int[]{1, 5, 2, 1, 4, 0}));
	}

	public int solution(int[] A) {
		java.util.ArrayList<Pair> edges = new java.util.ArrayList<Pair>();

		for (int i = 0; i < A.length; i++) {
			long left = (long) i - (long) A[i];
			left = Math.max(0, left);

			long right = (long) i + (long) A[i];
			right = Math.min(A.length, right);

			edges.add(new Pair((int) left, 0));
			edges.add(new Pair((int) right, 1));
		} 

		java.util.Collections.sort(edges);

		long result = 0;
		long openedDiscs = 0;

		for(Pair edge : edges) {
			if (edge.second == 0) {
				//left edge
				openedDiscs++;
			} else {
				result += --openedDiscs;
				if (result > 10000000) {
					return -1;
				}
			}
		}

		return (int) result;
	}

	public static class Pair implements Comparable<Pair> {
		public int first;
		public int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		public int compareTo(Pair that) {
			if (this.first == that.first) {
				return this.second - that.second;
			}

			return this.first - that.first;
		}

		public String toString() {
			return String.format("first: %d - second: %d", first, second);
		}
	}
}