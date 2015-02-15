public class Dominator {

	public static void main(String[] args) {
		System.out.printf("Solution: %d\n", new Dominator().solution(new int[]{3,4,3,2,3,-1,3,3}));
	}

	public int solution(int[] A) {
		
		int ERR = -1;
		if (A.length == 0) {
			return ERR;
		}

		int stackTop = A[0];
		int stackSize = 1;
		for (int i = 1; i < A.length; i++) {
			if (stackSize == 0) {
				stackTop = A[i];
				stackSize = 1;
				continue;
			}

			if (A[i] != stackTop) {
				stackSize--;
			} else {
				stackSize++;
			}
		}

		if (stackSize == 0) {
			return ERR;
		}

		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == stackTop) {
				count++;
			}
		}

		if (!(count > (A.length / 2))) {
			return ERR;
		}

		for (int i = 0;  i < A.length; i++) {
			if (A[i] == stackTop) {
				return i;
			}
		}

		return ERR;//Should not happen
	}
}