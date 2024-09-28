import java.util.Arrays;

public class BinaryTransfer {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("110010101001"))); // 3,8

	}
	
	public static int[] solution(String s) {

		int round = 0;
		int zeroCnt = 0;
		
		while (!s.equals("1")) {
			zeroCnt += s.length() - s.replace("0", "").length();
			String newNum = s.replace("0", "");
			s = Integer.toBinaryString(newNum.length()).toString();
			round++;
		}
		
        int[] result = {round, zeroCnt};
        return result;
    }
	
	

}
