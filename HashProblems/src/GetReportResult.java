import java.util.Arrays;
import java.util.HashMap;

public class GetReportResult {

	public static void main(String[] args) {
		String[] id = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		System.out.println(Arrays.toString(solution(id,report,k)));
		
		
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
        
		HashMap<String,Integer> idHash = new HashMap<>(); // key: username, value: index값 
		HashMap<String,Integer> reportHash = new HashMap<>(); // key: report, value: 의미없음
		int[] reportSave = new int[id_list.length]; // idx에 해당하는 유저의 신고받은 횟수를 저장
		int[] result = new int[id_list.length]; // idx에 해당하는 유저의 메일 받은 횟수를 저장
        
		for (int i = 0; i < id_list.length; i++) {
			idHash.put(id_list[i], i); 
		}
		
		for (int i = 0; i < report.length; i++) {
			// 중복 제거 
			reportHash.put(report[i], i); 
		}
		
		// reportSave에 신고받은 횟수를 저장
		int idx = 0;
		for (String r : reportHash.keySet()) {
			String[] split = r.split(" ");
			idx = idHash.get(split[1]);
			reportSave[idx]++;
			
			// 신고수가 k가 되면, hash를 모두 읽어, 신고한 유저를 result에 저장 
//						if (reportSave[idx] == k) {
//							for (String rr : reportHash.keySet()) {
//								String[] split2 = rr.split(" ");
//								if (split[1].equals(split2[1])) {
//									idx2 = idHash.get(split2[0]);
//									result[idx2]++;
//								}
//							}
//						}
		}
		
		// k 이상 신고받은 사람을 신고한 사람을 result에 저장 
		for (String r : reportHash.keySet()) {
			String[] split = r.split(" ");
			
			if (reportSave[idHash.get(split[1])] >= k) {
				result[idHash.get(split[0])]++;
			}
		}
		
        return result;
    }

}
