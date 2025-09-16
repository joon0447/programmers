class Solution {
    public int solution(String s) {
        int same = 0, diff = 0;
        boolean div = true;
        char first = ' ';
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            if(div){
                first = s.charAt(i);
                div = false;
                same++;
            }else{
                if(first == s.charAt(i)) same++;
                else diff++;
                            
                if(same == diff){
                    answer++;
                    div = true;
                }
            }
            
            if(same != diff){
                if(i == s.length()-1) answer++;
            }
        }
        
        return answer;
    }
}
