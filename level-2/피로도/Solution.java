import java.util.*;

class Solution {
    
    int maxCount = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons, visited);
        return maxCount;
    }
    
    void dfs(int fatigue, int count, int[][] dungeons, boolean[] visited){
        maxCount = Math.max(maxCount, count);
        
        for(int i=0; i<dungeons.length; i++){
            int need =dungeons[i][0];
            int cost =dungeons[i][1];
            
            if(!visited[i] && fatigue >= need){
                visited[i] = true;
                dfs(fatigue - cost, count +1, dungeons, visited);
                visited[i] = false;
            }
        }
    }
}