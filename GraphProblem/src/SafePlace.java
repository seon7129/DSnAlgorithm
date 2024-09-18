import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SafePlace {

	private static int N;
	private static int[][] orimap;
	private static int[][] map;
	private static int[] heights = new int[101];
	private static boolean[][] visited;
	private static int result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		orimap = new int[N][N];
		
		boolean checkSame = true;
		int sameNum = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (i == 0 && j == 0)
					sameNum = num;
				orimap[i][j] = num;
				heights[num]++;
				if (num != sameNum)
					checkSame = false;
			}
		}
		
		if (checkSame == true) {
			System.out.println(1);
			return;
		}
		
		result = Integer.MIN_VALUE;
		
		for (int h = 1; h < 101; h++) {
			if (heights[h] != 0) {
				visited = new boolean[N][N];
				map = new int[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (orimap[i][j] <= h) {
							map[i][j] = 0; // 물에 잠김
						}else {
							map[i][j] = 1; // 땅
						}
					}
				}

				int safeSpace = 0;
	            
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < N; j++) {
	                    if (map[i][j] == 1 && !visited[i][j]) {
	                        bfs(i, j);
	                        safeSpace++;
	                    }
	                }
	            }
	            
	            result = Math.max(result, safeSpace);
//				System.out.println("h: " + h + " safeSpace: " + safeSpace);
			}
		}
		
		System.out.println(result);
	}
	
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	
	// 공간 만들기 문제와 비슷? 분할정복으로 하려고 했는데 dfs, bfs를 사용해야함..
	private static void bfs(int x, int y) {

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int newX = curX + dx[i];
				int newY = curY + dy[i];
				
				if (newX >= 0 && newX < N && newY >= 0 && newY < N
						&& map[newX][newY] == 1 && !visited[newX][newY]) {
					queue.add(new int[] {newX,newY});
					visited[newX][newY] = true;
				}
			}
		}
		
	}

	
}

