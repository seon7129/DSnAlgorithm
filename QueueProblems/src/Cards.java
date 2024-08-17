import java.util.ArrayDeque;
import java.util.Queue;

public class Cards {

	public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new ArrayDeque<>();
        Queue<String> q2 = new ArrayDeque<>();
        
        for (int i = 0; i < cards1.length; i++) {
        	q1.add(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
        	q2.add(cards2[i]);
        }
        
        for (int i = 0; i < goal.length; i++) {
        	if (goal[i].equals(q1.peek())) {
        		q1.poll();
        	}
        	else if (goal[i].equals(q2.peek())) {
        		q2.poll();
        	}
        	else {
        		return "No";
        	}
        }
        
        return "Yes";
    }
	
}
