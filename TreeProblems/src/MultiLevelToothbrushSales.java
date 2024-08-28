import java.util.Arrays;
import java.util.HashMap;

public class MultiLevelToothbrushSales {

	public static void main(String[] args) {
		String[] e = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] r = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] s = {"young", "john", "tod", "emily", "mary"};
		int[] a = {12, 4, 2, 5, 10};
		
		System.out.println(Arrays.toString(solution(e,r,s,a)));
	}
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
       
		HashMap<String, String> parents = new HashMap<>(); // me, parents
		HashMap<String, Integer> me = new HashMap<>(); // me, index 
		int[] result = new int[enroll.length]; 
		
		for (int i = 0; i < enroll.length; i++) {
			parents.put(enroll[i], referral[i]);
			me.put(enroll[i], i);
		}
		
		for (int i = 0; i < seller.length; i++) {
			String now = seller[i];
			int money = amount[i] * 100;
			int temp = 0;
			while (!now.equals("-")) {

				temp = (int) (money * 0.1);
				result[me.get(now)] += money - temp;
				money = temp;
				
				// 만약 1보다 작으면 while문 빠져나가기 
				if (temp < 1)
					break;
				
				now = parents.get(now); // now를 부모로 업데이트 
			}
		}
		
        return result;
    }

}
