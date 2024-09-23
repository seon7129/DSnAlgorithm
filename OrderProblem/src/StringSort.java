import java.util.Arrays;

public class StringSort {

	public static void main(String[] args) {
		String[] s = {"abce", "abcd", "cdx"};
		System.out.println(Arrays.toString(solution(s, 2)));

	}

	public static String[] solution(String[] strings, int n) {

		Arrays.sort(strings, (s1,s2) -> {
			 int charCompare = Character.compare(s1.charAt(n), s2.charAt(n));
			 if (charCompare != 0) {
				 return charCompare;
			 }
			 else {
				 return s1.compareTo(s2);
			 }
		});
		
        return strings;
    }
}
