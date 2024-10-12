import java.util.Arrays;

public class LifeBoat {

	public static void main(String[] args) {
		int[] p = {40, 50, 60, 80};
		System.out.println(solution(p,120)); //2

	}

	// 그리디로 어떻게 가능..?
	// 더했을때 최대와 가까운 조합을 먼저 구하고 시작해야하나?
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int cnt = 0;
        for (int i = 0; i < people.length; i++) {
            int sum = 0;
            for (int j = i; j < people.length; j++) {
                if (j == people.length -1){
                    cnt++;
                    break;
                }
                else if (sum + people[j] > limit){
                    i = j-1;
                    cnt++;
                    break;
                }
                sum += people[j];
            }
        }
        
        return cnt;
    }
}
