import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];
        
        for(String str : keymap){
            for(int i=0; i<str.length(); i++){
                char key = str.charAt(i);
                
                int value = map.getOrDefault(key, i+1);
                map.put(key, Math.min(value, i+1));
            }
        }
        
        for(int i=0; i<targets.length; i++){
            String target = targets[i];
            for(int j=0; j<target.length(); j++){
                char c = target.charAt(j);
                if(map.containsKey(c)){
                    answer[i] += map.get(c);
                }else{
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
