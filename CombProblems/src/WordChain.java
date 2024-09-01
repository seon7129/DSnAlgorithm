import java.util.Arrays;
import java.util.HashMap;

public class WordChain {
	
	public static void main(String[] args) {
		String[] s = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		System.out.println(Arrays.toString(solution(3,s)));
	}

	public static int[] solution(int n, String[] words) {
        
		HashMap<String, Integer> hashmap = new HashMap<>();
		
		int i = 0;
		char start = '0';
		for (i = 0; i < words.length; i++) {
			
			if (hashmap.containsKey(words[i])) { // 이미 나온 word 
				break;
			}
			else if (i != 0 && !words[i].startsWith(start+"")) { // 마지막 단어로 시작하지 않으면 
				break;
			}
			hashmap.put(words[i], i);
			start = words[i].charAt(words[i].length()-1);
		}
		
		int[] result = {0,0};
		if (i == words.length) {
			return result;
		}
		else {
			if (i == 0) {
				result[0] = 1;
				result[1] = 1;
				return result;
			}
			else {
				result[0] = i % n + 1;
				result[1] = i / n + 1;
				return result;
			}
		}
    }
}
