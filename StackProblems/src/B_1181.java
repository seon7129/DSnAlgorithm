import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class B_1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		sc.nextLine(); // 엔터 입력 방지
		
		Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 길이 비교
                int lengthComparison = Integer.compare(s1.length(), s2.length());
                if (lengthComparison != 0) {
                    return lengthComparison;
                }
                // 길이가 같으면 알파벳 순으로 비교
                return s1.compareTo(s2);
            }
        });
		
		for (int i = 0; i < len; i++) {
			set.add(sc.next());
			//System.out.println(set);
		}
		
		for (String s : set) {
			System.out.println(s);
		}
	}

}
