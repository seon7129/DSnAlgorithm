
public class VisitLength {
	
	public static void main(String args[]) {
	
		int result = 0;
		String dirs = "ULURRDLLU";
		result = solution(dirs);
		System.out.println(result);
	}
	
	
	public static int solution(String dirs) {
       
		int len = dirs.length();
		String[] control = dirs.split("");
		// -5 ~ 5 -> 0 ~ 10
		boolean[][][] visitedX = new boolean[11][11][11];
		boolean[][][] visitedY = new boolean[11][11][11];
		
		int curX = 5;
		int curY = 5;
		
		int cnt = 0;
		
		for (int i = 0; i < len; i++) {
			switch (control[i]) {
			case "U" :
				if (curY < 10) {
					if (visitedY[curX][curY][curY+1] == false) {
						visitedY[curX][curY][curY+1] = true;
						visitedY[curX][curY+1][curY] = true;
						cnt++;
					}
					curY++;
				}
				break;
			case "D" :
				if (curY > 0) {
					if (visitedY[curX][curY][curY-1] == false) {
						visitedY[curX][curY][curY-1] = true;
						visitedY[curX][curY-1][curY] = true;
						cnt++;
					}
					curY--;
				}
				break;
			case "R" :
				if (curX < 10) {
					if (visitedX[curY][curX][curX+1] == false) {
						visitedX[curY][curX][curX+1] = true;
						visitedX[curY][curX+1][curX] = true;
						cnt++;
					}
					curX++;
				}
				break;
			case "L" :
				if (curX > 0) {
					if (visitedX[curY][curX][curX-1] == false) {
						visitedX[curY][curX][curX-1] = true;
						visitedX[curY][curX-1][curX] = true;
						cnt++;
					}
					curX--;
				}
				break;

			}
			//System.out.println(curX + "," + curY);
		}
		
		return cnt;
    }
}
