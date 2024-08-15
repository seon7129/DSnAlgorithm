import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EditTable {
	
	public static void main(String args[]) {
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		System.out.print(solution(n,k,cmd)); // "OOOOXOOO"
	}

	public static String solution(int n, int k, String[] cmd) {
		
		Stack<Integer> stack = new Stack<>();
		char[] result = new char[n];
		Arrays.fill(result,'O');
		int current = k;
		int lastIdx = n-1;
		
		List<Command> newCmd = compress(cmd);
		
		
		int x = 0;
		for (Command s : newCmd) {
			switch (s.type) {
			case 'U': // 0쪽으로 이동 
				x = s.val;
				while (x != 0 && current != 0) {
					if (result[--current] == 'O') {
						x--;
					}
				}
				break;
			case 'D': // n-1 쪽으로 이동 
				x = s.val;
				while (x != 0 && current != n-1) {
					if (result[++current] == 'O') {
						x--;
					}
				}
				break;
			case 'C': // 삭제 
				stack.push(current);
				result[current] = 'X';
				// 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다.
				//단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
				if (current == lastIdx) {
					// lastIdx 업데이트
					while (result[--current] == 'X');
					lastIdx = current;
				}
				else {
					while (result[++current] == 'X');
				}
				break;
			case 'Z': // 복구 
				int pop = stack.pop();
				result[pop] = 'O';
				lastIdx = Math.max(lastIdx, pop); // lastIdx 업데이트 
				break;
			}
		}
		
		return new String(result);
	}
	
	private static List<Command> compress(String[] cmd) {
		int flag = 0;
		List<Command> result = new ArrayList<>();
		int cnt = 0;
		for (String s : cmd) {
			switch(s.charAt(0)) {
			case 'U':
				flag = 1;
				cnt -= Integer.parseInt(s.substring(2));
				break;
			case 'D':
				flag = 2;
				cnt += Integer.parseInt(s.substring(2));
				break;
			case 'C':
				flag = 3;
				break;
			case 'Z':
				flag = 4;
				break;
			}
			
			if (flag == 3) {
				if (cnt < 0) {
					result.add(new Command('U',cnt * -1));
				}
				else if (cnt > 0) {
					result.add(new Command('D',cnt));
				}
				
				result.add(new Command('C',0));
				cnt = 0;
			}
			
			if (flag == 4) {
				if (cnt < 0) {
					result.add(new Command('U',cnt * -1));
				}
				else if (cnt > 0) {
					result.add(new Command('D',cnt));
				}
				
				result.add(new Command('Z',0));
				cnt = 0;
			}
			
		}
		// 만약 남은 cnt가 있을 경우 
		if (cnt < 0) {
			result.add(new Command('U',cnt * -1));
		}
		else if (cnt > 0) {
			result.add(new Command('D',cnt));
		}
		
		return result;
	}
	
	static class Command {
		char type;
		int val;
		
		public Command(char type, int val) {
			this.type = type;
			this.val = val;
		}
	}

}
