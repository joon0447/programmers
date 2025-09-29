import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        table.put(6, 1);
        table.put(5, 2);
        table.put(4, 3);
        table.put(3, 4);
        table.put(2, 5);
        int pick = 0;
        int zero = 0;
        for(int i=0; i<lottos.length; i++){
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]) pick++;
            }
            if(lottos[i]==0) zero++;
        }
        
        int max = 0, min = 0;
        if(pick+zero >= 6) max = table.get(6);
        else if(pick+zero < 2) max = 6;
        else max = table.get(pick+zero);
        
        if(pick < 2) min = 6;
        else min = table.get(pick);
        
        int[] answer = new int[2];
        answer[0] = max;
        answer[1] = min;
        return answer;
        
    }
}
