import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        //survey[] 0 -> 비동의 , surver[0] 1 -> 동의
        //choices -> 1 매우 비동의 (3점) / 2 비동의 (2점) / 3 약간 비동의 (1점)
        //           4 모르겠음 (0점) / 5 약간 동의 (1점) / 6 동의 (2점) / 7 매우 동의 (3점)
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        
        for(int i=0; i<survey.length; i++){
            String no = survey[i].substring(0,1);
            String yes = survey[i].substring(1);
            int score = choices[i];
            if(score <= 3){
                map.put(no, map.get(no)+(4-score));
            }else if(score > 4){
                map.put(yes, map.get(yes)+(score-4));
            }
        }
        
        if(map.get("R") >= map.get("T")) answer += "R";
        else answer += "T";
        
        if(map.get("C") >= map.get("F")) answer += "C";
        else answer += "F";
        
        if(map.get("J") >= map.get("M")) answer += "J";
        else answer += "M";
        
        if(map.get("A") >= map.get("N")) answer += "A";
        else answer += "N";
        
        
        return answer;
    }
}
