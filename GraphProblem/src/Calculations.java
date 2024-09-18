import java.util.Scanner;

public class Calculations {
	
	private static int maxResult = Integer.MIN_VALUE;
	private static int minResult = Integer.MAX_VALUE;
	private static int N;
	private static int[] nums;
	private static int[] ops = new int[4];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		nums = new int[N+1]; // 맨 뒤에 overflow 방지
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			ops[i] = sc.nextInt();
		}
		
		cal(1, nums[0], nums[1]);
		System.out.println(maxResult);
		System.out.println(minResult);
	}

	private static void cal(int idx, int a, int b) {

		if (idx >= N) {
			maxResult = Math.max(maxResult, a);
			minResult = Math.min(minResult, a);
			return;
		}
		
		if (ops[0] != 0) { // +
			ops[0]--;
			cal(idx+1, a+b, nums[idx+1]);
			ops[0]++;
		}
		if (ops[1] != 0) { // -
			ops[1]--;
			cal(idx+1, a-b, nums[idx+1]);
			ops[1]++;
		}
		if (ops[2] != 0) { // *
			ops[2]--;
			cal(idx+1, a*b, nums[idx+1]);
			ops[2]++;
		}
		if (ops[3] != 0) { // /
			ops[3]--;
			cal(idx+1, a/b, nums[idx+1]);
			ops[3]++;
		}
		
	}

}
