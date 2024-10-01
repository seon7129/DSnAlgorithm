import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Escape {
	
	private static int ROW, COL;
	private static char[][] map;
	
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	
	private static Queue<int[]> hedgehog = new LinkedList<>();
	private static Queue<int[]> flood = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine(), " ");
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		map = new char[ROW][COL];
		
		for (int i = 0; i < ROW; i++) {
			String str = in.readLine();
			for (int j = 0; j < COL; j++) {
				
				char val = str.charAt(j);
				switch (val) {
				case 'S':
					hedgehog.add(new int[] {i,j,0}); // x,y,cnt
					break;
				case '*':
					flood.add(new int[] {i,j});
					break;
				}
				map[i][j] = val;
			}
		}
		
		int result = bfs();
		if (result == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(result);
		}
	}

	private static int bfs() {
		
		while (!hedgehog.isEmpty()) {
			
			// 다음에 홍수가 범람할 곳 체크하기
			int len = flood.size();
			for (int f = 0; f < len; f++) {
				
				int[] curF = flood.poll();
				int curFX = curF[0];
				int curFY = curF[1];
				
				for (int i = 0; i < 4; i++) {
					
					int fX = curFX + dx[i];
					int fY = curFY + dy[i];
					
					if (fX < 0 || fX >= ROW || fY < 0 || fY >= COL)
						continue;
					
					if (map[fX][fY] == '.') {
						flood.add(new int[] {fX, fY});
						map[fX][fY] = '*';
					}
					
				}
				
			}

			// 고슴도치 이동 
			len = hedgehog.size();
			for (int h = 0; h < len; h++) {
				
				int[] cur = hedgehog.poll();
				int curX = cur[0];
				int curY = cur[1];
				int curCnt = cur[2];
				
				for (int i = 0; i < 4; i++) {
					
					int newX = curX + dx[i];
					int newY = curY + dy[i];
					
					if (newX < 0 || newX >= ROW || newY < 0 || newY >= COL)
						continue;
					
					if (map[newX][newY] == 'D') {
						return curCnt + 1;
					}
					
					if (map[newX][newY] == '.') {
					    hedgehog.add(new int[] {newX, newY, curCnt + 1});
					    map[newX][newY] = 'S';  // 방문한 위치를 'S'로 표시
					}

				}
				
//				for (char[] m: map)
//					System.out.println(Arrays.toString(m));
			}
			
		}
		
		return -1;
		
	}

}
