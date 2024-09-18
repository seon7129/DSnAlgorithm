
public class Fatigability {

	public static void main(String[] args) {
		int[][] d = {{80,20},{50,40},{30,10}};
		System.out.println(solution(80,d));
	}

	private static boolean[] visited;
	private static int[][] dungeon;
	private static int dCnt, result;
	
	public static int solution(int k, int[][] dungeons) {
		
		dCnt = dungeons.length;
		dungeon = dungeons;
		visited = new boolean[dCnt];

		result = 0;
		for (int i = 0; i < dCnt; i++) {
			if (dungeons[i][0] <= k) {
				visited[i] = true;
				dfs(dungeons[i][0], 1, k - dungeons[i][1]);
				visited[i] = false;
			}
		}
        return result;
    }

	private static void dfs(int start, int count, int k) {
		
		result = Math.max(result, count);
		
		for (int i = 0; i < dCnt; i++) {
			if (!visited[i] && dungeon[i][0] <= k) {
				visited[i] = true;
				dfs(dungeon[i][0], count+1 , k - dungeon[i][1]);
				visited[i] = false;
			}
		}
		
	}
}
