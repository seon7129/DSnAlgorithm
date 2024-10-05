import java.util.Arrays;

public class IntegerTriangle {

	public static void main(String[] args) {
		int[][] tri = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(tri)); // 30

	}

	public static int solution(int[][] triangle) {
        
		int len1 = triangle.length;
		for (int i = len1-2; i >= 0; i--) { // 아래부터 위로 올라가면서 
			int len2 = triangle[i].length;
			for (int j = 0; j < len2; j++) { // 왼쪽부터 오른쪽으로 
				triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
			}
		}
		
        return triangle[0][0];
    }
}
