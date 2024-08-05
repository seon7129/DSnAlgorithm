
public class MatrixMulti {

	public static void main(String[] args) {
		int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
		int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		int[][] result = solution(arr1, arr2);
		
		for(int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int resultLen1 = arr1.length;
		int resultLen2 = arr2[0].length;
		int innerLen = arr2.length;
		
        int[][] result = new int[resultLen1][resultLen2];
        int cal = 0;
        int[] temp1 = new int[innerLen];
        int[] temp2 = new int[innerLen];

        for (int i = 0; i < resultLen1; i++) { // arr1
        	for (int j = 0; j < resultLen2; j++) { // arr2
        		for (int k = 0; k < innerLen; k++) {
        			result[i][j] += arr1[i][k] * arr2[k][j];
        		}
            	
//        		for (int k = 0; k < innerLen; k++) { // arr1
//        			temp1[k] = arr1[i][k];
//            		System.out.println("arr1[i][k] " + i + " " + k + " = " + arr1[i][k]);
//                }
//        		for (int l = 0; l < innerLen; l++) { // arr2 
//        			temp2[l] = arr2[l][j];
//      	        	System.out.println("arr2[l][j] " + l + " " + j + " = " + arr2[l][j]);
//        		}
//        		
//        		for (int n = 0; n < innerLen; n++) {
//        			cal += temp1[n] * temp2[n];
//        		}
//        		
//        		result[i][j] = cal;
//        		cal = 0;
            }
        }
        
        
        
        return result;
    }

}
