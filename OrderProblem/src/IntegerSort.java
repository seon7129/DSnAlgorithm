import java.util.Arrays;

public class IntegerSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static long solution(long n) {
		String[] nums = String.valueOf(n).split("");
		Arrays.sort(nums, (s1, s2) -> s1.compareTo(s2));
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
        	long num = Integer.parseInt(nums[i]);
        	result += num * Math.pow(10, i);
        }
        
        return result;
    }

}
