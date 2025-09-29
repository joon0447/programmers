import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Set<String> filterReport = new HashSet<>(Arrays.asList(report));
        Map<String, Integer> reportMap = new HashMap<>();
        
        for(String s : filterReport){
            String target = s.split(" ")[1];
            reportMap.put(target, reportMap.getOrDefault(target, 0) + 1);
        }
        
        Set<String> bannedId = new HashSet<>();
        for(String id : reportMap.keySet()){
            if(reportMap.get(id) >= k){
                bannedId.add(id);
            }
        }
        
        int[] answer = new int[id_list.length];
        for(String s : filterReport){
            String id = s.split(" ")[0];
            String target = s.split(" ")[1];
            
            if(bannedId.contains(target)){
                int index = Arrays.asList(id_list).indexOf(id);
                answer[index]++;
            }
        }

        
        return answer;
    }
}
