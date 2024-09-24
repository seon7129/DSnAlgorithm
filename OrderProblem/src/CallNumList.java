import java.util.Arrays;
import java.util.Comparator;

public class CallNumList {

	public static void main(String[] args) {
		String[] s = {"12","123","1235","567","88"};
		System.out.println(solution(s));

	}

	public static boolean solution(String[] phone_book) {
		
		// 짧은 string이 앞에 오도록 정렬 -> 효율성 3,4 타임아웃
//		Arrays.sort(phone_book, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return Integer.compare(s1.length(), s2.length());
//            }
//        });
		// 사전순 정렬 
		Arrays.sort(phone_book);
		
		System.out.println(Arrays.toString(phone_book));
		
		boolean result = true;
//		for (int i = 0; i < phone_book.length; i++) {
//			if (result == false)
//				break;
//			for (int j = i + 1; j < phone_book.length; j++) {
//				if (phone_book[j].startsWith(phone_book[i])) {
//					result = false;
//					break;
//				}
//			}
//		}
		
		for (int i = 0; i < phone_book.length-1; i++) {
			if (phone_book[i+1].startsWith(phone_book[i])) {
				result = false;
				break;
			}
		}
		
        return result;
    }
}
