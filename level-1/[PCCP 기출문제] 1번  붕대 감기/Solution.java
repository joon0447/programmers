import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = health;
        int maxTime = 0;
        
        int healMaxTime = bandage[0];
        int healAmount = bandage[1];
        int healBonus = bandage[2];
        
        int healTime = 0;
        for(int[] attack : attacks){
            if(attack[0] > maxTime) maxTime = attack[0];
            map.put(attack[0], attack[1]);
        }
        
        for(int i=1; i<=maxTime; i++){
            // 공격 안하면 체력 회복
            if(!map.containsKey(i)){
                if(answer < health){
                    healTime++;
                    answer += healAmount;
                    if(healTime == healMaxTime){
                        answer += healBonus;
                        healTime = 0;
                    }
                    if(answer > health) answer = health;
                }
            }else{
                int damage = map.get(i);
                healTime = 0;
                answer -= damage;
                if(answer <= 0) return -1;
            }
        }
        
        return answer;
    }
}
