
public class NQueen {

	public static void main(String[] args) {
		System.out.println(solution(4));
		
	}
	
	private static int result;
	private static int N;
	
	public static int solution(int n) {
		
		N = n;
		result = 0;
		int[] col = new int[n];
		
		nQueen(col, 0);

		return result;
    }
	
	private static void nQueen(int[] col, int n) {
		
		if (n == N) {
            result++;
        } else {
            for (int i = 0; i < N; i++) {
            	col[n] = i;
                if (isPromising(col, n))
                	nQueen(col, n + 1);
            }
        }
		
	}

    public static boolean isPromising(int[] col, int n) {
        for (int i = 0; i < n; i++) {
            if (col[i] == col[n])
            	return false;
            if ((col[i] - col[n]) == (n - i))
            	return false;
            if ((col[n] - col[i]) == (n - i))
            	return false;
        }
        return true;
    }

}
