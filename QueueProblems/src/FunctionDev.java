import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class FunctionDev {
	
	public static void main(String[] args) {
		
		int[] p = {93, 30, 55};
		int[] s = {1, 30, 5};
		System.out.println(Arrays.toString(solution(p,s))); // 2 1

	}

	public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> prog = new ArrayDeque<>();
        Queue<Integer> speed = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
        	prog.add(progresses[i]);
        	speed.add(speeds[i]);
        }
        
        int time = 0;
        int frontVal = 0;
        
        while (!prog.isEmpty()) {
        	int cnt = 0;
        	
        	while (frontVal < 100) {
        		time++;
        		frontVal = prog.peek() + time * speed.peek();
        	}
        	while (frontVal >= 100 && !prog.isEmpty()) {
        		prog.poll();
        		speed.poll();
        		cnt++;
        		if (!prog.isEmpty())
        			frontVal = prog.peek() + time * speed.peek();
        	}
        	result.add(cnt);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}
