import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String name : participant){
            map.merge(name, 1, Integer::sum);
        }
        
        for(String name : completion){
            map.merge(name, -1, Integer::sum);
            if (map.get(name) == 0) map.remove(name);
        }
        
        return map.keySet().stream().findFirst().get();
    }
}
