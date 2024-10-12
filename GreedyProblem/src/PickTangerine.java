import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickTangerine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public int solution(int k, int[] tangerine) {
        
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < tangerine.length; i++) {
			int val = tangerine[i];
			if (map.containsKey(val)) {
				map.replace(val, map.get(val) + 1);
			}
			else map.put(val, 1);
		}
		
		// value 순으로 정렬
		// HashMap을 List로 변환
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        // 값에 따라 내림차순 정렬
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // 정렬된 결과
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            // System.out.println(k);
            if (k <= 0) {
            	break;
            }
            k -= entry.getValue();
            cnt++;
        }

		return cnt;
    }
}
