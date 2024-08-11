import java.util.Stack;

public class PairRemove {

	public static void main(String[] args) {
		System.out.println(solution("baabaa"));

	}
	
	public static int solution(String s)
    {
		String[] arr = s.split("");
		Stack<String> stack = new Stack<String>();
		int len = arr.length;
		
		stack.push(arr[0]);
		for (int i = 1; i < len; i++) {
			if (stack.isEmpty()) {
				stack.push(arr[i]);
			}
			else if (stack.peek().equals(arr[i])) {
				stack.pop();
			}
			else {
				stack.push(arr[i]);
			}
		}
		
		if (stack.isEmpty())
			return 1;
		return 0;
        
    }

}
