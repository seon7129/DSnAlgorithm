import java.util.Stack;

public class SpinBracket {
	
	public static void main(String args[]) {
		System.out.println(solution("}}}"));
	}

	public static int solution(String s) {
		
		String[] arr = s.split("");
		Stack<String> stack;

		int cnt = 0;
		boolean flag = false;
		int idx = 0;
		String temp;
		for (int i = 0; i < arr.length; i++) { // 하나씩 빼서 넣기 
			stack = new Stack<>();
			for (int j = i; j < arr.length + i; j++) { // 순회 
				idx = j % arr.length;
				String arrIdx = arr[idx];
				
				if (arrIdx.equals("(") 
						|| arrIdx.equals("[")
						|| arrIdx.equals("{") ) {
					stack.push(arrIdx);
				}
				else {
					if (!stack.isEmpty()) {
						temp = stack.peek();
						switch(arrIdx) {
						case ")":
							if (temp.equals("(")) {
								stack.pop();
							}
							else
								stack.push(arrIdx);
							break;
						case "]":
							if (temp.equals("[")) {
								stack.pop();
							}
							else
								stack.push(arrIdx);
							break;
						case "}":
							if (temp.equals("{")) {
								stack.pop();
							}
							else
								stack.push(arrIdx);
							break;
						}
					}
					else
						stack.push(arrIdx);
				}
				
			}
			if (stack.isEmpty())
				cnt++;
		}
		
        return cnt;
    }
}
