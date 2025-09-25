import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int i : tangerine){
            countMap.put(i, countMap.getOrDefault(i,0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Collections.reverseOrder());
        
        int result = 0;
        int sum = 0;
        for(int c : counts){
            sum += c;
            result++;
            if(sum >= k) break;
        }
        
        return result;
    }
}
