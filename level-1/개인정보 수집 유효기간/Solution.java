import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayYear = Integer.parseInt(today.split("\\.")[0]);
        int todayMonth = Integer.parseInt(today.split("\\.")[1]);
        int todayDay = Integer.parseInt(today.split("\\.")[2]);
        
        Map<String, Integer> termsMap = new HashMap<>();
        for(String str : terms){
            termsMap.put(str.split(" ")[0], Integer.parseInt(str.split(" ")[1]));
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<privacies.length; i++){
            String str = privacies[i];
            String date = str.split(" ")[0];
            String term = str.split(" ")[1];
            
            int termsMonth = termsMap.get(term);
            
            int year = Integer.parseInt(date.split("\\.")[0]);
            int month = Integer.parseInt(date.split("\\.")[1]);
            int day = Integer.parseInt(date.split("\\.")[2]);
            
            month += termsMonth;
            if(month  > 12){
                year += (month-1) / 12;
                month = (month-1) %12 +1;
            }
            

            day -= 1;
            if(day == 0){
                month -= 1;
                if(month == 0){
                    year -= 1;
                    month = 12;
                }
                day = 28; 
            }
            
            if(todayYear > year || (todayYear == year && todayMonth > month) || (
            todayYear == year && todayMonth == month && todayDay > day)){
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
