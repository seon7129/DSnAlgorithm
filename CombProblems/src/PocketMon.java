import java.util.HashSet;

public class PocketMon {

	public int solution(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        int result = nums.length / 2;
        
        for (int n : nums) {
        	hash.add(n);
        }
        
        if (hash.size() >= result)
        	return result;
        else {
        	return hash.size();
        }
    }
}
