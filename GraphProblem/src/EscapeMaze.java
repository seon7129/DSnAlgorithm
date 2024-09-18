import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class EscapeMaze {
	
	public static void main(String[] args) {
		String[] map = {"SOOL","XXXO","OOOO","OXXX","OOOE"};
		System.out.println(solution(map));
		
	}
	
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static Point start;
	private static Point lever;
	private static Point end;
	private static int[][] map;
	private static int N,M;
	
	public static int solution(String[] maps) {
        
		N = maps.length;
		M = maps[0].length();
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] split = maps[i].split("");
			for (int j = 0; j < M; j++) {
				if (split[j].equals("S")) {
					start = new Point(i,j);
					map[i][j] = 0;
				}else if (split[j].equals("L")) {
					lever = new Point(i,j);
					map[i][j] = 0;
				}else if (split[j].equals("E")) {
					end = new Point(i,j);
					map[i][j] = 0;
				}else if (split[j].equals("X")) {
					map[i][j] = 1;
				}else {
					map[i][j] = 0;
				}
			}
		}
		
		int result = 0;
		int temp = bfs(start.x, start.y ,lever.x, lever.y);
		if (temp == -1) return -1;
		result += temp;
		
		temp = bfs(lever.x, lever.y, end.x, end.y);
		if (temp == -1) return -1;
		result += temp;
		
        return result;
    }
	
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};

	private static int bfs(int x, int y, int ex, int ey) {

		int cnt = 0;
		
		Queue<Point> queue = new ArrayDeque<>();
		int[][] dist = new int[N][M];
		for (int[] row : dist) {
            Arrays.fill(row, -1);
        }
		
		queue.add(new Point(x,y));
		dist[x][y] = 0;
		cnt++;
		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int curX = cur.x;
			int curY = cur.y;
			int curDist = dist[curX][curY];
			
			if (curX == ex && curY == ey)
				return curDist;
				
			for (int i = 0; i < 4; i++) {
				int newX = curX + dx[i];
				int newY = curY + dy[i];
				
				if (newX >= 0 && newX < N && newY >= 0 && newY < M
						&& map[newX][newY] == 0 && dist[newX][newY] == -1) {
					queue.add(new Point(newX,newY));
					dist[newX][newY] = curDist + 1;
				}
			}
		}
		return -1;
	}
}
