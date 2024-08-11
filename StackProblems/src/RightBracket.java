public class RightBracket {

	boolean solution(String s) {
        boolean answer = true;

        String[] arr = s.split("");
        String[] stack = new String[arr.length];
        
        if (arr.length % 2 == 1 
        		|| arr[0].equals(")") 
        		|| arr[arr.length-1].equals("("))
        	return false;
        
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i].equals(")") && !stack[0].equals("0")) {
        		if (stack[idx-1].equals("(")) {
        			stack[idx-1] = "0";
        			idx--;
        			continue;
        		}
        	}
        	stack[idx] = arr[i];
        	idx++;
        }
        
        if (stack[0].equals("0"))
        	return true;
        else
        	return false;

    }

}
