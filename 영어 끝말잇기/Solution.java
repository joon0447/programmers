import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        char last = words[0].charAt(words[0].length()-1);
        int[] answer = new int[]{0,0};
        
        for(int i=1; i<words.length; i++){
            String str = words[i];
            //이미 말한 단어를 말했을 때
            if(list.contains(str)){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            }
            
            //첫 글자를 잘못 말했을 때
            if(str.charAt(0) != last){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            }
            
            list.add(str);
            last = str.charAt(str.length()-1);
        }
        
        return answer;
        
        
    }
}
