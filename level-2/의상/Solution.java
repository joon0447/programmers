import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String category = clothes[i][1];
            map.put(category, map.getOrDefault(category,1) + 1);
        }
        
        int answer = 1;
        for(String key : map.keySet()){
            answer *= map.get(key);
        }
        
        return answer-1;
    }
}