import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> dayList = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            int day = 1;
            while(progresses[i] + speeds[i] * day < 100) day++;
            dayList.add(day);
        }

        
        int last = dayList.get(0);
        int count = 1;
        for(int i=1; i<dayList.size(); i++){
            // 앞에 있는게 더 늦게
            if(dayList.get(i) <= last) count++;
            // 앞에 있는게 더 빨리
            else{
                answer.add(count);
                count = 1;
                last = dayList.get(i);
            }
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}