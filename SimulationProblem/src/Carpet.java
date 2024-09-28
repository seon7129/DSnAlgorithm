import java.util.Arrays;

public class Carpet {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10,2))); // 3,8

	}
	
	public static int[] solution(int brown, int yellow) {
		
		int brownXY = (brown - 4) / 2;
        
		int yellowX = yellow;
		int yellowY = 1;
		while (brownXY != yellowX + yellowY) {
			while (true) {
				yellowY++;
				if (yellow % yellowY == 0) {
					yellowX = yellow / yellowY;
					break;
				}
			}
		}
		
		int[] result = {yellowX+2, yellowY+2};
		return result;
    }

}
