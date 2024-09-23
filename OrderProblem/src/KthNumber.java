import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthNumber {

	public static void main(String[] args) {
		int[] arr = {1, 5, 12, 6, 63, 37, 4};
		int[][] com = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(solution(arr, com)));
	}

	public static int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < commands.length; i++) {
        	int[] temp = commands[i];
        	int len = temp[1]-temp[0]+1;
        	int[] tempArr = new int[len];
        	for (int j = 0; j < len; j++) {
        		tempArr[j] = array[temp[0]+j-1];
        	}
        	Arrays.sort(tempArr);
            result.add(tempArr[temp[2] - 1]);
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}
