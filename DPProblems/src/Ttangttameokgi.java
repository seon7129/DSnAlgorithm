
public class Ttangttameokgi {

	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		System.out.println(solution(land));

	}

	public static int solution(int[][] land) {
		
        int len1 = land.length;
        for (int i = 1; i < len1; i++) {
        	for (int j = 0; j < 4; j++) {
        		land[i][j] += Math.max(land[i-1][(j+1)%4], Math.max(land[i-1][(j+2)%4], land[i-1][(j+3)%4]));
        	}
        }

        int result = land[len1-1][0];
        for (int i = 1; i < 4; i++) {
        	result = Math.max(result, land[len1-1][i]);
        }
        return result; // land[land.length-1]중에서 가장 큰 값 
    }
}
