import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FailureRate {
	
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 1};
		int[] r = solution(N, stages);
	}

	public static int[] solution(int N, int[] stages) {
        
		// 분모 
		int[] arrA = new int[N];
		// 분자 
		int[] arrB = new int[N];
		
		for (int i = 0; i < stages.length; i++) {
			for (int idx = 0; idx < N; idx++) {
				if (stages[i] >= idx+1) {
					//System.out.println("i "+ i + " stage-i " + stages[i] + " idx+1 " + (idx + 1));
					arrA[idx]++;
				}
				if(stages[i] == idx+1) {
					arrB[idx]++;
				}
			}
		}
		// 스테이지에 도달한 유저가 없는 경우
		for (int idx = 0; idx < N; idx++) {
			if (arrA[idx] == 0)
				arrA[idx] = -1;
		}
		
		
		//System.out.println(Arrays.toString(arrA));
		//System.out.println(Arrays.toString(arrB));
		
		// TreeMap은 Key에 대해 정렬함! 근데 중복 안됨..
		TreeMap<Integer, Double> cal = new TreeMap<>();
		double div = 0;
		for (int i = 0; i < N; i++) {
			if (arrA[i] == -1)
				div = 0;
			else
				div = (double) arrB[i] / (double) arrA[i];
			cal.put(i+1,div);
		}
		
		 // value로 정렬하기 위해 List로 변환
        List<Entry<Integer, Double>> list = new ArrayList<>(cal.entrySet());

        // Comparator를 사용하여 value 기준으로 내림차순 정렬
        Collections.sort(list, new Comparator<Entry<Integer, Double>>() {

			@Override
			public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
        });
        
		// result
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			result[i] = list.get(i).getKey();
			//System.out.println(list.get(i).getValue() +" -> "+ result[i]);
		
		}
		
		return result;
    }

}
