import java.util.Arrays;

public class CharacterCoord {

	public static void main(String[] args) {
		String[] input = {"down", "down", "down", "down", "down"};
		int[] b = {7,9};
		System.out.println(Arrays.toString(solution(input, b)));
		
	}
	
	public static int[] solution(String[] keyinput, int[] board) {
        
		int X = board[0] / 2;
		int Y = board[1] / 2;
		
		int curX = 0;
		int curY = 0;
		for (int i = 0; i < keyinput.length; i++) {
			switch(keyinput[i]) {
			case "up":
				if (curY < Y)
					curY++;
				break;
			case "down":
				if (curY > -Y)
					curY--;
				break;
			case "left":
				if (curX > -X)
					curX--;
				break;
			case "right":
				if (curX < X)
					curX++;
				break;
			}
		}
		
		int[] result = {curX, curY};
		return result;
    }

}
