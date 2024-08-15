import java.util.Stack;

public class PicktheDoll {
	
	public static void main(String args[]) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.print(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		
		Stack<Integer> stack = new Stack<>(); // 뽑은 인형을 저장할 stack
		
		int result = 0; // 사라진 인형의 개수 저장 
		int current = 0; // 현재 탐색위치의 board값
		
		// moves에 들어있는 곳을 탐색한다 
		for (int i = 0 ; i < moves.length; i++) {
			current = 0;
			// moves를 통해 col좌표는 정해졌으니 row좌표를 위에서부터 탐색하면서 값이 0이 아닐때를 찾는다 
			for (int j = 0; j < board.length; j++) {
				current = board[j][moves[i]-1];
				// 만약 인형이 있을 때 
				if (current != 0) {
					board[j][moves[i]-1] = 0;
					//System.out.println("in current: "+current);
					// 스택이 비어있지 않고 맨 위의 값이 현재 값과 같다면 삭제
					if (!stack.isEmpty() && current == stack.peek()) {
						stack.pop();
						result += 2;
					}
					else  // 아니면 스택에 저장 
						stack.push(current);
					
					break; // 다음 moves로 
				}
			}
			// 모두 다 0이면 아무일도 일어나지 않는다 
		}

        return result;
    }
	
}
