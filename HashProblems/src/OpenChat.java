import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenChat {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		for (String s : solution(record)) {
			System.out.println(s);
			// "Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."
		}
	}
	
	static class Save {
		
		String userid;
		char type; // E, L
		
		public Save(String userid, char type) {
			this.userid = userid;
			this.type = type;
		}
	}
	
	public static String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<>(); // userid, nickname
		List<Save> save = new ArrayList<>();
        List<String> result = new ArrayList<>();
        String[] split = null;
        
        for (String str : record) {
        	split = str.split(" ");
        	if (split.length == 3)
        		map.put(split[1], split[2]);
        	
        	switch(split[0]) {
        	case "Enter":
        		save.add(new Save(split[1], 'E'));	
        		break;
        	case "Leave":
        		save.add(new Save(split[1], 'L'));
        		break;
        	case "Change":
        		// map.put으로 이미 수정 완료 
        		break;
        	}
        }
        
        for (Save s : save) {
        	switch(s.type) {
        	case 'E':
        		result.add(map.get(s.userid) + "님이 들어왔습니다.");
        		break;
        	case 'L':
        		result.add(map.get(s.userid) + "님이 나갔습니다.");
        		break;
        	}
        }
        
        return result.stream().toArray(String[]::new); // List<String> -> String[]
    }

}
