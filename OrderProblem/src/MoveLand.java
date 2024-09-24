import java.util.Arrays;
import java.util.Stack;

public class MoveLand {

	public static void main(String[] args) {
		int[][] land1 = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
		int[][] land2 = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
		
//		System.out.println(solution(land1,3)); // 15
		System.out.println(solution(land2,1)); // 18
	}

	private static boolean[][] visited;
	private static int[][] lands;
	private static int N, H;
	private static int result;
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int solution(int[][] land, int height) {
		
		// (0,0)부터 visited 구역 만들기
		// 현재에서 최대한의 구역을 찾으면, 해당 범위 내에서 visited에 포함x 구역 중 가장 차가 작은 곳 찾기
		// 해당 차를 result에 저장
		// 해당 위치부터 다시 최대한의 구역 찾기
		// (n-1, n-1)까지 visited가 모두 true이면 종료 
		
		N = land.length;
		H = height;
		visited = new boolean[N][N];
		lands = land;
		
		result = 0;
		Point p = new Point(0,0);
		while (true) {
			
			if (p == null)
				break;
			
			dfs(p);
			p = findMinLoc(p);
			
//			for(boolean[] b : visited) {
//				System.out.println(Arrays.toString(b));
//			}
		}
		
        return result;
    }

	// 외각선을 따라가면서 가장 낮은 차 구하기
	private static Point findMinLoc(Point p) {
	    int minDiff = Integer.MAX_VALUE; // 최소 높이 차이
	    Point minPoint = null; // 최소 차이인 지점
	    
	    // 모든 방문한 지점에서 주변을 탐색하여 방문하지 않은 지점 중에서 최소 차이 찾기
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            if (visited[i][j]) { // 방문한 지점에서만 탐색
	                for (int d = 0; d < 4; d++) {
	                    int nx = i + dx[d];
	                    int ny = j + dy[d];
	                    
	                    // 인접한 지점이 유효하고 방문하지 않은 지점이면
	                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
	                        int diff = Math.abs(lands[i][j] - lands[nx][ny]);
	                        
	                        // 최소 차이를 찾으면 갱신
	                        if (diff < minDiff) {
	                            minDiff = diff;
	                            minPoint = new Point(nx, ny);
	                        }
	                    }
	                }
	            }
	        }
	    }
	    
	    // 최소 차이인 지점으로 이동하며 result 값 갱신
	    if (minPoint != null) {
	        result += minDiff;
//	        System.out.println("x y " + minPoint.x + " " + minPoint.y);
//	        System.out.println("result minDiff " + result + " " + minDiff);
	        
	    }
	    
	    return minPoint;
	}


	private static void dfs(Point p) {
	    Stack<Point> stack = new Stack<>();
	    stack.push(p);

	    while (!stack.isEmpty()) { // 스택이 비워질 때까지 탐색
	        Point cur = stack.pop();
	        int curX = cur.x;
	        int curY = cur.y;

	        if (curX >= 0 && curX < N && curY >= 0 && curY < N && !visited[curX][curY]) {
	            visited[curX][curY] = true; // 방문 처리

	            // 상하좌우 탐색
	            for (int i = 0; i < 4; i++) {
	                int nx = curX + dx[i];
	                int ny = curY + dy[i];

	                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
	                    // 높이 차이가 H 이하인 경우에만 이동 가능
	                    if (Math.abs(lands[curX][curY] - lands[nx][ny]) <= H) {
	                        stack.push(new Point(nx, ny));
	                    }
	                }
	            }
	        }
	    }
	}

}
