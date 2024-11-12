import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CheckDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Point{
		int x;
		int y;
		int move;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.move = 2;
		}
		
		Point(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}
	}
	
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	
	public int[] solution(String[][] places) {
        
		int len = places.length;
		int[] result = new int[len];
		
		for (int tc = 0; tc < len; tc++) {
			Set<Point> savedP = new HashSet<>();
			char[][] room = new char[5][5];
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					char element = places[tc][i].charAt(j);
					if (element == 'P') {
						savedP.add(new Point(i,j));
					}
					room[i][j] = element;
				}
			}
			
			result[tc] = 1; // 거리 기준을 모두 만족한다고 가정
            for (Point p : savedP) {
                if (!checkDistance(room, p)) { // 거리 기준을 위반하면
                    result[tc] = 0; // 실패로 설정
                    break;
                }
            }
			
			
		}

		return result;
    }

	private boolean checkDistance(char[][] room, Point p) {
		
		boolean[][] visited = new boolean[5][5];
		Stack<Point> stack = new Stack<>();
		stack.add(p);
		visited[p.x][p.y] = true;
		
		while (!stack.isEmpty()) {
			
			Point cur = stack.pop();
			int curX = cur.x;
			int curY = cur.y;
			int curMove = cur.move;
			
			if (curMove == 0)
				continue;
			
			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				
				if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5 
						|| room[nextX][nextY] == 'X' || visited[nextX][nextY])
					continue;
				
				if (room[nextX][nextY] == 'P') {
					System.out.println(nextX + " " + nextY);
					return false;
				}
				
				stack.add(new Point(nextX, nextY, curMove - 1));
				visited[nextX][nextY] = true;
			}
		}
		
		
		return true;
	}

}
