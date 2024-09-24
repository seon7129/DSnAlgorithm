import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TupleP {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));

	}
	
	public static int[] solution(String s) {

        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hash = new HashMap<>(); // Hashset은 순서를 보장하지 않음
        
        
        for (char c : s.toCharArray()) {
            if (c != '{') {
            	sb.append(c);
            }
        }
        
        String[] split = sb.toString().split("}");
        // 길이가 짧은 것부터 처리해야함
        Arrays.sort(split, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        System.out.println(Arrays.toString(split));
        String[] split2 = (String.join(",", split)).split(",");
        System.out.println(Arrays.toString(split2));
       
        
        int idx = 1;
        for (String str : split2) {
//        	System.out.println(str.isEmpty());
        	if (!str.isEmpty() && str != null && !hash.containsKey(str)) {
        		hash.put(str, idx++);
        	}
        }
        
     // HashMap 출력
        for (String key : hash.keySet()) {
            System.out.println("Key: " + key + ", Value: " + hash.get(key));
        }
        
        int[] result = hash.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()) // 값 기준으로 정렬
                .map(entry -> Integer.parseInt(entry.getKey())) // 키를 Integer로 변환
                .mapToInt(Integer::intValue) // int로 변환
                .toArray();
        
        return result;
    }


}
