import java.util.stream.IntStream;

public class lotto {

	public static void main(String[] args) {
		

	}
	
	public int[] solution(int[] lottos, int[] win_nums) {
        
		int zeroCnt = 0;
		int sameCnt = 0;

		for (int i = 0; i < lottos.length; i++) {
			if (IntStream.of(win_nums).anyMatch(num ->
					num == 0
					)) {
				zeroCnt++;
			}
			else if (IntStream.of(win_nums).anyMatch(num ->
					num == lottos[i]
					)) {
				sameCnt++;
			}
		}
		
		int bottom = 6;
		if (sameCnt > 1) {
			bottom = 7 - sameCnt;
		}
		
		int top = bottom;
		if (zeroCnt > 1) {
			top = 7 - zeroCnt - bottom;
		}
		
		return new int[]{top, bottom};
    }

}
