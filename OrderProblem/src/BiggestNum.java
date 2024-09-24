import java.util.Arrays;
import java.util.Comparator;

public class BiggestNum {

	
	public static void main (String[] args) {
        
		int[] arr = {979 ,97, 978, 818, 81, 817};
		System.out.println(solution(arr));
		
    }
	
	public static Comparator<Integer> customComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            // 각 숫자를 문자열로 변환
            String strA = String.valueOf(a);
            String strB = String.valueOf(b);
            
            // 문자열을 자리별로 비교
            int minLength = Math.min(strA.length(), strB.length());

            // 자리별 비교
            for (int i = 0; i < minLength; i++) {
                if (strA.charAt(i) != strB.charAt(i)) {
                    // 다른 자리가 발견되면 그 자리를 기준으로 비교 (내림차순)
                    return Character.compare(strB.charAt(i), strA.charAt(i));
                }
            }

            // 자리별로 모두 같다면, 남은 길이와 첫 자리 비교
            if (strA.length() != strB.length()) {
                // A가 더 길다면
                if (strA.length() > strB.length()) {
                    char firstChar = strA.charAt(0);
                    for (int i = minLength; i < strA.length(); i++) {
                        if (strA.charAt(i) != firstChar) {
                            return Character.compare(firstChar, strA.charAt(i));
                        }
                    }
                    return -1; // A가 더 길고 모두 동일
                } else {
                    // B가 더 길다면
                    char firstChar = strB.charAt(0);
                    for (int i = minLength; i < strB.length(); i++) {
                        if (strB.charAt(i) != firstChar) {
                            return Character.compare(strB.charAt(i), firstChar);
                        }
                    }
                    return 1; // B가 더 길고 모두 동일
                }
            }

            // 길이도 같고 모든 자리도 같다면 동일한 숫자
            return 0;
        }
    };
	
	// 숫자의 자리별로 비교하는 커스텀 Comparator
    public static Comparator<Integer> customComparator2 = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            // 각 숫자를 문자열로 변환
            String strA = String.valueOf(a);
            String strB = String.valueOf(b);
            
            // 문자열을 자리별로 비교
            int minLength = Math.min(strA.length(), strB.length());
            
            // 자리별 비교
            for (int i = 0; i < minLength; i++) {
                if (strA.charAt(i) != strB.charAt(i)) {
                    // 다른 자리가 발견되면 그 자리를 기준으로 비교 (내림차순) // 양수인 경우 자리 변경 
                    return Character.compare(strB.charAt(i), strA.charAt(i));
                }
            }
            // 1 11 111 110 101 10 100 1000 0
            // 979 97 978 818 81 817
            // 545 54 45 454
            // 자리별로 모두 같다면, 길이가 긴 쪽의 남은 자리를 비교
//            if (strA.length() != strB.length()) {
//                if (strA.length() > strB.length()) {
//                    // A가 더 길다면, A의 남은 자리들을 마지막으로 비교된 자리와 비교
//                    char nextChar = strA.charAt(minLength);
//                    if (strA.charAt(minLength - 1) == nextChar)
//                    	return Integer.compare(strA.length(), strB.length()); // 짧은게 앞 
////                    	return Character.compare(nextChar, strA.charAt(minLength - 1));
//                    else {
//                    	if (strA.charAt(0) == nextChar)
//                    		return Integer.compare(strB.length(), strA.length()); // 긴게 앞 
//                    	else
//                    		return Character.compare(strA.charAt(0), nextChar);
////                    		return Character.compare(strA.charAt(minLength - 1), nextChar);
//                    }
//                    	
//                } else {
//                    // B가 더 길다면, B의 남은 자리들을 마지막으로 비교된 자리와 비교
//                    char nextChar = strB.charAt(minLength);
//                    if (strB.charAt(minLength - 1) == nextChar)
//                    	return Integer.compare(strB.length(), strA.length()); // 짧은게 앞 
////                    	return Character.compare(strB.charAt(minLength - 1), nextChar);
//                    else {
//                    	if (strB.charAt(0) == nextChar)
//                    		return Integer.compare(strA.length(), strB.length()); // 긴게 앞 
//                    	else
//                    		return Character.compare(nextChar, strB.charAt(0));
////                    		return Character.compare(nextChar, strB.charAt(minLength - 1));
//                    }
//                    	
//                }
//            }
            
         // 자리별로 모두 같다면, 길이가 긴 쪽의 남은 자리를 비교
            if (strA.length() != strB.length()) {
                // A가 더 길다면
                if (strA.length() > strB.length()) {
                    for (int i = minLength; i < strA.length(); i++) {
                        char nextChar = strA.charAt(i);
                        // 다음 자리가 이전 자리와 다를 경우 그 값을 비교
                        if (strA.charAt(0) != nextChar) {
                            return Character.compare(strA.charAt(0), nextChar);
                        }
                    }
                    return Integer.compare(strB.length(), strA.length()); // 긴게 앞 
                }
                // B가 더 길다면
                else {
                    for (int i = minLength; i < strB.length(); i++) {
                        char nextChar = strB.charAt(i);
                        // 다음 자리가 이전 자리와 다를 경우 그 값을 비교
                        if (strB.charAt(0) != nextChar) {
                            return Character.compare(nextChar, strB.charAt(0));
                        }
                    }
                    return Integer.compare(strA.length(), strB.length()); // 긴게 앞 
                }
            }

            // 길이도 같고 모든 자리도 같다면 동일한 숫자
            return 0;
        }
    };

    // 퀵정렬 함수
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);  // 피벗을 기준으로 배열을 분할
            quickSort(arr, left, pivotIndex - 1);  // 왼쪽 부분 배열 정렬
            quickSort(arr, pivotIndex + 1, right);  // 오른쪽 부분 배열 정렬
        }
    }

    // 피벗을 기준으로 배열을 분할하는 함수
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];  // 마지막 요소를 피벗으로 선택
        int i = left - 1;  // 작은 요소들의 끝 위치를 나타내는 인덱스

        for (int j = left; j < right; j++) {
            if (customComparator.compare(arr[j], pivot) < 0) {  // 커스텀 비교 조건 사용
                i++;
                swap(arr, i, j);
            }
        }

        // 피벗을 올바른 위치에 놓기 위해 교환
        swap(arr, i + 1, right);
        return i + 1;  // 피벗의 최종 위치 반환
    }

    // 배열의 두 요소를 교환하는 함수
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String solution(int[] numbers) {
    	
    	int n = numbers.length;
    	
    	int i = 0;
        for (i = 0; i < n; i++) {
            if (numbers[i] != 0)
                break;
        }
        if (i == n)
            return "0";
        
        quickSort(numbers, 0, n - 1);

        
        // StringBuilder를 사용하여 배열 요소를 하나의 문자열로 변환
        StringBuilder sb = new StringBuilder();

        for (int num : numbers) {
            sb.append(num + " ");  // 각 숫자를 이어붙임
        }

        String result = sb.toString();  // 최종 문자열로 변환
        return result;
    }


}