
public class StockPrice {

	public int[] solution(int[] prices) {
		
        int[] result = new int[prices.length];
        
        int current = 0;
        int nexts = 0;
        int cnt = 0;
        for (int i = 0; i < prices.length; i++) {
        	cnt = 0;
        	current = prices[i];
        	for (int j = i+1; j < prices.length; j++) {
        		cnt++;
        		nexts = prices[j];
        		if (current > nexts) {
        			result[i] = cnt;
        			break;
        		}
        	}
        	result[i] = cnt;
        }
        
        return result;
    }
}
