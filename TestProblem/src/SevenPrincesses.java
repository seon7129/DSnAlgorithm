import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SevenPrincesses {
	
	private static char[] map;
	private static boolean[] select;
	private static int result;

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		result = 0;
		
		select = new boolean[25];
		map = new char[25];
		for (int i = 0; i < 5; i++) {
			String[] split = in.readLine().split("");
			for (int j = 0; j < 5; j++) {
				map[i*5+j] = split[j].charAt(0);
			}
		}
		
		comb(0,0); // 7개의 숫자 조합 구하기
		
		System.out.println(result);
	}

	// 7개의 숫자 조합 구하기 (0~24)
	private static void comb(int idx, int cnt) {
		
		if (cnt == 7) {
			// 구한 숫자들에 S가 4개 이상인지 판단
			if (isMore4S()) {
				// 인접한지 판단
				if (isAdj()) {
					result++;
				}
			}
		}
		
		for (int i = idx; i < 25; i++) {
			if (select[i])
				continue;
			
			select[i] = true;
			comb(i, cnt+1);
			select[i] = false;
		}
		
	}
	

	// 구한 숫자들에 S가 4개 이상인지 판단
	private static boolean isMore4S() {

		int cnt = 0;
		
		for (int i = 0; i < 25; i++) {
			if (select[i]) {
				if (map[i] == 'S') {
					cnt++;
				}
			}
		}

		if (cnt >= 4)
			return true;
		
		return false;
	}
	

	// 인접한지 판단
	private static boolean isAdj() {
	    
	    boolean[][] tempMap = new boolean[5][5];
	    for (int i = 0; i < 25; i++) {
	        tempMap[i/5][i%5] = select[i];
	    }
	    
	    // BFS 초기화
	    Queue<int[]> queue = new ArrayDeque<>();
	    boolean[][] visited = new boolean[5][5];
	    
	    // 시작점 찾기 (select에서 true인 첫 번째 위치)
	    for (int i = 0; i < 5; i++) {
	        for (int j = 0; j < 5; j++) {
	            if (tempMap[i][j]) {
	                queue.add(new int[]{i, j});
	                visited[i][j] = true;
	                break;
	            }
	        }
	        if (!queue.isEmpty()) break;
	    }
	    
	    // BFS 수행
	    int connectedCount = 0;
	    while (!queue.isEmpty()) {
	        int[] current = queue.poll();
	        int x = current[0];
	        int y = current[1];
	        connectedCount++;

	        // 네 방향 탐색
	        int[] dx = {-1, 1, 0, 0};
	        int[] dy = {0, 0, -1, 1};
	        
	        for (int d = 0; d < 4; d++) {
	            int nx = x + dx[d];
	            int ny = y + dy[d];
	            
	            // 범위 내에 있고, 선택된 위치이며, 방문하지 않은 경우
	            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && tempMap[nx][ny] && !visited[nx][ny]) {
	                queue.add(new int[]{nx, ny});
	                visited[nx][ny] = true;
	            }
	        }
	    }
	    
	    return connectedCount == 7;
	}


}
