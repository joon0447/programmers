import java.util.*;

class Solution {
    public int solution(String dartResult) {
        List<Integer> list = new ArrayList<>();
        
        // 숫자 담기
        String tmp = "";
        
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if(c=='S' || c== 'D' || c=='T'){
                int score = Integer.parseInt(tmp);
                tmp = "";
                if(c=='D'){
                    score *= score;
                }else if(c=='T'){
                    score *= score * score;
                }
                list.add(score);
            }else if(c=='*' || c=='#'){
                if(c=='*'){
                    if(list.size() == 1){
                        int tmpScore = list.get(0) * 2;
                        list.remove(0);
                        list.add(tmpScore);
                    }else{
                        int tmpScore = list.get(list.size()-1)*2;
                        int prevScore = list.get(list.size()-2);
                        list.remove(list.size()-1);
                        list.remove(list.size()-1);
                        list.add(prevScore *2);
                        list.add(tmpScore);
                    }
                }else{
                    int tmpScore = list.get(list.size()-1) * -1;
                    list.remove(list.size()-1);
                    list.add(tmpScore);
                }
            }else{
                tmp += c+"";
            }
        }
        
        int total = 0;
        for(int i=0; i<list.size(); i++){
            total += list.get(i).intValue();
        }
        return total;
    }
}
