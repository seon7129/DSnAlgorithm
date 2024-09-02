import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class GameMapShortestPath {

	public static void main(String[] args) {
		int[][] map1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int[][] map2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		
		System.out.println(solution(map1));
	}

	private static int[][] map;
	private static boolean[][] visited;
	private static int N,M;
	private static int minResult;
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	
	public static int solution(int[][] maps) {
		map = maps;
		N = maps.length;
		M = maps[0].length;
		visited = new boolean[N][M];
		minResult = Integer.MAX_VALUE;
		
		//dfs(0,0,1); // 15
//		if (minResult == Integer.MAX_VALUE)
//			minResult = -1;
		
		minResult = bfs(0,0);
        return minResult;
    }
	
	private static int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y, 1});
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int curCnt = current[2];
            
            // 목표 지점에 도달한 경우
            if (curX == N - 1 && curY == M - 1) {
                return curCnt;
            }
            
            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                
                if (newX >= 0 && newX < N && newY >= 0 && newY < M && !visited[newX][newY] && map[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    queue.offer(new int[] {newX, newY, curCnt + 1});
                }
            }
        }
        
        // 도달할 수 없는 경우
        return -1;
    }
	
	private static void dfs(int x, int y, int cnt) {
		
		Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {x, y, cnt});
        visited[x][y] = true;
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int curX = current[0];
            int curY = current[1];
            int curCnt = current[2];
            
            // 목표 지점에 도달한 경우
            if (curX == N - 1 && curY == M - 1) {
                minResult = Math.min(minResult, curCnt);
                continue;
            }
            
            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                
                if (newX >= 0 && newX < N && newY >= 0 && newY < M && !visited[newX][newY] && map[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    stack.push(new int[] {newX, newY, curCnt + 1});
                }
            }
        }
		
	}
	
}
