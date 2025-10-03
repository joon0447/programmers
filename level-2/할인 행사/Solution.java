import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        HashMap<String, Integer> copyMap;
        for(int i=0; i<=discount.length-10; i++){
            copyMap = new HashMap<>();
            copyMap.putAll(map);
            for(int j=i; j<i+10; j++){
                if(copyMap.containsKey(discount[j])){
                    copyMap.put(discount[j], copyMap.get(discount[j])-1);
                    if(copyMap.get(discount[j])==0) copyMap.remove(discount[j]);
                }
            }
            
            if(copyMap.size() == 0) answer++;
        } 
        return answer; 
    }
}