import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        //선물을 더 적게 준 사람이 선물 보냄
        //선물 기록이 없다면 선물 지수가 작은 사람이 선물 보냄 (같으면 다음 달 선물 주고받지 않음)
        // 선물 지수 = 이번 달 친구들에게 준 선물 - 이번 달 받은 선물
        HashMap<String, Integer> friendsMap = new HashMap<>();
        for(int i=0; i<friends.length; i++){
            friendsMap.put(friends[i], i);
        }
        
        int[] giftScore = new int[friends.length];
        int[][] giftGraph = new int[friends.length][friends.length];
        
        for(String gift : gifts) {
            String[] giftName = gift.split(" ");
            giftScore[friendsMap.get(giftName[0])]++;
            giftScore[friendsMap.get(giftName[1])]--;
            giftGraph[friendsMap.get(giftName[0])][friendsMap.get(giftName[1])]++;
        }
        
        int answer = 0;
        for(int i=0; i<friends.length; i++){
            int count = 0;
            for(int j=0; j<friends.length; j++){
                if(i==j) continue;
                
                if(giftGraph[i][j] > giftGraph[j][i] ||
                    (giftGraph[i][j] == giftGraph[j][i] && giftScore[i] > giftScore[j])){
                    count++;
                }
                
                if(answer < count) answer = count;
            }
        }
        
        return answer;
    }
}
