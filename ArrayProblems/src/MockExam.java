import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MockExam {

	// 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5,      1, 2, 3, 4, 5, ...
	// 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5,     2, 1, 2, 3, 2, 4, 2, 5, ...
	// 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,    3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	
	public static void main(String args[]) {
		int[] answer = {1, 3, 2, 4, 2};
		int[] result = solution(answer);
		
		for (int r : result) {
			System.out.println(r);
		}
	}
	
	
	public static int[] solution(int[] answers) {
		
		int[] supoza1 = {1,2,3,4,5}; // 5
		int[] supoza2 = {2,1,2,3,2,4,2,5}; //8
		int[] supoza3 = {3,3,1,1,2,2,4,4,5,5}; //10
		
		int[] cnt = new int[3];
		
		int len = answers.length;
		
		for (int i = 0; i < len; i++) {
			if (answers[i] == supoza1[i % 5]) {
				cnt[0]++;
			}
			if (answers[i] == supoza2[i % 8]) {
				cnt[1]++;
			}
			if (answers[i] == supoza3[i % 10]) {
				cnt[2]++;
			}
		}
		
		int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
		
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if(cnt[i] == max) {
				result.add(i);
			}
				
		}
		
		return result.stream().mapToInt(i -> i.intValue()).toArray();

    }
	
}
