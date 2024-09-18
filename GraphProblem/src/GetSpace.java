import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class GetSpace {

	private static int M,N,K;
	private static int map[][];
	private static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			// 왼하 -> 왼위, 오상 -> 오하
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			for (int j = ly; j < ry; j++) {
				for (int k = lx; k < rx; k++) {
					map[j][k] = 1;
				}
			}
		}
		
//		for (int[] m : map) {
//			System.out.println(Arrays.toString(m));
//		}
		int result = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    int cnt = bfs(i, j);
                    list.add(cnt);
                    result++;
                }
            }
        }
		
		System.out.println(result);
		list.sort(Comparator.naturalOrder());
		for (int num : list) {
			System.out.print(num + " ");
		}
		
	}

	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	
	private static int bfs(int x, int y) {

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int newX = curX + dx[i];
				int newY = curY + dy[i];
				
				if (newX >= 0 && newX < M && newY >= 0 && newY < N
						&& map[newX][newY] == 0 && !visited[newX][newY]) {
					queue.add(new int[] {newX,newY});
					visited[newX][newY] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
