import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UnfinishedPlayer {
	
	public static void main(String[] args) {
		
		String[] p = {"mislav", "stanko", "mislav", "ana", "mislav"};
		String[] c = {"stanko", "ana", "mislav", "mislav"};
		System.out.println(solution(p,c)); // mislav

	}
	
	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();
		boolean[] check = new boolean[participant.length];
		String result = null;
		
		for (int i = 0; i < participant.length; i++) {
			String key = participant[i];
			// .containsKet() : key를 가지고 있는지. containsValue()도 있음.
			if (map.containsKey(key)) {
				// .replace() : 해당 key의 value 수정
				// .get(): key값으로 value 반환
				int cnt = map.get(key) + 1;
				map.replace(key, cnt);
			}
			else	
				map.put(key,1);
		}
		
		
		for (int i = 0; i < completion.length; i++) {
			String key = completion[i];
			int cnt = map.get(key);
			if (cnt != 0) {
				map.replace(key, cnt-1);
			}
		}
		
		// map 순회 
		Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry<String, Integer> entry = entries.next();
//		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    if (entry.getValue() != 0)
		    	result = entry.getKey();
		}
		
        return result;
    }
}
