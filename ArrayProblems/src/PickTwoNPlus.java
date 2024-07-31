
public class PickTwoNPlus {
	
	public int[] solution(int[] numbers) {
		
		int length = numbers.length;
		int[] arr = new int[200];
		
		for (int i = 0; i < length-1; i++) {
			for (int j = i+1; j < length; j++) {
				arr[numbers[i]+numbers[j]]++; // 더한 값을 인덱스로 만들고, 해당 배열값을 양수로 
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < 200; i++) {
			if(arr[i] > 0)
				cnt++;
		}
		
		int[] answer = new int[cnt];
		int newCnt = 0;
		for (int i = 0; i < 200; i++) {
			if(arr[i] > 0) {
				answer[newCnt++] = i;
			}
		}
		
        return answer;
    }
	

}
