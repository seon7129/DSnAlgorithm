import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class DiscountEvent {

	public static void main(String[] args) {
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] num = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		System.out.println(solution(want, num, discount));
		
	}
	
	public static int solution(String[] want, int[] number, String[] discount) {
		
		Queue<String> queue = new ArrayDeque<>(); // discount 물품들을 10개 저장해놓을 queue
		HashMap<String, Integer> wMap = new HashMap<>(); // want를 저장할 hashmap
		int result = 0;
		
		for (int i = 0; i < want.length; i++) {
			wMap.put(want[i], number[i]);
		}
		
		for (int i = 0; i < discount.length; i++) {
			String d = discount[i];
			queue.add(d);
			if (wMap.containsKey(d))
				wMap.replace(d, wMap.get(d)-1);
			if (queue.size() == 10) { // 10개가 되면 해쉬의 val이 모두 0인지 판단 -> result 업데이트
				result++;
				for (int v: wMap.values()) {
					if (v != 0) {
						result--;
						break;
					}
				}
				//맨 앞의 1개를 poll 
				String out = queue.poll();
				if (wMap.containsKey(out))
					wMap.replace(out, wMap.get(out)+1);
			}
		}
		
        return result;
    }

}
