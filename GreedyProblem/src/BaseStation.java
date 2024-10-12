import java.util.Arrays;

public class BaseStation {

	public static void main(String[] args) {
		int[] s = {3, 7, 11};
		System.out.println(solution(13, s, 1)); // 3
		
//		13 [3, 7, 11] 1 4
//		5 [3] 2 0
//		6 [3] 2 1
//		16 [1, 16] 2 2 -> 반
//		6 [4] 2 1
//		11 [1, 4] 1 2
//		11 [1, 5] 1 3
//		5 [1, 2, 3, 4, 5] 1 0
//		200000000 [100000000] 5 18181818

	}
	
	public static int solution(int n, int[] stations, int w) {
        int cnt = 0;

        Arrays.sort(stations);

        int preRight = 0; // 마지막 커버리지가 끝나는 오른쪽 경계
        for (int i = 0; i < stations.length; i++) {
            // 현재 기지국의 왼쪽과 오른쪽 경계
            int curLeft = stations[i] - w;
            int curRight = stations[i] + w;

            // 이전 기지국의 오른쪽 경계를 고려하여 탐색
            if (curLeft > preRight + 1) {
                // 이전 기지국의 커버리지 이후의 공간 계산
                int midSpace = curLeft - (preRight + 1);
                cnt += midSpace / (w * 2 + 1);
                if (midSpace % (w * 2 + 1) != 0) {
                    cnt++;
                }
            }

            // 이전 기지국의 커버리지를 업데이트
            preRight = curRight;
        }

        // 마지막 기지국 이후의 공간 탐색
        if (preRight < n) {
            int midSpace = n - preRight;
            cnt += midSpace / (w * 2 + 1);
            if (midSpace % (w * 2 + 1) != 0) {
                cnt++;
            }
        }

        return cnt;
    }

}
