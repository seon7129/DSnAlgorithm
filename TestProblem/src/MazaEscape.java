import java.util.Stack;

public class MazaEscape {

    public static void main(String[] args) {
        // 3	4	2	3	3	1	5
        // "dllrl"
        System.out.println(solution(3, 4, 2, 3, 3, 1, 5));
    }

    // d l r u 사전순
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {

    	StringBuilder sb = new StringBuilder();
    	
    	int dist = Math.abs(r-x) + Math.abs(c-y);
    	if ((k - dist) % 2 != 0 || k < dist) {
    		return "impossible";
    	}
    	
    	while (x != r || y != c) {
    		if (r > x) {
    			sb.append("d");
    			x++;
    		}
    		else if (c < y) {
    			sb.append("l");
    			y--;
    		}
    		else if (c > y) {
    			sb.append("r");
    			y++;
    		}
    		else if (r < x) {
    			sb.append("u");
    			x--;
    		}
    	}
    	
    	int count = k - dist;
    	Stack<String> stack = new Stack<>();
    	while (count != 0) {
    		if (x < n) {
    			sb.append("d");
    			stack.add("u");
    			x++;
    		}
    		else if (y > 1) {
    			sb.append("l");
    			stack.add("r");
    			y--;
    		}
    		else if (y < m) {
    			sb.append("rl");
    		}
    		else if (x > 1) {
    			sb.append("ud");
    		}
    		count -= 2;
    	}
    	
    	while (!stack.isEmpty()) {
    		sb.append(stack.pop());
    	}
    	
    	return sb.toString();
    }

    
}
