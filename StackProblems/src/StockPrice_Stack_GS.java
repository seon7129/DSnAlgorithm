import java.util.Arrays;
import java.util.Stack;

public class StockPrice_Stack_GS {
	
	public static void main(String args[]) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] result = solution(prices);
		
		System.out.println(Arrays.toString(result)); // [4, 3, 1, 1, 0]
	}

	public static int[] solution(int[] prices) {
	    // 주식 가격이 떨어지지 않은 기간을 계산하기 위해 사용할 스택
	    Stack<Integer> beginIdxs = new Stack<>();
	    
	    // 배열 인덱스를 나타내는 변수 i 초기화
	    int i = 0;
	    
	    // 결과를 저장할 배열을 입력 배열과 동일한 크기로 초기화
	    int[] terms = new int[prices.length];

	    // 첫 번째 주식 가격의 인덱스를 스택에 추가
	    beginIdxs.push(i);

	    // 주식 가격 배열을 순회하기 위해 i를 1부터 시작
	    for (i = 1; i < prices.length; i++) {
	        // 스택이 비어있지 않고, 현재 주식 가격이 스택의 맨 위에 있는 인덱스에 해당하는 주식 가격보다 낮을 경우
	        while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
	            // 스택에서 인덱스를 꺼내고, 그 인덱스에 해당하는 가격이 유지된 기간을 계산
	            int beginIdx = beginIdxs.pop();
	            // 해당 인덱스의 주식 가격이 유지된 기간을 계산하여 terms 배열에 저장
	            terms[beginIdx] = i - beginIdx;
	        }
	        // 현재 인덱스를 스택에 추가
	        beginIdxs.push(i);
	    }
	    
	    // 아직 스택에 남아있는 인덱스들은 끝까지 가격이 떨어지지 않은 경우이므로
	    while (!beginIdxs.empty()) {
	        // 스택에서 인덱스를 꺼내고, 해당 인덱스에 남아있는 기간을 계산
	        int beginIdx = beginIdxs.pop();
	        // 해당 인덱스의 주식 가격이 끝까지 유지된 기간을 계산하여 terms 배열에 저장
	        terms[beginIdx] = i - beginIdx - 1;
	    }

	    // 계산된 기간이 저장된 배열을 반환
	    return terms;
	}

}
