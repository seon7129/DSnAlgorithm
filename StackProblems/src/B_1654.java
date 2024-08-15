import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = in.readLine().split(" ");
		int K = Integer.parseInt(split[0]);
		int N = Integer.parseInt(split[1]);

		int[] arr = new int[K];
		long sum = 0; // int보다 클 수 있음 
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			sum += arr[i];
		}
		
		long div = 0; // 정답 추청치 
		long cal = 0;
		long pre = 0;
		long op = N;
		while (cal < N) {
			pre = div;
			cal = 0;
			div = sum / op++;
			for (int i = 0; i < K; i++) {
				cal += (long) arr[i] / div;
			}
		}
		
		long mid = 0;

		if (pre == 0) {
			pre = div;
			div = 1;
		}
		
		
		//System.out.println("pre:"+pre + " mid:" + mid + " div:" + div);
		int cnt = 0;
		long result = 0;
		while (pre >= div) { // cal >= N, pre != div
			//System.out.println("pre:"+pre + " mid:" + mid + " div:" + div);
			cal = 0;
			//div++; // 시간초과. 이진탐색을 해야할듯. div ~ pre
			mid = (pre + div) / 2;
 			for (int i = 0; i < K; i++) {
				cal += (long) arr[i] / mid; // 	1 1 1일때 0으로 나눔..
			}
 			//System.out.println("cal:"+cal);
 			if (cal >= N) {
 				result = mid;
 				div = mid + 1;
 			}
 			else {
 				pre = mid - 1;
 			}
 			cnt++;
		}
		
		System.out.println(result);
		
	}

}
