import java.util.Arrays;

public class ExpectedMatches {
	
	public static void main(String[] args) {

		System.out.println(solution(8,4,5)); // 3
		System.out.println(solution(8,5,6)); // 1 // 반례 
		System.out.println(solution(8,5,8)); // 2 // 반례 
		System.out.println(solution(8,4,6)); // 3
	}

	
	public static int solution(int n, int a, int b) {
        
        if (n == 2)
            return 1;
		
		int rest = n; // 8
		
		int tempN = n;
		int round = 0;
		// n이 2의 몇 제곱인지 계산 
        while (tempN > 1) {
            tempN >>= 1; // 8, 4, 2, 1
            round++;
        }
		
		while (rest / 2 != 1) { // 8(3), 4(2), 2(1)(종료)
			
			rest /= 2;
			
			// 같은 그룹에 속해있지 않다면,
			if ((a-1) / rest != (b-1) / rest) {
				break;
			}		
			round--;
		}

        return round;
    }
	
}
