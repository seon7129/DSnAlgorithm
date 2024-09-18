import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Delivery {
	
	public static void main(String[] args) {
		
		//int[][] r = {{1,2,0},{1,2,1},{2,3,1},{3,4,1}};
		int[][] r = {{1,2,4},{1,3,1},{3,4,1},{4,2,1}, {2,5,1}};
		System.out.println(solution(5, r, 4)); // 5
	}
	
	// bfs, dfs로 풀어보다가 계속 실패.. 다익스트라로 풉니다..
	// 근데 계속 실패.. 런타임 에러..
	private static int[][] map;
	private static int n,k;
	
	public static int solution(int N, int[][] road, int K) {
        
		map = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
            // 이동 시간이 제일 작은 도로의 정보를 저장하기 위해 큰 값으로 초기화
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
		n = N;
		k = K;
		
		for (int i = 0; i < N; i++) {
			int a = road[i][0];
			int b = road[i][1];
			int w = road[i][2];
			
			// 도로가 여러개 일 수 있음. 가장 w가 작은 도로를 저장
			w = Math.min(map[a][b], w);
			map[a][b] = w;
			map[b][a] = w;
			
		}
		
		
		return dijkstra();
    }

	private static int dijkstra() {
		
		int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
		//boolean[] visited = new boolean[n + 1];
        
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1,0));
        dist[1] = 0;
        
        while (!queue.isEmpty()) {
        	Node cur = queue.poll();
        	
        	for (int i = 2; i <= n; i++) {
        		if (map[cur.v][i] != Integer.MAX_VALUE) {
        			int next = map[cur.v][i];
        			
        			if (dist[i] > dist[cur.v] + next) {
        				dist[i] = dist[cur.v] + next;
        				queue.offer(new Node(i, dist[i]));
        			}
        		}
        	}
        }

        
        // K 이하의 거리인 노드 수 세기
        int count = 0;
        for (int d : dist) {
            if (d <= k) {
                count++;
            }
        }
        return count;
	}

	static class Node implements Comparable<Node> {
    
	    // 정점, 정점으로 이동하는 시간
	    int v, w;
	    
	    Node(int v, int w) {
	        this.v = v;
	        this.w = w;
	    }
	    
	    // 이동 시간을 오름차순으로 정렬
	    @Override
	    public int compareTo(Node o) {
	        return Integer.compare(this.w, o.w);
	    }
	    
	}
}
