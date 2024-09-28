import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RollCake {

	public static void main(String[] args) {
		int[] t = {1, 2, 1, 3, 1, 4, 1, 2};
		System.out.println(solution(t));
	}

	public static int solution(int[] topping) {
        Set<Integer> cheolsoo = new HashSet<>();
        HashMap<Integer, Integer> dongseng = new HashMap<>();;
        
        // 동생 값 넣어두기 
        for (int i = 0; i < topping.length; i++) {
        	int val = topping[i];
        	if (dongseng.containsKey(val)) {
        		dongseng.replace(val, dongseng.get(val)+1);
        	}
        	else
        		dongseng.put(val, 1);
        }
        
        int cnt = 0;
        for (int i = 0; i < topping.length-1; i++) {
        	int val = topping[i];
        	
        	// 철수 하나 더하고 
        	cheolsoo.add(val);
        	// 동생 하나 빼고 
        	if (dongseng.get(val) == 1) { // 제거 
        		dongseng.remove(val);
        	}else {
        		dongseng.replace(val, dongseng.get(val)-1);
        	}
        	
        	System.out.println("i size " + i + " " + cheolsoo.size() + " " + dongseng.size());
        	if (cheolsoo.size() == dongseng.size()) {
        		
        		cnt++;
        	}
        		
        }
        return cnt;
    }
}
