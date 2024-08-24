import java.util.Arrays;

public class MenuRenewal {

	public static void main(String[] args) {

		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		
		// "AC", "ACDE", "BCFG", "CDE"
		System.out.println(Arrays.toString(solution(orders,course)));
		
	}
	
	public static String[] solution(String[] orders, int[] course) {
        String[] result = null;
        
        // 구현어떻게해
        
        // orders 조합을 모두 탐색 (course가 큰 숫자부터)
        // 뒤 배열에서 같은 값을 발견하면 리스트/해시에 저장
        // 만약 저장된 리스트/해시에 값이 포함된 조합이면 탐색 생략 
        
        // 사전순으로 result 오름차순
        // List<String> -> String[]
        
        return result;
    }

}
