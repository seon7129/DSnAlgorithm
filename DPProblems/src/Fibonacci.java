
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int solution(int n) {
        int[] memo = new int[n+1];
        
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n+1; i++) {
            memo[i] = (memo[i-2] % 1234567 + memo[i-1] % 1234567) % 1234567;
        }
        
        return memo[n];
    }
}
